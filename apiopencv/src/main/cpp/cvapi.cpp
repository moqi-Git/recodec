//
// Created by reol on 2019-08-22.
//

#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>
#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/imgproc.hpp>
#include <opencv2/imgproc/imgproc_c.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_github_moqi_apiopencv_OpenCVApi_getVersionName(JNIEnv *env, jobject obj){
    using namespace cv;
    return env->NewStringUTF(CV_VERSION);
}

uchar *YUV420spRotate90(const uchar *src, int srcWidth, int srcHeight) {
    int wh = srcWidth * srcHeight;
    int uvHeight = srcHeight >> 1;
    int imgLen = wh * 3 / 2;
    uchar *dst = new uchar[imgLen];

    int tempindex = 0, index = 0;
    for (int i = 0; i < srcWidth; i++) {
        tempindex = wh;
        for (int j = 0; j < srcHeight; j++) {
            tempindex -= srcWidth;
            dst[index++] = src[tempindex + i];
        }
    }

    for (int i = 0; i < srcWidth; i += 2) {
        tempindex = imgLen;
        for (int j = 0; j < uvHeight; j++) {
            tempindex -= srcWidth;
            dst[index] = src[tempindex + i];
            dst[index + 1] = src[tempindex + i + 1];
            index += 2;
        }
    }

    return dst;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_github_moqi_apiopencv_OpenCVApi_findCircle(JNIEnv *env, jobject obj, jbyteArray yuv, jint width, jint height){

    jbyte *frame = env->GetByteArrayElements(yuv, JNI_FALSE);
    if(frame == nullptr){
        return env->NewByteArray(0);
    }

    cv::Mat yuvImg, binaryImg;

    uchar *dst = YUV420spRotate90((unsigned char*)frame, width, height);
    int imgLen = (width * height * 3) >> 1;
    yuvImg.create((width * 3) >> 1, height, CV_8UC1);
    memcpy(yuvImg.data, dst, imgLen * sizeof(uchar));
    cvtColor(yuvImg, binaryImg, CV_YUV2GRAY_420);

    int size = binaryImg.total() * binaryImg.elemSize();
//    uchar *bytes = new uchar[size];  // you will have to delete[] that later
//    std::memcpy(bytes,binaryImg.data,size * sizeof(uchar));

    jbyteArray ba = env->NewByteArray(size);
//    std::memcpy(ba,binaryImg.data,size * sizeof(uchar));
    env->SetByteArrayRegion(ba, 0, size, (jbyte*)binaryImg.data);

    delete[]dst;
    return ba;
}
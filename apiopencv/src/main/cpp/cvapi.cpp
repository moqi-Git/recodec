//
// Created by reol on 2019-08-22.
//

#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_github_moqi_apiopencv_OpenCVApi_getVersionName(JNIEnv *env, jobject obj){
    using namespace cv;
    return env->NewStringUTF(CV_VERSION);
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_github_moqi_apiopencv_OpenCVApi_findCircle(JNIEnv *env, jobject obj, jbyteArray yuv, jint width, jint height){



    return env->NewByteArray(0);
}
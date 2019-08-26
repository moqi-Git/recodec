package com.github.moqi.change.plugins.camera

import android.hardware.Camera
import android.util.Log
import android.view.SurfaceHolder
import java.lang.Exception


class MKCameraCompat : MKCamera {
    private val TAG = "MKCAMERA"

    private var mCamera: Camera? = null


    override fun getInstance(): MKCamera {
        try {
            mCamera = Camera.open()
            initCamera(mCamera!!)
        } catch (e: Exception) {

        }

        return this
    }

    private fun initCamera(camera: Camera) {
        val pWidth = camera.parameters.supportedPreviewSizes[0].width
        val pHeight = camera.parameters.supportedPreviewSizes[0].height
        val rWidth = camera.parameters.supportedPictureSizes[0].width
        val rHeight = camera.parameters.supportedPictureSizes[0].height
        val param = camera.parameters
        param.apply {
            setPreviewSize(pWidth, pHeight)
            setPictureSize(rWidth, rHeight)
        }

        camera.apply {
            setDisplayOrientation(90)
            setPreviewCallback { bytes, camera ->
                Log.e(TAG, "get a frame: size=${bytes.size}")
            }
        }
    }

//    private fun getAdaptPreviewSize(): Camera.Size {
//
//    }
//
//    private fun getAdaptPictureSize(): Camera.Size {
//
//    }


    override fun release() {
        mCamera?.release()
    }

    override fun takePicture() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPreviewSize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPictureSize() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startPreview() {
        mCamera?.startPreview()
    }

    override fun stopPreview() {
        mCamera?.stopPreview()
    }

    override fun setPreviewDisplay(surfaceHolder: SurfaceHolder?) {
        mCamera?.setPreviewDisplay(surfaceHolder)
    }
}
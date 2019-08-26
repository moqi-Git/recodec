package com.github.moqi.change.plugins.camera

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException
import java.lang.Exception

class MKSurfaceView constructor(
    context: Context, private val camera: MKCamera
) : SurfaceView(context), MKPreview, SurfaceHolder.Callback {
    private val TAG = "MKCAMERA"

    private val mHolder: SurfaceHolder = holder.apply {
        addCallback(this@MKSurfaceView)
    }
    private var isSurfaceCreated = false

    override fun surfaceChanged(surfaceHolder: SurfaceHolder?, format: Int, w: Int, h: Int) {
        //支持resize和rotate，暂不考虑
    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder?) {
        //释放Camera资源，好像放在外面更好
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {
        startPreview()
//        try {
//            camera.setPreviewDisplay(surfaceHolder)
//            camera.startPreview()
//        } catch (e: IOException){
//            Log.e(TAG, "error catched when camera surface view created, e:${e.message}")
//        }
    }

    fun startPreview(){
        try {
            camera.setPreviewDisplay(mHolder)
            camera.startPreview()
        } catch (e: IOException){
            Log.e(TAG, "error catched when camera surface view created, e:${e.message}")
        }
    }

    fun stopPreview(){
        try {
            camera.stopPreview()
        } catch (e: IOException){
            Log.e(TAG, "error catched when camera surface view created, e:${e.message}")
        }
    }
}
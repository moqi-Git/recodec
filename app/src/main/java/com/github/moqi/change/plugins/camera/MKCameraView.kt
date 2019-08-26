package com.github.moqi.change.plugins.camera

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 自定义封装的CameraView，纯粹为了封装API，除了preview不提供任何View上的东西
 */
class MKCameraView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), LifecycleObserver {

    private lateinit var camera: MKCamera
    private lateinit var previewView: MKSurfaceView

    init {
        initCamera()
        initPreviewView()
    }

    private fun initCamera(){
        // 暂时只用Camera1的Api，保证兼容全部机型
        camera = MKCameraCompat().getInstance()
    }

    private fun initPreviewView(){
        previewView = MKSurfaceView(context, camera)
        addView(previewView)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume(){
        previewView.startPreview()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause(){
        previewView.stopPreview()
    }

    fun releaseAll(){
        camera.release()
    }
}
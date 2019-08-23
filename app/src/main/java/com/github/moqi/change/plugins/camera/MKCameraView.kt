package com.github.moqi.change.plugins.camera

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.LifecycleObserver

/**
 * 自定义封装的CameraView，纯粹为了封装API，除了preview不提供任何View上的东西
 */
class MKCameraView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), LifecycleObserver {

    private lateinit var camera: MKCamera
    private lateinit var previewView: MKPreview

    init {
        initCamera()
        initPreviewView()
    }

    private fun initCamera(){
        // 暂时只用Camera1的Api，保证兼容全部机型
        camera = MKCameraCompat()
    }

    private fun initPreviewView(){

    }
}
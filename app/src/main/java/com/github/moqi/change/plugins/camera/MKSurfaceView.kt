package com.github.moqi.change.plugins.camera

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MKSurfaceView constructor(
    context: Context, private val camera: MKCamera
) : SurfaceView(context), MKPreview, SurfaceHolder.Callback {


    private var isSurfaceCreated = false

    init {

    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder?, format: Int, w: Int, h: Int) {

    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder?) {

    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder?) {

    }
}
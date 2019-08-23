package com.github.moqi.change.plugins.camera

/**
 * 统一封装Camera功能，以供外部调用
 * 内部实现随时支持切换Camera2的api
 */
interface MKCamera {

    fun open()

    fun release()

    fun takePicture()

    fun setPreviewSize()

    fun setPictureSize()

//    fun startPreview()
//
//    fun stopPreview()
}
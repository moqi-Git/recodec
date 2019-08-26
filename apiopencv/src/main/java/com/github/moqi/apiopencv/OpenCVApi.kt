package com.github.moqi.apiopencv

class OpenCVApi{

    external fun getVersionName(): String

    external fun findCircle(data: ByteArray, width: Int, height: Int): ByteArray

    companion object{
        init {
            System.loadLibrary("apiopencv")
        }
    }
}
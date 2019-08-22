package com.github.moqi.apiopencv

class OpenCVApi{

    external fun getVersionName(): String

    companion object{
        init {
            System.loadLibrary("apiopencv")
        }
    }
}
package com.github.moqi.change.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.moqi.change.R
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)


    }


    override fun onDestroy() {
        super.onDestroy()
        camera_view.releaseAll()
    }
}

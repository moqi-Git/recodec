package com.github.moqi.change.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.moqi.apiopencv.OpenCVApi
import com.github.moqi.change.R
import com.github.moqi.change.adapter.MainFuncAdapter
import com.github.moqi.change.beans.FuncItemBean
import com.github.moqi.change.viewext.MarginDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        setupMenu()
        setupTitle()

        rv_main.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_main.addItemDecoration(MarginDecoration(0, 18, 0, 0))
        rv_main.adapter = MainFuncAdapter(arrayListOf(
            FuncItemBean(R.mipmap.ic_launcher_round, "信息-分析", "获取音视频文件详细信息，以及app支持的处理方式"),
            FuncItemBean(R.mipmap.ic_launcher_round, "解码-分流", "解码文件，取出流进行操作"),
            FuncItemBean(R.mipmap.ic_launcher_round, "合流-编码", "将一些文件编码，生成新的音视频文件"),
            FuncItemBean(R.mipmap.ic_launcher_round, "图片-更生", "单帧图像转格式"),
            FuncItemBean(R.mipmap.ic_launcher_round, "图片-识别", "对答题卡识别入口，全重构"),
            FuncItemBean(R.mipmap.ic_launcher_round, "功能-查看", "查看当前版本支持的功能，以及规划中的功能")
        )).apply {
            clickEvent = {v, p ->

                when(p){
                    5 -> {
                        val version = OpenCVApi().getVersionName()
                        Toast.makeText(this@MainActivity, "$version", Toast.LENGTH_SHORT).show()

                    }
                }
//                Toast.makeText(this@MainActivity, "$p", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun setupMenu(){
        drawerToggle = ActionBarDrawerToggle(this, drawer_main, toolbar_main,
            R.string.app_name,
            R.string.app_name
        )
        drawer_main.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_main.setNavigationItemSelectedListener {
            drawer_main.closeDrawer(Gravity.LEFT)
            when(it.itemId){
                R.id.nav_item_about -> {
                    startActivity(Intent(this, AboutActivity::class.java))
                }
                R.id.nav_item_cache -> {

                }
                R.id.nav_item_help -> {

                }
                R.id.nav_item_history -> {

                }
                R.id.nav_item_setting -> {

                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    private fun setupTitle(){
        val actionBar = supportActionBar ?: return
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeButtonEnabled(true)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

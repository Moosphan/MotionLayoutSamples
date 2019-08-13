package com.moos.constraint.practice

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.moos.constraint.R

class AppBarMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_with_app_bar)

        applyMotionWithAppBar()
    }

    private fun applyMotionWithAppBar() {
        val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/5*3)
            Log.e("AppBarMotionActivity", "AppBar移动的距离：$seekPosition")
            motionLayout.progress = 1 - seekPosition
        })
    }
}
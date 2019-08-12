package com.moos.constraint.practice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.design.widget.AppBarLayout
import com.moos.constraint.R

class MotionSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_sample_step5)
        initMotion()
    }

    private fun initMotion() {
        val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/2)
            motionLayout.progress = seekPosition
        })
    }
}

package com.moos.constraint.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import android.util.Log
import com.moos.constraint.R
import kotlinx.android.synthetic.main.activity_motion_with_app_bar.*

/**
 * Created by moosphon on 2019.08.12
 * tips: just for testing some samples about MotionLayout.
 */
class MotionSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_motion_sample)
        setContentView(R.layout.activity_motion_sample_step1)
        //initMotion()
        //applyMotionWithAppBar()
    }

    private fun initMotion() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/2)
            motionLayout.progress = seekPosition
        })
    }

    private fun applyMotionWithAppBar() {
        val appBarLayout = findViewById<AppBarLayout>(R.id.appBarLayout)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/5*3)
            Log.e("MotionSampleActivity", "AppBar移动的距离：$seekPosition")
            motionLayout.progress = 1 - seekPosition
        })
    }
}

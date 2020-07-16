package com.moos.constraint.practice

import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.moos.constraint.R
import kotlinx.android.synthetic.main.activity_motion_with_app_bar.*

class AppBarMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_with_app_bar)

        applyMotionWithAppBar()
    }

    private fun applyMotionWithAppBar() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            val seekPosition = -verticalOffset / (appBarLayout.totalScrollRange.toFloat()/5*3)
            motionLayout.progress = 1 - seekPosition
        })
    }
}
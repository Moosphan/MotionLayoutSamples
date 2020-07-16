package com.moos.constraint.widget

import android.content.Context
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import android.util.AttributeSet

class MotionToolBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        //progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
        val seekPosition = -verticalOffset / (appBarLayout?.totalScrollRange!!.toFloat()/5*3)
        progress = 1 - seekPosition
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}
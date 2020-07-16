package com.moos.constraint.widget

import android.content.Context
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.drawerlayout.widget.DrawerLayout
import android.util.AttributeSet
import android.view.View

class DrawerContentLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), androidx.drawerlayout.widget.DrawerLayout.DrawerListener {
    override fun onDrawerStateChanged(newState: Int) {
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        progress = slideOffset
    }

    override fun onDrawerClosed(drawerView: View) {
    }

    override fun onDrawerOpened(drawerView: View) {
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? androidx.drawerlayout.widget.DrawerLayout)?.addDrawerListener(this)
    }
}
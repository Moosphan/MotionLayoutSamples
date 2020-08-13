package com.moos.constraint.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moos.constraint.R
import com.moos.constraint.widget.PageFragment
import kotlinx.android.synthetic.main.activity_motion_with_lottie.*

/**
 * the practice of viewpager motion with lottie animation.
 * @author Moosphon on 2019/08/14
 */
class LottieMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_with_lottie)
        applyViewPagerMotion()
    }

    private fun applyViewPagerMotion() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addPage("Now", R.layout.holder_layout)
        adapter.addPage("Discover", R.layout.holder_layout)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(header as androidx.viewpager.widget.ViewPager.OnPageChangeListener)
    }
}


class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentPagerAdapter(fm) {

    private val fragmentList = ArrayList<androidx.fragment.app.Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    private fun addFragment(fragment: androidx.fragment.app.Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    fun addPage(s: String, layout: Int) {
        val page = PageFragment()
        val arg = Bundle()
        arg.putInt("layout", layout)
        page.arguments = arg
        addFragment(page, s)
    }
}
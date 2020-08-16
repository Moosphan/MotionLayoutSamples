package com.moos.constraint

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.moos.constraint.practice.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    class NoScrollLinearLayoutManager(context: Context?) : LinearLayoutManager(context) {
        private var scrollable = true

        fun enableScrolling() {
            scrollable = true
        }

        fun disableScrolling() {
            scrollable = false
        }

        override fun canScrollVertically(): Boolean {
            val canScroll = super.canScrollVertically() && scrollable
            Log.e("MainActivity", "当前是否能纵向滑动：$canScroll")
            return canScroll
        }



        override fun canScrollHorizontally() =
            super.canScrollVertically()

                    && scrollable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerView.layoutManager = NoScrollLinearLayoutManager(this)

        val adapter = EntranceListAdapter(this)
        recyclerView.adapter = adapter
        adapter.setOnSlideCallback {
            if (it) {
                (recyclerView.layoutManager as NoScrollLinearLayoutManager).enableScrolling()
                adapter.hideDialog()
            }
            else
                (recyclerView.layoutManager as NoScrollLinearLayoutManager).disableScrolling()
        }

        adapter.setOnProgressListener {
            adapter.showDialog("进度为：$it")
        }
        adapter.setOnEntranceSelectListener {
            when(it) {
                0 -> startActivity(Intent(this, MotionSampleActivity::class.java))
                1 -> startActivity(Intent(this, MultiBallActivity::class.java))
                2 -> startActivity(Intent(this, AppBarMotionActivity::class.java))
                3 -> startActivity(Intent(this, DrawerMotionActivity::class.java))
                4 -> startActivity(Intent(this, LottieMotionActivity::class.java))
                5 -> {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.LAYOUT_ID_KEY, R.layout.scene_search_anim)
                    startActivity(intent)
                }
                6 -> startActivity(Intent(this, UserGuideActivity::class.java))
                7 -> {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.LAYOUT_ID_KEY, R.layout.scene_key_cycle_sample)
                    startActivity(intent)
                }
            }
        }
    }
}

package com.moos.constraint

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.moos.constraint.practice.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = EntranceListAdapter(this)
        recyclerView.adapter = adapter
        adapter.setOnEntranceSelectListener {
            when(it) {
                0 -> startActivity(Intent(this, MotionSampleActivity::class.java))
                1 -> startActivity(Intent(this, MultiBallActivity::class.java))
                2 -> startActivity(Intent(this, AppBarMotionActivity::class.java))
                3 -> startActivity(Intent(this, DrawerMotionActivity::class.java))
                4 -> startActivity(Intent(this, LottieMotionActivity::class.java))
//                5 -> {
//                    val intent = Intent(this, DetailActivity::class.java)
//                    intent.putExtra(DetailActivity.LAYOUT_ID_KEY, R.layout.scene_search_anim)
//                    startActivity(intent)
//                }
                5 -> startActivity(Intent(this, UserGuideActivity::class.java))
                6 -> {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.LAYOUT_ID_KEY, R.layout.scene_key_cycle_sample)
                    startActivity(intent)
                }
            }
        }
    }
}

package com.moos.constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    private fun getLayoutId(): Int {
        return intent.getIntExtra(LAYOUT_ID_KEY, -1)
    }

    companion object {
        const val LAYOUT_ID_KEY = "124"
    }
}

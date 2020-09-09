package com.moos.constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.moos.constraint.adapter.MotionListAdapter
import kotlinx.android.synthetic.main.activity_motion_list.*

class MotionListActivity : AppCompatActivity() {

    private val data = arrayListOf<ContactPerson>(
        ContactPerson("Cherry Lilly, US", R.drawable.ic_user_lady2, "Today is rainy."),
        ContactPerson("Michel Trade, UK", R.drawable.ic_user_man1, "A year passed again"),
        ContactPerson("Allen Jack, Germany", R.drawable.ic_user_lady1, "Tomorrow is sunny\uD83C\uDF1E"),
        ContactPerson("Jimmy Peter, Japan", R.drawable.ic_user_man2, "We never like what we have.."),
        ContactPerson("Sandy Joke, Canada", R.drawable.ic_user_man1, "Now, I remind of you")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MotionListAdapter(this, data)
        recyclerView.adapter = adapter
    }

    data class ContactPerson(
        val name: String,
        val avatar: Int,
        val desc: String
    )
}
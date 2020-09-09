package com.moos.constraint.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import com.moos.constraint.MotionListActivity
import com.moos.constraint.R

class MotionListAdapter(val context: Context, val list: ArrayList<MotionListActivity.ContactPerson>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MotionViewHolder(mLayoutInflater.inflate(
            R.layout.motion_list_rv_item, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userText = holder.itemView.findViewById<TextView>(R.id.item_username)
        val userDesc = holder.itemView.findViewById<TextView>(R.id.item_desc)
        val userAvatar = holder.itemView.findViewById<ImageView>(R.id.item_user_avatar)
        val collectButton = holder.itemView.findViewById<FrameLayout>(R.id.box_collect)
        val deleteButton = holder.itemView.findViewById<FrameLayout>(R.id.box_delete)
        val motionBox = holder.itemView.findViewById<MotionLayout>(R.id.motionContainer)
        userText.text = list[position].name
        userDesc.text = list[position].desc
        userAvatar.setImageResource(list[position].avatar)
        collectButton.setOnClickListener {
            motionBox.transitionToStart()
            Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show()
        }

        deleteButton.setOnClickListener {
            Toast.makeText(context, "移除成功", Toast.LENGTH_SHORT).show()
            list.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }
    }

    class MotionViewHolder(item: View): RecyclerView.ViewHolder(item)
}
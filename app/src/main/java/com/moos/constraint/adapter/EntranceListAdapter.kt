package com.moos.constraint.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.moos.constraint.R

class EntranceListAdapter(ctx: Context):  androidx.recyclerview.widget.RecyclerView.Adapter<EntranceListAdapter.EntranceViewHolder>(){

    private val entranceData = arrayListOf(
        Entrance(
            R.drawable.ic_announcement,
            "A ball translation",
            "小球运动"
        ),
        Entrance(
            R.drawable.ic_pie_chart,
            "Balls sport",
            "多球运动"
        ),
        Entrance(
            R.drawable.ic_presentation,
            "Motion applies with AppBar",
            "与AppBarLayout联动"
        ),
        Entrance(
            R.drawable.ic_savings,
            "Motion applies with Drawer",
            "与DrawerLayout联动"
        ),
        Entrance(
            R.drawable.ic_idea,
            "Motion applies with ViewPager",
            "和ViewPager、Lottie联动"
        ),
        Entrance(
            R.drawable.ic_browser,
            "Motion with KeyTrigger",
            "KeyTrigger的使用"
        ),
        Entrance(
            R.drawable.ic_user,
            "Multi scenes in User guide page",
            "多状态实现用户引导页"
        ),
        Entrance(
            R.drawable.ic_chat,
            "Motion with KeyCycle",
            "KeyCycle实现钮扣抖动效果"
        ),
        Entrance(
            R.drawable.ic_wallet,
            "Motion with RecyclerView",
            "在RecyclerView中的应用"
        )
    )


    private var mListener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): EntranceViewHolder {
        return EntranceViewHolder(
            View.inflate(
                parent.context,
                R.layout.entrance_item_layout,
                null
            )
        )
    }

    override fun getItemCount(): Int {
        return entranceData.size
    }

    override fun onBindViewHolder(viewHolder: EntranceViewHolder, position: Int) {
        val tvDesc = viewHolder.itemView.findViewById<TextView>(R.id.entrance_item_desc)
        val tvTip = viewHolder.itemView.findViewById<TextView>(R.id.entrance_item_tip)
        val imageView = viewHolder.itemView.findViewById<ImageView>(R.id.entrance_item_ic)
        tvDesc.text = entranceData[position].info
        tvTip.text = entranceData[position].tip
        imageView.setImageResource(entranceData[position].icon)
        viewHolder.itemView.setOnClickListener {
            if (mListener != null) {
                mListener?.invoke(position)
            }
        }
    }
    /**
     * set entrance item click listener.
     */
    fun setOnEntranceSelectListener(callback: (position: Int) -> Unit) {
        mListener = callback
    }


    class EntranceViewHolder(item: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(item)

    data class Entrance(
        val icon: Int,
        val info: String,
        val tip: String = ""
    )
}
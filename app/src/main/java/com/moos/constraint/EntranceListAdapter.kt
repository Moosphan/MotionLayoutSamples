package com.moos.constraint

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class EntranceListAdapter:  androidx.recyclerview.widget.RecyclerView.Adapter<EntranceListAdapter.EntranceViewHolder>(){
    val entranceData = arrayListOf(
        Entrance(R.mipmap.ic_base, "Motion applies in basement"),
        Entrance(R.mipmap.ic_multi, "Motion applies with multi targets"),
        Entrance(R.mipmap.ic_appbar, "Motion applies with AppBar"),
        Entrance(R.mipmap.ic_drawer, "Motion applies with Drawer"),
        Entrance(R.mipmap.ic_pager, "Motion applies with ViewPager")
    )

    private var mListener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): EntranceViewHolder {
        return EntranceViewHolder(View.inflate(parent.context, R.layout.entrance_item_layout, null))
    }

    override fun getItemCount(): Int {
        return entranceData.size
    }

    override fun onBindViewHolder(viewHolder: EntranceViewHolder, position: Int) {
        val textView = viewHolder.itemView.findViewById<TextView>(R.id.entrance_item_desc)
        val imageView = viewHolder.itemView.findViewById<ImageView>(R.id.entrance_item_ic)
        textView.text = entranceData[position].info
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
        val info: String
    )
}
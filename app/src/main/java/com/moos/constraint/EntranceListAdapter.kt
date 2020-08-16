package com.moos.constraint

import android.content.Context
import android.content.DialogInterface
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class EntranceListAdapter(ctx: Context):  androidx.recyclerview.widget.RecyclerView.Adapter<EntranceListAdapter.EntranceViewHolder>(){

    val entranceData = arrayListOf(
        Entrance(R.mipmap.ic_base, "A ball translation"),
        Entrance(R.mipmap.ic_multi, "Balls sport"),
        Entrance(R.mipmap.ic_appbar, "Motion applies with AppBar"),
        Entrance(R.mipmap.ic_drawer, "Motion applies with Drawer"),
        Entrance(R.mipmap.ic_pager, "Motion applies with ViewPager"),
        Entrance(R.drawable.ic_browser, "Searching animation"),
        Entrance(R.drawable.ic_user, "Multi scenes in User guide page"),
        Entrance(R.drawable.ic_chat, "Motion with KeyCycle"),
        Entrance(R.drawable.ic_chat, "Motion with KeyCycle"),
        Entrance(R.drawable.ic_chat, "Motion with KeyCycle"),
        Entrance(R.drawable.ic_chat, "Motion with KeyCycle"),
        Entrance(R.drawable.ic_chat, "Motion with KeyCycle"),
        Entrance(R.drawable.ic_chat, "Motion with KeyCycle")
    )

    private lateinit var mDialog: AlertDialog

    private var mListener: ((position: Int) -> Unit)? = null

    private var mSlideCallback: ((slideEnable: Boolean)-> Unit)? = null
    private var mProgressListener: ((position: Int) -> Unit)? = null

    init {
        initDialog(ctx)
    }

    private fun initDialog(cxt: Context) {
        mDialog = AlertDialog.Builder(cxt)
            .setMessage("msg")
            .setTitle("title")
            .setPositiveButton("复制", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            .setNeutralButton("取消", null)
            .create()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): EntranceViewHolder {
        return EntranceViewHolder(View.inflate(parent.context, R.layout.entrance_item_layout, null))
    }

    override fun getItemCount(): Int {
        return entranceData.size
    }

    override fun onBindViewHolder(viewHolder: EntranceViewHolder, position: Int) {
        val textView = viewHolder.itemView.findViewById<TextView>(R.id.entrance_item_desc)
        val imageView = viewHolder.itemView.findViewById<ImageView>(R.id.entrance_item_ic)
        val seekBar = viewHolder.itemView.findViewById<SeekBar>(R.id.seekbar)
        textView.text = entranceData[position].info
        imageView.setImageResource(entranceData[position].icon)
        viewHolder.itemView.setOnClickListener {
            if (mListener != null) {
                mListener?.invoke(position)
            }
        }
        seekBar.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (mSlideCallback != null) {
                    mSlideCallback?.invoke(false)
                }
            } else if (event.action == MotionEvent.ACTION_UP) {
                if (mSlideCallback != null) {
                    mSlideCallback?.invoke(true)
                }
            }
            false
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (mProgressListener != null) {
                    mProgressListener?.invoke(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        viewHolder.itemView.setOnLongClickListener {
            seekBar.visibility = View.VISIBLE
            seekBar.requestFocusFromTouch()

            false
        }
    }

    public fun showDialog(msg: String) {
        mDialog.setMessage(msg)
        mDialog.show()
    }

    public fun hideDialog() {
        mDialog.hide()
    }

    /**
     * set entrance item click listener.
     */
    fun setOnEntranceSelectListener(callback: (position: Int) -> Unit) {
        mListener = callback
    }

    fun setOnProgressListener(callback: (progress: Int) -> Unit) {
        mProgressListener = callback
    }

    fun setOnSlideCallback(callback: (slide: Boolean) -> Unit) {
        mSlideCallback = callback
    }
    class EntranceViewHolder(item: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(item)

    data class Entrance(
        val icon: Int,
        val info: String
    )
}
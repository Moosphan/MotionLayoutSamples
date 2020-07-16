package com.moos.constraint.widget

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PageFragment  : androidx.fragment.app.Fragment() {

    private var layoutId = 0

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        if (args != null) {
            layoutId = args.getInt("layout")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId, container, false)
    }
}
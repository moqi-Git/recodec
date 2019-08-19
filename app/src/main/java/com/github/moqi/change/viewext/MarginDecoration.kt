package com.github.moqi.change.viewext

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginDecoration(
    private val marginTop: Int,
    private val marginBottom: Int,
    private val marginLeft: Int,
    private val marginRight: Int
    ): RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.apply {
            top = marginTop
            bottom = marginBottom
            left = marginLeft
            right = marginRight
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }
}
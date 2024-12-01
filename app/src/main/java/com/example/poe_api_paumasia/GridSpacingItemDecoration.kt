package com.example.poe_api_paumasia

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration(
    private val horizontalSpacing: Int,
    private val verticalSpacing: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {


        outRect.left = horizontalSpacing
        outRect.right = horizontalSpacing
        outRect.bottom = verticalSpacing

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = verticalSpacing
        }
    }
}

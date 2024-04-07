package com.regexbyte.habittracker.Utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spacing; // Spacing between items in pixels
    private int spanCount; // Number of columns in the grid layout

    public GridSpacingItemDecoration(int spacing, int spanCount) {
        this.spacing = spacing;
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;

        if (column == 0) {
            // First column, two rows
            outRect.left = spacing;
            outRect.right = spacing / 2;
            if (position >= spanCount) {
                outRect.top = spacing;
            }
        } else if (column == 1) {
            // Second column, one row
            outRect.right = spacing / 2;
            outRect.left = spacing;
            if (position % spanCount == 1) {
                outRect.top = spacing;
            }
        }
    }
}
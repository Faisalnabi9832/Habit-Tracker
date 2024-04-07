package com.regexbyte.habittracker.Utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class CustomGridLayoutManager extends RecyclerView.LayoutManager {

    private int spanCount; // Number of columns in the grid layout

    public CustomGridLayoutManager(Context context, int spanCount) {
        this.spanCount = spanCount;
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
    }
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();
        int spanCount = this.spanCount;

        if (itemCount == 0) {
            return;
        }

        int itemWidth = getWidth() / spanCount;
        int itemHeight = getHeight() / spanCount;

        for (int i = 0; i < itemCount; i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);

            int row = i / spanCount;
            int col = i % spanCount;

            int left = col * itemWidth;
            int top = row * itemHeight;
            int right = left + itemWidth;
            int bottom = top + itemHeight;

            measureChildWithMargins(view, 0, 0);
            layoutDecorated(view, left, top, right, bottom);
        }
    }
}
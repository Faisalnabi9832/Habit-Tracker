package com.regexbyte.habittracker;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * {@link android.view.View.OnClickListener} used to translate the product grid sheet downward on
 * the Y-axis when the navigation icon in the toolbar is pressed.
 */
public class NavigationIconClickListener implements View.OnClickListener {

    public final AnimatorSet animatorSet = new AnimatorSet();
    public Context context;
    public View sheet;
    public Interpolator interpolator;
    public int height;
    public boolean backdropShown = false;
    public Drawable openIcon;
    public Drawable closeIcon;

    public NavigationIconClickListener(
            Context context, View sheet, @Nullable Interpolator interpolator,
            @Nullable Drawable openIcon, @Nullable Drawable closeIcon) {
        this.context = context;
        this.sheet = sheet;
        this.interpolator = interpolator;
        this.openIcon = openIcon;
        this.closeIcon = closeIcon;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
    }

    @Override
    public void onClick(View view) {
        backdropShown = !backdropShown;

        // Cancel the existing animations
        animatorSet.removeAllListeners();
        animatorSet.end();
        animatorSet.cancel();

        updateIcon(view);

        final int translateY = height -
                context.getResources().getDimensionPixelSize(R.dimen.shr_product_grid_reveal_height);

        ObjectAnimator animator = ObjectAnimator.ofFloat(sheet, "translationY", backdropShown ? translateY : 0);
        animator.setDuration(500);
        if (interpolator != null) {
            animator.setInterpolator(interpolator);
        }
        animatorSet.play(animator);
        animator.start();
    }

    public void updateIcon(final View view) {
        if (openIcon != null && closeIcon != null) {
            if (!(view instanceof ImageView)) {
                throw new IllegalArgumentException("updateIcon() must be called on an ImageView");
            }
            if (backdropShown) {
                new CountDownTimer(300, 300) {
                    @Override
                    public void onTick(long l) {
                        view.animate().rotation(360).setDuration(1000).start();
                    }

                    public void onFinish() {
                        ((ImageView) view).setImageDrawable(closeIcon);
                        view.setRotation(0);
                    }
                }.start();
            } else {
                new CountDownTimer(300, 300) {
                    @Override
                    public void onTick(long l) {
                        view.animate().rotation(-360).setDuration(1000).start();
                    }

                    public void onFinish() {
                        ((ImageView) view).setImageDrawable(openIcon);
                        view.setRotation(0);
                    }
                }.start();
            }
        }
    }
}

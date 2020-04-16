package com.luo.gridview01.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;

/**
 * Created by luo on 2020/4/16.
 * 放大的工具类
 */

public class Tools {
    /**
     * RelativeLayout的放大
     *
     * @param iv
     */
    public void ScaleEnlargeLayout(RelativeLayout iv) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(iv, "scaleX", 1.0f, 1.2f),
                ObjectAnimator.ofFloat(iv, "scaleY", 1.0f, 1.2f));
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    /**
     * RelativeLayout的缩小
     *
     * @param iv
     */
    public void ScaleReduceLayout(RelativeLayout iv) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(iv, "scaleX", 1.2f, 1.0f),
                ObjectAnimator.ofFloat(iv, "scaleY", 1.2f, 1.0f));
        animatorSet.setDuration(300);
        animatorSet.start();
    }
}

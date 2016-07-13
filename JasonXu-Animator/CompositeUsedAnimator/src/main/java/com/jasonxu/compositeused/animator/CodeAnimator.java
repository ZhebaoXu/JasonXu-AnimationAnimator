package com.jasonxu.compositeused.animator;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * Created by t_xuz on 7/9/16.
 * 通过代码方式编写属性动画
 */
public class CodeAnimator {

    /*
    * 平移动画
    * */
    public static void translateAnimator(View myView){
        ObjectAnimator.ofFloat(myView,"translationY",-myView.getHeight()).start();
    }

    /*
    * 改变一个view对象的背景色
    * */
    public static void BackColorAnimator(View myView){
        ValueAnimator colorAnim = ObjectAnimator.ofInt(myView,"backgroundColor",0Xffff8080,0xff8080ff);
        colorAnim.setDuration(1000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }

    /*
    * 5秒之内对view的旋转/平移/缩放/透明度都进行改变
    * */
    public static void AnimatorSetDemo(View myView) {

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(myView, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(myView, "rotationY", 180),
                ObjectAnimator.ofFloat(myView, "rotation", -90),
                ObjectAnimator.ofFloat(myView, "translationX", 0, 90),
                ObjectAnimator.ofFloat(myView, "translationY", 0, 90),
                ObjectAnimator.ofFloat(myView, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(myView, "scaleY", 1, 0.5f),
                ObjectAnimator.ofFloat(myView, "alpha", 1, 0.25f, 1)
        );
        animatorSet.setDuration(5 * 1000).start();
    }
}

package com.jasonxu.animator.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by t_xuz on 7/8/16.
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {

    /*
    * (endValue - startInt) * fraction)代表动画实际运动距离
    * */
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int) (endValue - (endValue - startInt) * fraction);
    }
}

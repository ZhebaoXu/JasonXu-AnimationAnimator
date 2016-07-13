package com.jasonxu.animator.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by t_xuz on 7/8/16.
 */
public class MyEvaluator implements TypeEvaluator<Integer> {

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int)(200 + startInt + (endValue-startInt) * fraction);
    }
}

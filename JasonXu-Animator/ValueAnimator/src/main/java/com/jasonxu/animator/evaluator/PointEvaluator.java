package com.jasonxu.animator.evaluator;

import android.animation.TypeEvaluator;

import com.jasonxu.animator.bean.Point;

/**
 * Created by t_xuz on 7/8/16.
 */
public class PointEvaluator implements TypeEvaluator<Point>{

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int startInt = startValue.getRadius();
        int endInt = endValue.getRadius();
        int curRadius = (int)(startInt+(endInt-startInt)*fraction);
        return new Point(curRadius);
    }
}

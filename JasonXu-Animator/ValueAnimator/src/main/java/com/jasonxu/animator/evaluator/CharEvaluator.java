package com.jasonxu.animator.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by t_xuz on 7/8/16.
 */
public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = (int) startValue;
        int endInt = (int) endValue;
        int curInt = (int) (startInt + (endInt - startInt) * fraction);
        char result = (char)curInt;
        return result;
    }
}

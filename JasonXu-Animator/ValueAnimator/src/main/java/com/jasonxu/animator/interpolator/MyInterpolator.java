package com.jasonxu.animator.interpolator;

import android.animation.TimeInterpolator;
import android.view.animation.BaseInterpolator;

/**
 * Created by t_xuz on 7/8/16.
 * 说明:
 * 自定义插值器步骤:
 * 1.写一个类实现 TimeInterpolator接口
 * 2.实现里面的抽象方法 getInterpolation
 *
 * getInterpolation方法说明:
 * input 代表当前动画的进度,取值范围:0~1,0代表动画开始,1代表动画结束,0.5代表动画进行到中间位置,只与时间有关,时间增加,进度也会增加
 * 返回值代表当前动画的数值进度
 */
public class MyInterpolator implements TimeInterpolator{

    /*
    *将数值进度倒序返回--即随着动画进度的推进,动画的数值进度从结束位置进行到起始位置.
    * 该方法是通过动画的进度计算数值进度的,可以有很多中变化,看你数学功底了
    * 返回值可以计算addUpdateListener中的animation.getAnimatedValue()的值,显示进度就是该函数的返回值.
    * 这个值计算公式:当前的值=100+(400-100)*显示进度 [ofInt(100,400)的情况]---是Evaluator的工作
    * */
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}

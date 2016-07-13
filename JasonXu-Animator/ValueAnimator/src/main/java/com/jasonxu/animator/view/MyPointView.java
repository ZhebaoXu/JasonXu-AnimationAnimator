package com.jasonxu.animator.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.jasonxu.animator.bean.Point;
import com.jasonxu.animator.evaluator.PointEvaluator;

/**
 * Created by t_xuz on 7/8/16.
 */
public class MyPointView extends View {

    private Point mCurPoint;
    private ValueAnimator valueAnimator;

    public MyPointView(Context context) {
        super(context);
    }

    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mCurPoint.getRadius(),paint);
        }

    }

    public void doPointAnim(){
        valueAnimator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                mCurPoint = (Point)animator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }

    public void cancelAnim(){
        if (valueAnimator!=null){
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.cancel();
        }
    }

}

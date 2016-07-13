package com.jasonxu.animator.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jasonxu.animator.R;
import com.jasonxu.animator.interpolator.MyInterpolator;

/**
 * Created by t_xuz on 7/8/16.
 */
public class InterpolatorActivity2 extends AppCompatActivity implements View.OnClickListener{
    private Button btnStart,btnCancel;
    private TextView textView;
    private ValueAnimator valueAnimator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.interpolator_layout);

        btnCancel = (Button)this.findViewById(R.id.cancel);
        btnStart = (Button)this.findViewById(R.id.start);
        textView = (TextView)this.findViewById(R.id.text);

        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InterpolatorActivity2.this,"click",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                doAnimator();
                break;
            case R.id.cancel:
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
                break;
        }
    }

    private void doAnimator(){
        valueAnimator = ValueAnimator.ofInt(0,700);
        valueAnimator.setDuration(2000);
//        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setInterpolator(new MyInterpolator());

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int)valueAnimator.getAnimatedValue();
                textView.layout(textView.getLeft(),curValue,textView.getRight(),textView.getHeight()+curValue);
            }
        });

        valueAnimator.start();
    }
}

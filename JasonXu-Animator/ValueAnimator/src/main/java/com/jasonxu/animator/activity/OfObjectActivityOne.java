package com.jasonxu.animator.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jasonxu.animator.R;
import com.jasonxu.animator.evaluator.CharEvaluator;
import com.jasonxu.animator.evaluator.ReverseEvaluator;
import com.jasonxu.animator.interpolator.MyInterpolator;

/**
 * Created by t_xuz on 7/8/16.
 */
public class OfObjectActivityOne extends AppCompatActivity implements View.OnClickListener{

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
                Toast.makeText(OfObjectActivityOne.this,"click",Toast.LENGTH_SHORT).show();
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
        valueAnimator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                char text = (char)animator.getAnimatedValue();
                textView.setText(String.valueOf(text));
            }
        });
        valueAnimator.setDuration(8000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.start();
    }
}

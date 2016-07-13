package com.jasonxu.animator.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jasonxu.animator.R;

/**
 * Created by t_xuz on 7/7/16.
 *
 */
public class SimpleSecondFragment extends BaseFragment implements View.OnClickListener{
    private Button btnStart,btnCancel;
    private TextView textView;
    private ValueAnimator valueAnimator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple_first_layout,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel = (Button)view.findViewById(R.id.cancel);
        btnStart = (Button)view.findViewById(R.id.start);
        textView = (TextView)view.findViewById(R.id.text);

        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"click",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initValueAnimator(){
        valueAnimator = ValueAnimator.ofFloat(0f,400f,50f,500f,100f,600f);
        valueAnimator.setDuration(4000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        valueAnimator.setRepeatCount(2);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float curValueFloat = (Float)valueAnimator.getAnimatedValue();
                int curValueInt = curValueFloat.intValue();
                Log.e("zhebao","curValueFloat: " + curValueFloat);
                textView.layout(curValueInt,curValueInt,curValueInt+textView.getWidth(),curValueInt+textView.getHeight());
            }
        });

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.e("zhebao","onAnimationStart: " );
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.e("zhebao","onAnimationEnd: " );
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.e("zhebao","onAnimationCancel: ");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.e("zhebao","onAnimationRepeat: " );
            }
        });
 /*       valueAnimator.addPauseListener(new ValueAnimator.AnimatorPauseListener(){
            @Override
            public void onAnimationPause(Animator animator) {

            }

            @Override
            public void onAnimationResume(Animator animator) {

            }
        });*/
        valueAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                initValueAnimator();
                break;
            case R.id.cancel:
                valueAnimator.removeAllListeners();
                valueAnimator.cancel();
                break;
        }
    }
}

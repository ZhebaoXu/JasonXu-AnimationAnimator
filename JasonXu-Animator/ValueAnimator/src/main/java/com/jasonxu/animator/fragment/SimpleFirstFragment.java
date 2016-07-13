package com.jasonxu.animator.fragment;

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

import com.jasonxu.animator.MainActivity;
import com.jasonxu.animator.R;

/**
 * Created by t_xuz on 7/7/16.
 *
 */
public class SimpleFirstFragment extends BaseFragment implements View.OnClickListener{
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
        valueAnimator = ValueAnimator.ofInt(0,400,50,500,100,600);
        valueAnimator.setDuration(4500);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int)valueAnimator.getAnimatedValue();
                Log.e("zhebao","curValue: " + curValue);
                textView.layout(curValue,curValue,curValue+textView.getWidth(),curValue+textView.getHeight());
            }
        });
        valueAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                initValueAnimator();
                break;
            case R.id.cancel:
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.cancel();
                break;
        }
    }
}

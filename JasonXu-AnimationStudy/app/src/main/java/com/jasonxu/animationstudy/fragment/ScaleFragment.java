package com.jasonxu.animationstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.jasonxu.animationstudy.R;

/**
 * Created by t_xuz on 7/3/16.
 */
public class ScaleFragment extends BaseFragment implements View.OnClickListener {
    private Button ScaleOne, ScaleTwo, ScaleThree;
    private TextView textView;

    @Override
    public int getContentViewId() {
        return R.layout.scale_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScaleOne = (Button) view.findViewById(R.id.scale_one);
        ScaleTwo = (Button) view.findViewById(R.id.scale_two);
        ScaleThree = (Button) view.findViewById(R.id.scale_three);
        textView = (TextView)view.findViewById(R.id.text);

        ScaleOne.setOnClickListener(this);
        ScaleTwo.setOnClickListener(this);
        ScaleThree.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Animation scaleAnimation;
        switch (view.getId()) {
            case R.id.scale_one:
                 scaleAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_scale);
                textView.startAnimation(scaleAnimation);
                break;
            case R.id.scale_two:
                scaleAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_scale2);
                textView.startAnimation(scaleAnimation);
                break;
            case R.id.scale_three:
                scaleAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_scale3);
                textView.startAnimation(scaleAnimation);
                break;
        }
    }
}

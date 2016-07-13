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
public class AlphaFragment extends BaseFragment{
    private Button alpha,setOne;
    private TextView textView;
    @Override
    public int getContentViewId() {
        return R.layout.alpha_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alpha = (Button)view.findViewById(R.id.alpha);
        setOne = (Button)view.findViewById(R.id.setOne);
        textView = (TextView)view.findViewById(R.id.text);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alphaAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_alpha);
                textView.startAnimation(alphaAnimation);
            }
        });

        setOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.anim_setone);
                textView.startAnimation(animation);
            }
        });
    }
}

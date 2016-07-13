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
public class RotateFragment extends BaseFragment implements View.OnClickListener{

    private Button rotateOne,rotateTwo;
    private TextView textView;

    @Override
    public int getContentViewId() {
        return R.layout.rotate_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rotateOne = (Button)view.findViewById(R.id.rotate);
        rotateTwo = (Button)view.findViewById(R.id.rotate2);
        textView = (TextView)view.findViewById(R.id.text);

        rotateOne.setOnClickListener(this);
        rotateTwo.setOnClickListener(this);
    }

    public void onClick(View view){
        Animation rotateAnimation = null;
        switch (view.getId()){
            case R.id.rotate:
                rotateAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_rotate);
                textView.startAnimation(rotateAnimation);
                break;
            case R.id.rotate2:
                rotateAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_rotate2);
                textView.startAnimation(rotateAnimation);
                break;

        }
    }
}

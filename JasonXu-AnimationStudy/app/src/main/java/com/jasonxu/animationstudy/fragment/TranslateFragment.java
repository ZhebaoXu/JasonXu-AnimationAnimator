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
public class TranslateFragment extends BaseFragment {
    private Button translate;
    private TextView textView;

    @Override
    public int getContentViewId() {
        return R.layout.traslate_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView)view.findViewById(R.id.text);
        translate = (Button)view.findViewById(R.id.translate);

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation translateAnimation = AnimationUtils.loadAnimation(mContext,R.anim.anim_translate);
                textView.startAnimation(translateAnimation);
            }
        });
    }
}

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
import com.jasonxu.animator.view.MyPointView;

/**
 * Created by t_xuz on 7/8/16.
 */
public class OfObjectActivityTwo extends AppCompatActivity implements View.OnClickListener{

    private Button btnStart,btnCancel;
    private MyPointView myPointView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.point_layout);

        btnCancel = (Button)this.findViewById(R.id.cancel);
        btnStart = (Button)this.findViewById(R.id.start);
        myPointView = (MyPointView) this.findViewById(R.id.point);

        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                myPointView.doPointAnim();
                break;
            case R.id.cancel:
                myPointView.cancelAnim();
                break;
        }
    }

}

package com.jasonxu.animationstudy;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jasonxu.animationstudy.fragment.AlphaFragment;
import com.jasonxu.animationstudy.fragment.RotateFragment;
import com.jasonxu.animationstudy.fragment.ScaleFragment;
import com.jasonxu.animationstudy.fragment.TranslateFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button scale,alpha,translate,rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initViews(){
        scale = (Button) findViewById(R.id.scale);
        alpha = (Button) findViewById(R.id.alpha);
        translate = (Button) findViewById(R.id.translate);
        rotate = (Button) findViewById(R.id.rotate);
    }

    private void initEvents(){
        scale.setOnClickListener(this);
        alpha.setOnClickListener(this);
        translate.setOnClickListener(this);
        rotate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment mFragment = null;
        switch (view.getId()){
            case R.id.scale:
                mFragment = new ScaleFragment();
                break;
            case R.id.alpha:
                mFragment = new AlphaFragment();
                break;
            case R.id.translate:
                mFragment = new TranslateFragment();
                break;
            case R.id.rotate:
                mFragment = new RotateFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content,mFragment)
                .addToBackStack(null)
                .commit();
    }
}

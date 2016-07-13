package com.jasonxu.animator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jasonxu.animator.activity.ARGBActivity;
import com.jasonxu.animator.activity.InterpolatorActivity;
import com.jasonxu.animator.activity.InterpolatorActivity2;
import com.jasonxu.animator.activity.InterpolatorActivity3;
import com.jasonxu.animator.activity.OfObjectActivityOne;
import com.jasonxu.animator.activity.OfObjectActivityTwo;
import com.jasonxu.animator.fragment.SimpleFirstFragment;
import com.jasonxu.animator.fragment.SimpleSecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_first,btn_second,btn_third,btn_fourth,btn_fifth,btn_seven,btn_six,btn_eight;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        btn_first = (Button)this.findViewById(R.id.test_one);
        btn_second = (Button)this.findViewById(R.id.test_two);
        btn_third = (Button)this.findViewById(R.id.test_three);
        btn_fourth = (Button)this.findViewById(R.id.test_four);
        btn_fifth = (Button)this.findViewById(R.id.test_5);
        btn_six = (Button)this.findViewById(R.id.test_6);
        btn_seven = (Button)this.findViewById(R.id.test_7);
        btn_eight = (Button)this.findViewById(R.id.test_8);
        container = (LinearLayout)this.findViewById(R.id.container);

        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);
        btn_third.setOnClickListener(this);
        btn_fourth.setOnClickListener(this);
        btn_fifth.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        Intent intent = null;
        switch (view.getId()){
            case R.id.test_one:
                fragment = new SimpleFirstFragment();
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            case R.id.test_two:
                fragment = new SimpleSecondFragment();
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            case R.id.test_three:
                intent = new Intent(this, InterpolatorActivity.class);
                startActivity(intent);
                break;
            case R.id.test_four:
                intent = new Intent(this, InterpolatorActivity2.class);
                startActivity(intent);
                break;
            case R.id.test_5:
                intent = new Intent(this, InterpolatorActivity3.class);
                startActivity(intent);
                break;
            case R.id.test_6:
                intent = new Intent(this, ARGBActivity.class);
                startActivity(intent);
                break;
            case R.id.test_7:
                intent = new Intent(this, OfObjectActivityOne.class);
                startActivity(intent);
                break;
            case R.id.test_8:
                intent = new Intent(this, OfObjectActivityTwo.class);
                startActivity(intent);
                break;

        }


    }
}

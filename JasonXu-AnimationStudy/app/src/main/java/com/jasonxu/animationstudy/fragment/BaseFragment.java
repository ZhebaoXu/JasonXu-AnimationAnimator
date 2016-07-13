package com.jasonxu.animationstudy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jasonxu.animationstudy.MainActivity;

/**
 * Created by t_xuz on 7/3/16.
 */
public abstract class BaseFragment extends Fragment{

    protected MainActivity mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentViewId(),container,false);
    }

    public abstract int getContentViewId();

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
}

package com.jasonxu.animator.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.jasonxu.animator.MainActivity;

/**
 * Created by t_xuz on 7/7/16.
 */
public class BaseFragment extends Fragment{
    protected MainActivity mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (MainActivity)context;
    }

    @Override
    public void onDetach() {
        mContext = null;
        super.onDetach();
    }
}

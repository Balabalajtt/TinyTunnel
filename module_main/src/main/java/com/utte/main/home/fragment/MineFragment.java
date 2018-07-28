package com.utte.main.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utte.common.base.BaseFragment;
import com.utte.main.R;
import com.utte.main.home.activity.LoginActivity;

public class MineFragment extends BaseFragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        TextView tv = view.findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MineFragment.this.getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}

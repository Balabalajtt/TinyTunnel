package com.utte.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.utte.common.base.BaseFragment;
import com.utte.module_video.R;
@Route(path = "/news/newsFragment")
public class EducationFragment extends BaseFragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_education, container, false);

        return view;
    }
}

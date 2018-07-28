package com.utte.main.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utte.common.base.BaseFragment;
import com.utte.main.R;

public class LibraryFragment extends BaseFragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_library, container, false);

        return view;
    }
}

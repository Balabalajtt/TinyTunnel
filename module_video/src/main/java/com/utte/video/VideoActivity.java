package com.utte.video;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.utte.common.base.BaseActivity;
import com.utte.module_video.R;

public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Fragment fragment = new EducationFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment).commit();

    }
}

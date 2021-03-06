package com.utte.main.home.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.utte.common.base.BaseActivity;
import com.utte.common.base.BaseFragment;
import com.utte.common.utils.Utils;
import com.utte.main.R;
import com.utte.main.home.fragment.EventFragment;
import com.utte.main.home.fragment.LibraryFragment;
import com.utte.main.home.fragment.MineFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener{

    private TextView mTvEducation;
    private TextView mTvLibrary;
    private TextView mTvEvent;
    private TextView mTvMine;

    private Fragment mFgEducation;
    private Fragment mFgLibrary;
    private Fragment mFgEvent;
    private Fragment mFgMine;

    private FragmentManager mManager;

    int mColorClicked = 0;
    int mColorUnClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mColorClicked = getResources().getColor(R.color.colorClicked);
        mColorUnClicked = getResources().getColor(R.color.colorUnClicked);
        mManager = getSupportFragmentManager();
        initViews();
    }

    private void initViews() {
        mTvEducation = findViewById(R.id.tv_jiaowu);
        mTvLibrary = findViewById(R.id.tv_tushu);
        mTvEvent = findViewById(R.id.tv_huodong);
        mTvMine = findViewById(R.id.tv_wode);

        mTvEducation.setOnClickListener(this);
        mTvLibrary.setOnClickListener(this);
        mTvEvent.setOnClickListener(this);
        mTvMine.setOnClickListener(this);

        Drawable tvTopIcon = getResources().getDrawable(R.drawable.ic_launcher_background);
        tvTopIcon.setBounds(0, 0, 50, 50);

        mTvEducation.setCompoundDrawables(null, tvTopIcon, null, null);
        mTvLibrary.setCompoundDrawables(null, tvTopIcon, null, null);
        mTvEvent.setCompoundDrawables(null, tvTopIcon, null, null);
        mTvMine.setCompoundDrawables(null, tvTopIcon, null, null);

        FragmentTransaction mTransaction = mManager.beginTransaction();
        Log.d("jtt", "initViews: " + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + mFgEducation);
//        mFgEducation = (BaseFragment) ARouter.getInstance().build("/news/newsFragment").navigation();
//        mTransaction.add(R.id.home_container, mFgEducation);
//        mTransaction.commit();
        changeColor(0);

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = mManager.beginTransaction();
        int id = v.getId();
        if (id == R.id.tv_jiaowu) {
            hideFragment(transaction, mFgLibrary);
            hideFragment(transaction, mFgEvent);
            hideFragment(transaction, mFgMine);
            if (mFgEducation == null) {
                mFgEducation = (Fragment) ARouter.getInstance().build("/news/newsFragment").navigation();
                Log.d("jttjtt", "onClick: " + mFgEducation);
                transaction.add(R.id.home_container, mFgEducation);
            } else {
                transaction.show(mFgEducation);
            }
            changeColor(0);
        } else if (id == R.id.tv_tushu) {
            hideFragment(transaction, mFgEducation);
            hideFragment(transaction, mFgEvent);
            hideFragment(transaction, mFgMine);
            if (mFgLibrary == null) {
                mFgLibrary = new LibraryFragment();
                transaction.add(R.id.home_container, mFgLibrary);
            } else {
                transaction.show(mFgLibrary);
            }
            changeColor(1);

        } else if (id == R.id.tv_huodong) {
            hideFragment(transaction, mFgEducation);
            hideFragment(transaction, mFgLibrary);
            hideFragment(transaction, mFgMine);
            if (mFgEvent == null) {
                mFgEvent = (Fragment) ARouter.getInstance().build("/test/event").navigation();
                transaction.add(R.id.home_container, mFgEvent);
            } else {
                transaction.show(mFgEvent);
            }
            changeColor(2);
        } else if (id == R.id.tv_wode) {
            hideFragment(transaction, mFgEducation);
            hideFragment(transaction, mFgLibrary);
            hideFragment(transaction, mFgEvent);
            if (mFgMine == null) {
                mFgMine = new MineFragment();
                transaction.add(R.id.home_container, mFgMine);
            } else {
                transaction.show(mFgMine);
            }
            changeColor(3);
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction ft, Fragment fg) {
        if (fg != null) {
            ft.hide(fg);
        }
    }

    private void changeColor(int index) {
        mTvEducation.setTextColor(mColorUnClicked);
        mTvLibrary.setTextColor(mColorUnClicked);
        mTvEvent.setTextColor(mColorUnClicked);
        mTvMine.setTextColor(mColorUnClicked);
        switch (index) {
            case 0:
                mTvEducation.setTextColor(mColorClicked);
                break;
            case 1:
                mTvLibrary.setTextColor(mColorClicked);
                break;
            case 2:
                mTvEvent.setTextColor(mColorClicked);
                break;
            case 3:
                mTvMine.setTextColor(mColorClicked);
                break;
        }
    }

}

package com.create.whc.universalinterface.BaseUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.create.whc.universalinterface.struct.FunctionManager;

public class BaseActivity extends AppCompatActivity {

    protected FunctionManager fmanager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fmanager = FunctionManager.getInstance();
    }

    protected void setFunctionForFragment(String tag){
        FragmentManager fm=getSupportFragmentManager();
        BaseFragment baseFragment= (BaseFragment) fm.findFragmentByTag(tag);
        baseFragment.setFunctionManager(fmanager);
    }

}

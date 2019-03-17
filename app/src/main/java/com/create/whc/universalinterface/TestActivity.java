package com.create.whc.universalinterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.create.whc.universalinterface.BaseUtil.BaseActivity;
import com.create.whc.universalinterface.struct.FunctionNoParamNoResult;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testview);

        fmanager.addFunction(new FunctionNoParamNoResult(TestFragment.INTERFACE) {

            @Override
            protected void function() {
                Toast.makeText(TestActivity.this,"this is a test!",Toast.LENGTH_SHORT).show();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.test,new TestFragment());
        fragmentTransaction.commit();

    }

}

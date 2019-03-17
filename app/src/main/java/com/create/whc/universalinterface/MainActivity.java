package com.create.whc.universalinterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.create.whc.universalinterface.BaseUtil.BaseActivity;
import com.create.whc.universalinterface.BaseUtil.FragmentChangeUtil;
import com.create.whc.universalinterface.Fragment.FirstFragment;
import com.create.whc.universalinterface.Fragment.FouthFragment;
import com.create.whc.universalinterface.Fragment.SecondFragment;
import com.create.whc.universalinterface.Fragment.ThirdFragment;
import com.create.whc.universalinterface.struct.FunctionNoParamNoResult;
import com.create.whc.universalinterface.struct.FunctionOnlyWithParam;
import com.create.whc.universalinterface.struct.FunctionOnlyWithResult;
import com.create.whc.universalinterface.struct.FunctionWithParamAndResult;

public class MainActivity extends BaseActivity {

    private Button bt1, bt2, bt3, bt4;
    private FragmentChangeUtil changeUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeUtil = FragmentChangeUtil.getInstance();
        changeUtil.setFragmentTransaction(getSupportFragmentManager());

        fmanager.addFunction(new FunctionNoParamNoResult(FirstFragment.INTERFACE) {
            @Override
            protected void function() {
                Toast.makeText(MainActivity.this, "调用无参数无返回值的接口", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        }).addFunction(new FunctionOnlyWithResult<String>(SecondFragment.ONLYRESULT) {
            @Override
            protected String function() {
                return "this is a test!";
            }
        }).addFunction(new FunctionOnlyWithParam<String>(ThirdFragment.ONLYParam) {
            @Override
            protected void function(String s) {
                Toast.makeText(MainActivity.this, "调用有参数无返回值的接口" + s, Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamAndResult<String, Integer>(FouthFragment.ResultAndParam) {
            @Override
            protected String function(Integer integer) {
                return "调用有参数有返回值的接口" + integer;
            }
        });


        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeUtil.changeFragment(R.id.framelayout, new FirstFragment());
            }
        });
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeUtil.changeFragment(R.id.framelayout, new SecondFragment());
            }
        });
        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeUtil.changeFragment(R.id.framelayout, new ThirdFragment());
            }
        });
        bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeUtil.changeFragment(R.id.framelayout, new FouthFragment());
            }
        });
    }


//    public void setFunctionForFragment(String tag) {
//        FragmentManager fm = getSupportFragmentManager();
//        BaseFragment baseFragment = (BaseFragment) fm.findFragmentByTag(tag);
//        FunctionManager fmanager = FunctionManager.getInstance();
//        baseFragment.setFunctionManager(fmanager.addFunction(new FunctionNoParamNoResult(FirstFragment.INTERFACE) {
//                    @Override
//                    protected void function() {
//                        Toast.makeText(MainActivity.this, "调用无参数无返回值的接口", Toast.LENGTH_SHORT).show();
//                    }
//                }).addFunction(new FunctionOnlyWithResult<String>(SecondFragment.ONLYRESULT) {
//                    @Override
//                    protected String function() {
//                        return "this is a test!";
//                    }
//                }).addFunction(new FunctionOnlyWithParam<String>(ThirdFragment.ONLYParam) {
//                    @Override
//                    protected void function(String s) {
//                        Toast.makeText(MainActivity.this, "调用有参数无返回值的接口" + s, Toast.LENGTH_SHORT).show();
//                    }
//                }).addFunction(new FunctionWithParamAndResult<String, Integer>(FouthFragment.ResultAndParam) {
//                    @Override
//                    protected String function(Integer integer) {
//                        return "调用有参数有返回值的接口" + integer;
//                    }
//                })
//        );
//    }

}

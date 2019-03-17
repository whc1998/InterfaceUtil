package com.create.whc.universalinterface.BaseUtil;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.create.whc.universalinterface.MainActivity;
import com.create.whc.universalinterface.struct.FunctionManager;

public class BaseFragment extends Fragment {

    protected FunctionManager functionManager;
    private BaseActivity mainActivity;

    public void setFunctionManager(FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mainActivity= (MainActivity) context;
            mainActivity.setFunctionForFragment(getTag());
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof BaseActivity){
//            mainActivity= (BaseActivity) context;
//            mainActivity.setFunctionForFragment(getTag());
//        }
//    }

}

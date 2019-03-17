package com.create.whc.universalinterface.BaseUtil;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by WSY on 2018/4/25.
 */

public class FragmentChangeUtil {

    private Fragment curentfragment;
    private FragmentManager fragmentManager;
    private static FragmentChangeUtil fragmentChangeUtil;

    private FragmentChangeUtil() {
        curentfragment=new Fragment();
    }

    public static FragmentChangeUtil getInstance(){
        if (fragmentChangeUtil==null){
            synchronized(FragmentChangeUtil.class){
                if (fragmentChangeUtil==null){
                    fragmentChangeUtil=new FragmentChangeUtil();
                }
            }
        }
        return fragmentChangeUtil;
    }

    public void setFragmentTransaction(FragmentManager manager){
        fragmentManager=manager;
    }

    public void setCurrentFragment(Fragment fragment){
        curentfragment=fragment;
    }

    public void changeFragment(int id ,Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!fragment.isAdded()){
            fragmentTransaction.hide(curentfragment)
                    .add(id, fragment,fragment.getClass().getName());
            Log.d("Test","ADD"+curentfragment.toString());
        }else{
            fragmentTransaction.hide(curentfragment)
                    .show(fragment);
            Log.d("Test","Show"+curentfragment.toString());
        }
        curentfragment=fragment;
        fragmentTransaction.commit();
    }

}

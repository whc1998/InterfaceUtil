package com.create.whc.universalinterface;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.create.whc.universalinterface.BaseUtil.BaseFragment;

public class TestFragment extends BaseFragment {

    private View view;
    private Button button;
    public static final String INTERFACE = TestFragment.class.getName() + "NPNR";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fristview, container, false);
        button = view.findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                functionManager.invokeFunction(INTERFACE);
            }
        });
        return view;
    }

}

package com.example.wuhe.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wuhe.myapplication.R;

/**
 * author:Chanchuan
 * User: Administrator
 * Date: 2020/10/23/023
 * Time: 下午 2:32
 */
public class DemoFragment extends Fragment {

    private int mPosition;
    private String mTitle;
    private TextView tv_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_demo, container, false);
        initView(inflate);
        return inflate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = (String) getArguments().getSerializable("title");
            mPosition = (int) getArguments().getSerializable("position");
        }
    }

    public DemoFragment() {
    }

    public static DemoFragment newIntance(String title, int position) {
        DemoFragment demoFragment = new DemoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("title", title);
        bundle.putSerializable("position", position);
        demoFragment.setArguments(bundle);
        return demoFragment;
    }

    private void initView(View inflate) {
        tv_title = (TextView) inflate.findViewById(R.id.tv_title);
        tv_title.setText("第" + (mPosition + 1) + "题," + mTitle);
    }
}

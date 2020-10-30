package com.example.wuhe.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wuhe.myapplication.R;

import java.util.List;

/**
 * author:Chanchuan
 * User: Administrator
 * Date: 2020/10/30/030
 * Time: 下午 5:39
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    private Context mContext;
    List<String> mData;

    public DemoAdapter(Context pContext, List<String> pData) {
        mContext = pContext;
        mData = pData;
    }

    @NonNull
    @Override
    public DemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup pViewGroup, int pI) {
        View root =LayoutInflater.from(pViewGroup.getContext()).inflate(R.layout.item_demo, pViewGroup, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DemoAdapter.ViewHolder pViewHolder, int pI) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

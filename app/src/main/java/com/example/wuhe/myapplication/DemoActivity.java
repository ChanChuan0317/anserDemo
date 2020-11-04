package com.example.wuhe.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylibrary.paper.view.QuestionViewPager;
import com.example.wuhe.myapplication.adapter.DemoAdapter;
import com.example.wuhe.myapplication.fragment.DemoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.currentPosition)
    TextView currentPosition;
    @BindView(R.id.all_number)
    TextView allNumber;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private QuestionViewPager readerViewPager;
    private ImageView shadowView;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        for (int i = 0; i < 50; i++) {
            mData.add("abc" + (i + 1));
        }
        readerViewPager = (QuestionViewPager) findViewById(R.id.readerViewPager);
        shadowView = (ImageView) findViewById(R.id.shadowView);
        readerViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int pI) {
                String s = mData.get(pI);
                DemoFragment demoFragment = DemoFragment.newIntance(s, pI);
                return demoFragment;
            }

            @Override
            public int getCount() {
                return mData.size();
            }
        });

        readerViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pI, float pV, int pI1) {
                shadowView.setTranslationX(readerViewPager.getWidth() - pI1);

            }

            @Override
            public void onPageSelected(int pI) {

            }


            @Override
            public void onPageScrollStateChanged(int pI) {

            }
        });
        recycler.setLayoutManager(new GridLayoutManager(this, 5));
        DemoAdapter demoAdapter = new DemoAdapter(this, mData);
        recycler.setAdapter(demoAdapter);
    }
}

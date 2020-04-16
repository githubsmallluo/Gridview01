package com.luo.gridview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.luo.gridview01.adapter.AppAdapter;
import com.luo.gridview01.bean.AppBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luo on 2020/4/16.
 *
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private GridView mGvApp;
    private List<AppBean> appList;
    private AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        appList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            AppBean appBean = new AppBean();
            appBean.setName("name : " + i);
            appBean.setIcon(R.drawable.smile);
            appList.add(appBean);
        }
    }

    private void initView() {
        mGvApp = (GridView) findViewById(R.id.gv_all);
        appAdapter = new AppAdapter(this, appList);
        mGvApp.setAdapter(appAdapter);
    }

    private void initListener() {
        mGvApp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "item = " + position, Toast.LENGTH_SHORT).show();
            }
        });
        mGvApp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppAdapter adapter = (AppAdapter) mGvApp.getAdapter();
                adapter.notifyDataSetChanged(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

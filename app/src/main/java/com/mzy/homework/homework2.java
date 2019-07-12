package com.mzy.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class homework2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework2);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_homework2, null);
        setContentView(view);
        int ViewCount = getViewCount(view);
        System.out.println("view count= " + ViewCount);
    }

    public static int getViewCount(View view) {
        if (view == null)
            return 0;
        else if (view instanceof ViewGroup) {
            int x = 0;
            ViewGroup viewgroup = (ViewGroup) view;
            x+=viewgroup.getChildCount();
            for (int i = 0; i < viewgroup.getChildCount(); i++) {
                View viewchild = viewgroup.getChildAt(i);
                x += getViewCount(viewchild);
            }
            return x;
        }
        else
            return 0;
    }
}

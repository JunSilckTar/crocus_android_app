package com.haibin.calendarviewproject;

import android.annotation.SuppressLint;


import android.view.View;
import android.widget.Toast;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarviewproject.base.BaseActivity;
import com.haibin.calendarviewproject.range.RangeActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements
        CalendarView.OnCalendarSelectListener,
        CalendarView.OnWeekChangeListener,
        CalendarView.OnViewChangeListener,
        View.OnClickListener {

    CalendarView mCalendarView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        setStatusBarDarkMode();

        //日历视图
        mCalendarView = findViewById(R.id.calendarView);

        mCalendarView.setOnCalendarSelectListener(this);
        //周视图切换监听
        mCalendarView.setOnWeekChangeListener(this);
        //视图改变事件
        mCalendarView.setOnViewChangeListener(this);
        //返回,获取今天
        //mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    @SuppressWarnings("unused")
    @Override
    protected void initData() {

        /*
        final int year = mCalendarView.getCurYear(); //获取返回本年
        final int month = mCalendarView.getCurMonth(); //获取返回本月
        */

        Map<String, Calendar> map = new HashMap<>();

        //28560 数据量增长不会影响UI响应速度，请使用这个API替换
        //标记哪些日期有事件
        mCalendarView.setSchemeDate(map);

        findViewById(R.id.ll_range).setOnClickListener(this);
    }


    //viewID复写单击事件
    //使用if，不使用switch
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ll_range){
            RangeActivity.show(this);
        }
    }



    @Override
    public void onCalendarOutOfRange(Calendar calendar) {
        Toast.makeText(this, String.format("%s : OutOfRange", calendar), Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        //选择日历事件
    }




    @Override
    public void onViewChange(boolean isMonthView) {
        //视图切换事件
    }


    @Override
    public void onWeekChange(List<Calendar> weekCalendars) {
//        for (Calendar calendar : weekCalendars) {
//
//        }
    }

}



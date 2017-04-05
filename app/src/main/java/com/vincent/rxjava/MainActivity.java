package com.vincent.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void create(View view) {
        RxUtil.create();
    }

    public void createPrint(View view) {
        RxUtil.createPrint();
    }

    public void from(View view) {
        RxUtil.from();
    }

    public void just(View view) {
        RxUtil.just();
    }

    public void filter(View view) {
        RxUtil.filter();
    }

    public void interval(View view) {
        RxUtil.interval();
    }
}

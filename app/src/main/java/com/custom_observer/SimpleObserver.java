package com.vincent.rxjava.customobserver;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class SimpleObserver implements Observer {
    @Override
    public void update(int data) {
        System.out.println(this.toString()+ "know data was changed to：" + data);
    }
}

package com.vincent.rxjava.customobserver;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class Test {
    public static void main(String arg0[]) {
        Observer observer = new SimpleObserver();
        Observer observer2 = new SimpleObserver();
        Observer observer3 = new SimpleObserver();

        SimpleObservable observable = new SimpleObservable();
        observable.addObserver(observer);
        observable.addObserver(observer2);
        observable.addObserver(observer3);

        observable.setData(1);
        observable.setData(2);
        observable.setData(3);
        observable.setData(3);
        observable.setData(4);
    }
}

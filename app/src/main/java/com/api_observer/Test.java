package com.vincent.rxjava.apiobserver;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class Test {

    public static void main(String argo[]) {
        SimpleObservable observable = new SimpleObservable();
        SimpleObserver observer = new SimpleObserver();
        SimpleObserver observer2 = new SimpleObserver();
        SimpleObserver observer3 = new SimpleObserver();
        observable.addObserver(observer);
        observable.addObserver(observer2);
        observable.addObserver(observer3);
        observable.setData(1);
        observable.setData(2);
        observable.setData(3);
        observable.setData(3);

    }
}

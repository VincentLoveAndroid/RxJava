package com.vincent.rxjava.apiobserver;

import java.util.Observable;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class SimpleObservable extends Observable {
    private int data;

    public void setData(int data) {
        if (this.data != data) {
            setChanged();
            notifyObservers(data);
            this.data = data;
        }
    }
}

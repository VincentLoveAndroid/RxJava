package com.vincent.rxjava.customobserver;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public interface Observable {
    void addObserver(Observer observer);

    void notifyObservers();
}

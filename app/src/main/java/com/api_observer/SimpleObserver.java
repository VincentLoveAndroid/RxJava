package com.vincent.rxjava.apiobserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class SimpleObserver implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        System.out.println(this + " know data was changed to" + o);
    }
}

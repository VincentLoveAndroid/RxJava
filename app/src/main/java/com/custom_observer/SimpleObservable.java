package com.vincent.rxjava.customobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class SimpleObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private int data;
    private boolean changed;


    public void setData(int data) {
        if (this.data != data) {
            setChanged(true);
        }
        notifyObservers();
        this.data = data;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        if (!isChanged()) {
            System.out.println("there is not change,so I won't notify observers");
            return;
        }
        for (Observer ob : observers) {
            ob.update(data);
        }
        changed = false;
    }
}

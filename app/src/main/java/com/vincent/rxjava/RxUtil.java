package com.vincent.rxjava;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class RxUtil {

    /**
     *
     */
    public static void create() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
                subscriber.onNext("hi");
                subscriber.onNext(getString());
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println(this + " onCompleted()");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(this + " " + s);
            }
        });
    }

    public static String getString() {
        try {
            Thread.sleep(2000);
            return "sleep two second return";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "exception";
    }

    /**
     *
     */
    public static void createPrint() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println(this + " onCompleted()");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(this + " " + integer.toString());
            }
        });
    }

    /**
     *
     */
    public static void from() {
        Integer[] item = {1, 2, 3, 4, 5, 6};
        Observable.from(item).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(this + " " + integer.toString());
            }
        });
    }

    /**
     *
     */
    public static void just() {
        Observable.just(1, 2, 3, 4, 5).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(this + " " + integer.toString());
            }
        });
    }

    /**
     * 过滤
     */
    public static void filter() {
        Observable.just(1, 2, 3, 4, 5).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 2 == 0;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(this + " " + integer.toString());
            }
        });
    }

    /**
     * 计时输出
     */
    public static void interval() {
        Observable.interval(0, 2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                System.out.println(this + " " + aLong.toString());
            }
        });
    }
}

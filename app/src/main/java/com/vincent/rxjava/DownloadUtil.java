package com.vincent.rxjava;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by vincent on 2017/4/5.
 * email-address:674928145@qq.com
 * description:
 */

public class DownloadUtil {

    private final OkHttpClient client;

    public DownloadUtil() {
        client = new OkHttpClient();
    }

    public Observable<byte[]> download(final String url) {
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(final Subscriber<? super byte[]> subscriber) {
                final Request request = new Request.Builder().url(url).build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            byte[] data = response.body().bytes();
                            if (data != null) {
                                subscriber.onNext(data);
                            }
                            subscriber.onCompleted();
                        }
                    }
                });
            }
        });
    }

}

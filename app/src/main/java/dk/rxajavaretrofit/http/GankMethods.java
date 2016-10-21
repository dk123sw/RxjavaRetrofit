package dk.rxajavaretrofit.http;

import java.util.concurrent.TimeUnit;

import dk.rxajavaretrofit.entity.GankDate;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/10/21.
 */

public class GankMethods {
    public static final String GankBASE_URL = "http://gank.io";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private HttpService httpService;


    private GankMethods(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(DEFAULT_TIMEOUT , TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(GankBASE_URL)
                .build();
        httpService = retrofit.create(HttpService.class);
    }
    /**
     *  单例模式
     */
    private static class SingletonHolder{
        private static final GankMethods INSTANCE = new GankMethods();
    }

    public static GankMethods getInstance(){
        return GankMethods.SingletonHolder.INSTANCE;
    }


    /**
     *
     */
    public void getGankDate(Subscriber<GankDate> subscriber ,int page){
        httpService.getGankDate(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }
}



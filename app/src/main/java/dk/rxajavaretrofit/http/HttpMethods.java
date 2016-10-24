package dk.rxajavaretrofit.http;

import java.util.concurrent.TimeUnit;

import dk.rxajavaretrofit.entity.HttpEntity;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dk on 2016/10/18.
 */

public class HttpMethods {

    public static final String HttpsBASE_URL = "https://api.douban.com/v2/movie/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private HttpService httpService;

    private HttpMethods(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(DEFAULT_TIMEOUT , TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(HttpsBASE_URL)
                .build();
        httpService = retrofit.create(HttpService.class);
    }
/**
 *  单例模式
 */
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }


    /**
     * 用于获取豆瓣电影Top250的数据
     * @param subscriber  由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovie(Subscriber<HttpEntity> subscriber  ,int start ,int count){
        httpService.getTopMovie(start ,count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}

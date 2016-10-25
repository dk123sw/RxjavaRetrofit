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
 * Created by dk on 2016/10/25.
 */

public class MoiveMethods {

    private static final String HttpsBASE_URL = "https://api.douban.com/v2/movie/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private HttpService httpService;

    private MoiveMethods(){
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

    private static class SingleO{
        private static final MoiveMethods Instance = new MoiveMethods();
    }

    public static MoiveMethods getInstance(){
        return SingleO.Instance;
    }

    public void getMovie(Subscriber<HttpEntity> subscriber  , int start , int count){
        httpService.getTopMovie(start ,count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}

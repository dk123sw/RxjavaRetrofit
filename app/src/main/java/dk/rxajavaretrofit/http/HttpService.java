package dk.rxajavaretrofit.http;

import dk.rxajavaretrofit.entity.HttpEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dk on 2016/10/18.
 */

public interface HttpService {

    @GET("top250")
    Observable<HttpEntity> getTopMovie(@Query("start")int start , @Query("count")int count);
}

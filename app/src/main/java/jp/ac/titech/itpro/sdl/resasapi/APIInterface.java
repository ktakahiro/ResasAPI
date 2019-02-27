package jp.ac.titech.itpro.sdl.resasapi;

import jp.ac.titech.itpro.sdl.resasapi.model.Prefectures;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by takahiro on 2017/11/17.
 */

public interface APIInterface {
    String END_POINT = "https://opendata.resas-portal.go.jp";
    @Headers("X-API-KEY:EpUDHVVQh1JLLPhBUwpAdLIhokWlUKt91ffidg7r")
    @GET("api/v1/prefectures")
    Call<Prefectures> getPrefCode(@Query("prefCode") Integer prefnum);
}
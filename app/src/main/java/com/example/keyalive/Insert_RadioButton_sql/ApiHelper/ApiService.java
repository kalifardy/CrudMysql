package com.example.keyalive.Insert_RadioButton_sql.ApiHelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by keyalive on 25/03/2018.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseBody>sex(@Field("id")String id,
                          @Field("jk")String jk);
}

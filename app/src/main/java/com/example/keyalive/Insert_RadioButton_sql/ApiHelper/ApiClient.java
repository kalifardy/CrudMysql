package com.example.keyalive.Insert_RadioButton_sql.ApiHelper;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by keyalive on 25/03/2018.
 */

public class ApiClient {

    private static  Retrofit retrofit = null;

    public  static Retrofit getClient(String baseUrl){

        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null){
            retrofit =new Retrofit.Builder().
                    baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).
                    client(client).build();
        }
        return retrofit;

        }

    }


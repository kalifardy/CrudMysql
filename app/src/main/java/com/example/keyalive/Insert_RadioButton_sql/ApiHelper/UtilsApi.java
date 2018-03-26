package com.example.keyalive.Insert_RadioButton_sql.ApiHelper;

/**
 * Created by keyalive on 25/03/2018.
 */

public class UtilsApi {
    public  static final String Url_api = "http://192.168.1.118/radiobutton/";

    public static ApiService getApiService(){
        return ApiClient.getClient(Url_api).create(ApiService.class);
    }
}

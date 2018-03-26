package com.example.keyalive.Insert_RadioButton_sql;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.keyalive.Insert_RadioButton_sql.ApiHelper.ApiService;
import com.example.keyalive.Insert_RadioButton_sql.ApiHelper.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

     EditText edtId;
     RadioGroup rgSex;
     RadioButton rbsex;
     Button btnKirim;

    Context mContext;
    ApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            mContext = this;
            mApiService= UtilsApi.getApiService();


        initView();

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String id = edtId.getText().toString();
                int selectedId = rgSex.getCheckedRadioButtonId();
                rbsex = (RadioButton) findViewById(selectedId);
//        String jk = rbsex.getText().toString();

                mApiService.sex(edtId.getText().toString(),rbsex.getText().toString()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(mContext, "sukes", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext, "gagal", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(mContext, "koneksi offline atau bermasalah", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    private void initView() {
        edtId = (EditText) findViewById(R.id.edt_id);
        rgSex = (RadioGroup) findViewById(R.id.rg_sex);
        rbsex = (RadioButton) findViewById(R.id.rb_lk);
        btnKirim = (Button) findViewById(R.id.btn_kirim);
    }
}

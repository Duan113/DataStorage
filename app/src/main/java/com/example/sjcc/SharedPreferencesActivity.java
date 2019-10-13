package com.example.sjcc;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etname;
    private Button btnsave,btnshow;
    private TextView tvcontent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        etname=findViewById(R.id.et_name);
        btnsave=findViewById(R.id.btn_save);
        btnshow=findViewById(R.id.btn_show);
        tvcontent=findViewById(R.id.tv_content);

        mSharedPreferences=getSharedPreferences("data",MODE_PRIVATE);//获得事例实例。(文件名称与模式)
        mEditor=mSharedPreferences.edit();

        btnsave.setOnClickListener(this);
        btnshow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
//                把文本保存起来
                mEditor.putString("name",etname.getText().toString());//获得文本
                mEditor.apply();//commit同步存储
                break;
            case R.id.btn_show:
                tvcontent.setText(mSharedPreferences.getString("name",""));
                break;
        }
    }
}

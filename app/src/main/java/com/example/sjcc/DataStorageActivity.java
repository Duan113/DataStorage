package com.example.sjcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnsharedpreferences,btnfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        btnsharedpreferences=findViewById(R.id.btn_sharedpreferences);
        btnfile=findViewById(R.id.btn_file);

        btnsharedpreferences.setOnClickListener(this);
        btnfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.btn_sharedpreferences:
                intent=new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_file:
                intent=new Intent(DataStorageActivity.this,FileActivity.class);
                startActivity(intent);
                break;

        }
    }
}

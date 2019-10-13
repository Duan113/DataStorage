package com.example.sjcc;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etname;
    private Button btnsave, btnshow;
    private TextView tvcontent;
    private final String mFileName = "text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        etname = findViewById(R.id.et_name);
        btnsave = findViewById(R.id.btn_save);
        btnshow = findViewById(R.id.btn_show);
        tvcontent = findViewById(R.id.tv_content);

        btnsave.setOnClickListener(this);
        btnshow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                save(etname.getText().toString());//保存调用方法
                break;
            case R.id.btn_show:
                tvcontent.setText(read());
                break;
        }
    }

    //用来存储数据
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
//            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            //寻找文件夹skypan
            File dir=new File(Environment.getExternalStorageDirectory(),"skypan");
            //如果kaypan文件夹不存在就新建
            if (!dir.exists()){
                dir.mkdir();//mkdirs可以新建一系列如sypan/a/b
            }
            File file=new File(dir,mFileName);
            //如果文件夹不存在就新建
            if (!file.exists()){
                file.createNewFile();
            }
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());//获取content
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close可能会造成空指针异常
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();//不要忘记关闭(close)
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //用来读取数据
    private String read() {
        FileInputStream fileInputStream=null;
        try {
//            fileInputStream = openFileInput(mFileName);
            //在getExternalStorageDirectory().getAbsolutePath()+File.separator+"skypan"路径下
            File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"skypan",mFileName);
            fileInputStream=new FileInputStream(file);
            byte[] buff = new byte[1024];            //每次读取1024个字节
            StringBuilder sb = new StringBuilder();  //用来拼接字符串
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                //拼接
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();//一般情况下返回这个
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}













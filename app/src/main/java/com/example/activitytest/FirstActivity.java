package com.example.activitytest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

import static com.example.activitytest.R.styleable.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true; //返回false 菜单无法显示

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"隐式intent启动第二个活动",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);

                break;
            case R.id.remove_item:
                Toast.makeText(this,"访问百度",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent1);
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "启动第二个活动！",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }

        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "~打电话给中国电信中~~",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:10000"));
                startActivity(intent);
            }
        });
        ImageView image1 =(ImageView) findViewById(R.id.image1);
        //image1.setImageURI(Uri.fromFile(new File("/storage/sdcard1/jq.jpg")));
        String path= "/storage/sdcard1/jq.jpg";
        Bitmap bm = BitmapFactory.decodeFile(path);
        image1.setImageBitmap(bm);//不会变形
        //image1.setImageResource(R.drawable.blackk);//不会变形

    }
}

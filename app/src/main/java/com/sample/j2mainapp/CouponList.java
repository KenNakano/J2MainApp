package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CouponList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list);


        //クーポン一覧画面→Top画面に進むボタン（Topに戻るボタンが押されたとき）
        final Button BackTopButton = findViewById(R.id.TopButton);

        //クーポン一覧画面→Top画面に進むボタン処理（Topに戻るボタンが押されたとき）
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(CouponList.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
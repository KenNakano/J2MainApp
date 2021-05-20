package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);


        //お店詳細画面→Top画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //お店詳細画面→Top画面に進むボタン
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(ShopDetail.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
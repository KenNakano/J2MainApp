package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopListWrite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_write);


        //お客側　　お店掲示板編集画面→　Top画面に進むボタン(投稿ボタンを押した場合)
        Button ShopSaleWriteButton= findViewById(R.id.ShopSaleWriteButton);

        //お客側　　お店掲示板編集画面→　Top画面に進むボタン(投稿ボタンを押した場合)
        ShopSaleWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopListWrite.this,ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //お店掲示板編集画面→Top画面に進むボタン（トップに戻るボタンを押したとき）
        Button BackTopButton = findViewById(R.id.ShopTopButton);

        //お店掲示板編集画面→Top画面に進むボタン（トップに戻るボタンを押したとき）
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopListWrite.this, ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
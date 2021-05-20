package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopTop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_top);


        //お店トップ画面→お店基本情報編集画面に進むボタン
        final Button ShopInformationbutton = findViewById(R.id.InputShopInformationButton);

        //お店トップ画面→お店基本情報編集画面に進むボタン処理
        ShopInformationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopTop.this, InputShopInformation.class);
                //画面遷移
                startActivity(intent);

            }
        });



        //お店トップ画面→お店掲示板画面に進むボタン
        final Button ShopListWriteButton = findViewById(R.id.ShopListWriteButton);

        //お店トップ画面→お店掲示板画面に進むボタン処理
        ShopListWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopTop.this, ShopListWrite.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
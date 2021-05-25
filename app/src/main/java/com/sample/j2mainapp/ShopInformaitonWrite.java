package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopInformaitonWrite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_informaiton_write);


        //店側　お店基本情報編集画面→ShopTop画面に進むボタン
        final Button BackShopTopButton = findViewById(R.id.ShopTopButton);

        //店側　お店基本情報編集画面→ShopTop画面に進むボタン
        BackShopTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopInformaitonWrite.this, ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });



        //店側　お店基本情報編集画面→　お店基本情報画面に進むボタン（編集完了ボタン）
        final Button WrittenShopFinishButton = findViewById(R.id.WrittenShopFinishButton);

        //店側　お店基本情報編集画面→　お店基本情報画面に進むボタン（編集完了ボタン）
        WrittenShopFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopInformaitonWrite.this, InputShopInformation.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }

}
package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_login);

        //お店ログイン画面→お店トップ画面に進むボタン
        Button ShopTopButton = findViewById(R.id.ShopLoginButton);

        //お店ログイン画面→お店トップ画面に進むボタン処理
        ShopTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopLogin.this, ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }



}
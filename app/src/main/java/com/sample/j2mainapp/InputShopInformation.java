package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputShopInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_shop_information);


        //店側　お店基本情報表示画面→ShopTop画面に進むボタン
        final Button BackShopTopButton = findViewById(R.id.ShopTopButton);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        BackShopTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputShopInformation.this, ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
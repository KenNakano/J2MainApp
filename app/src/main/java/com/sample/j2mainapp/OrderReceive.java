package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderReceive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_receive);





        //依頼受注画面→実行中画面に進むボタン
        Button DoButton = findViewById(R.id.DoButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        DoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(OrderReceive.this, Do.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //依頼受注画面→お断り画面に進むボタン
        Button RefuseButton = findViewById(R.id.RefuseButton);

        //依頼受注画面→お断り画面に進むボタン
        RefuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(OrderReceive.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //依頼受注画面→Top画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //依頼受注画面→Top画面に進むボタン
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(OrderReceive.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
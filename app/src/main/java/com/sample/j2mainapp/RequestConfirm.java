package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RequestConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_confirm);


        //手伝う画面→依頼内容受注画面に進むボタン(その１)
        final Button Irai1button = findViewById(R.id.Irai1);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        Irai1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(RequestConfirm.this, OrderReceive.class);
                //画面遷移
                startActivity(intent);

            }
        });




        //手伝う画面→依頼内容受注画面に進むボタン（その２）
        final Button  InputHelpButton= findViewById(R.id.Inputhelp);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        InputHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(RequestConfirm.this, InputReceiveInformation.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //手伝う画面→依頼内容受注画面に進むボタン（その２）
        final Button  BackTopButton= findViewById(R.id.TopButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(RequestConfirm.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Top extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);


        //Top画面→手伝う画面に進むボタン
        final Button OrderConfirmbutton = findViewById(R.id.RequestConfirmButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        OrderConfirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, RequestConfirm.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //Top画面→依頼画面に進むボタン
        final Button ReceiveBoardbutton = findViewById(R.id.ReceiveConfirmButton);

        //Top画面→依頼画面に進むボタンが操作された時の動作
        ReceiveBoardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, ReceiveBoard.class);
                //画面遷移
                startActivity(intent);

            }
        });







    }
}
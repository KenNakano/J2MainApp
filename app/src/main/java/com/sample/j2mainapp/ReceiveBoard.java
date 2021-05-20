package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceiveBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_board);

        //依頼側１　掲示板から選ぶ画面→依頼側２　　詳細情報入力画面に進むボタン
        Button ToInputOrderDetailButton = findViewById(R.id.InputOrderDetailButton);

        //依頼側１　掲示板から選ぶ画面→依頼側２　　詳細情報入力画面に進むボタンの動作処理
        ToInputOrderDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ReceiveBoard.this, InputOrderDetail.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //依頼側１　掲示板から選ぶ画面→依頼側２　　詳細情報入力画面に進むボタン
        Button ToInputOrderButton = findViewById(R.id.Receive1);

        //依頼側１　掲示板から選ぶ画面→依頼側１　　ついでに依頼画面に進むボタンの動作処理
        ToInputOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ReceiveBoard.this, InputOrder.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //依頼側１　掲示板から選ぶ画面→Top画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //依頼側１　掲示板から選ぶ画面→Top画面に進むボタン処理
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ReceiveBoard.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });




    }
}
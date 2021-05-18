package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_time);


        //依頼者側　　実行者がタスクを完了させるまで待機する画面→タスク完了画面に進むボタン
        Button ToOrderFinishButton = findViewById(R.id.ToOrderFinishButton);

        //依頼者側　　実行者がタスクを完了させるまで待機する画面→タスク完了画面に進むボタン
        ToOrderFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(OrderTime.this, OrderFinish.class);
                //画面遷移
                startActivity(intent);

            }
        });


    }
}
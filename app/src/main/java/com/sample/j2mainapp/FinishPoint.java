package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FinishPoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_point);


        //ポイント完了画面→クーポン画面に進むボタン
        Button FinishGoButton = findViewById(R.id.FinishButton);

        //ポイント完了画面→クーポン画面に進むボタンが操作された時の動作
        FinishGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(FinishPoint.this, Coupon.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //ポイント完了画面→Top画面に進むボタン
        Button TopButton = findViewById(R.id.TopButton);

        //実行中画面→Top画面に進むボタン処理
        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(FinishPoint.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
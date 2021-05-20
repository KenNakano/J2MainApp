package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputOrderDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_order_detail);

        //実行側　詳細情報入力画面→Top画面に進むボタン
        final Button FinishGoButton = findViewById(R.id.kanryo);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        FinishGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputOrderDetail.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
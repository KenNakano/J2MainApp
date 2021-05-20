package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderFinish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finish);


        //MoneyButton

        //依頼者側　タスク完了画面→クーポン画面に進むボタン
        final Button MoneyGoButton = findViewById(R.id.MoneyButton);

        //依頼者側　タスク完了画面→クーポン画面に進むボタン動作処理
        MoneyGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(OrderFinish.this, Coupon.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
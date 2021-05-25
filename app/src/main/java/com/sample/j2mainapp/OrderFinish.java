package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class OrderFinish extends AppCompatActivity {
    HashMap<String, String> request = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finish);

        Intent intent = getIntent();
        request = (HashMap<String, String>)intent.getSerializableExtra("OrderTime_OrderFinish");
        String id = (String) request.get("id");
        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("02_提案済み（ペア成立）/"+id);
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

                reference1.child("about").removeValue();
                reference1.child("area").removeValue();
                reference1.child("deadline").removeValue();
                reference1.child("etc").removeValue();
                reference1.child("id").removeValue();
                reference1.child("proposer").removeValue();
                reference1.child("request").removeValue();

            }
        });

        //依頼者側　タスク完了画面→Top画面に進むボタン（トップボタンが押されたとき）
        final Button BackTopButton = findViewById(R.id.TopButton);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(OrderFinish.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });


    }
}
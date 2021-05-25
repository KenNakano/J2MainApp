package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FinishPoint extends AppCompatActivity {

    private TextView textView1;
    HashMap<String, String> request = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_point);

        textView1 = (TextView) findViewById(R.id.textView11);

//        reference.child("03_非受注").child("1").child("requester").addValueEventListener(listener);
        Intent intent = getIntent();
        request = (HashMap<String, String>)intent.getSerializableExtra("Do_FinishPoint");
        textView1.setText(request.get("requester") + "さんが受け取りました。");
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("04_受注済み（ペア成立）/"+request.get("id"));

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

                reference.child("about").removeValue();
                reference.child("area").removeValue();
                reference.child("deadline").removeValue();
                reference.child("etc").removeValue();
                reference.child("id").removeValue();
                reference.child("requester").removeValue();

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
/*
    //DBの結果を「依頼者が受け取りました」に表示
    ValueEventListener listener = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.textView11);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message + "さんが受け取りました。");  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
*/
}
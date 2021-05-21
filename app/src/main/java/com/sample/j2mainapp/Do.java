package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Do extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);

        textView1 = (TextView) findViewById(R.id.content1);
        textView2 = (TextView) findViewById(R.id.Content2);
        textView3 = (TextView) findViewById(R.id.Content3);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("03_非受注").child("1").child("requester").addValueEventListener(listener);
        reference.child("03_非受注").child("1").child("about").addValueEventListener(listener2);
        reference.child("03_非受注").child("1").child("area").addValueEventListener(listener3);

        //実行中画面→完了画面に進むボタン
        Button FinishButton = findViewById(R.id.FinishButton);

        //実行中画面→完了画面に進むボタンが操作された時の動作
        FinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Do.this, FinishPoint.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //実行中画面→Top画面に進むボタン
        Button TopButton = findViewById(R.id.TopButton);

        //実行中画面→Top画面に進むボタン処理
        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Do.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
    //DBの結果をニックネームに表示
    ValueEventListener listener = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.content1);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
    //DBの結果を依頼内容に表示
    ValueEventListener listener2 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.Content2);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
    //DBの結果をエリアに表示
    ValueEventListener listener3 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.Content3);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
}
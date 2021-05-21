package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderTime extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_time);

        textView1 = (TextView) findViewById(R.id.content1);
        textView2 = (TextView) findViewById(R.id.Content2);
        textView3 = (TextView) findViewById(R.id.Content3);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("01_提案").child("ID").child("proposer").addValueEventListener(listener);
        reference.child("01_提案").child("ID").child("about").addValueEventListener(listener2);
        reference.child("01_提案").child("ID").child("area").addValueEventListener(listener3);



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

        //依頼途中画面→トップ画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //依頼途中画面→トップ画面に進むボタン処理
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(OrderTime.this, Top.class);
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
    //DBの結果を紹介文に表示
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
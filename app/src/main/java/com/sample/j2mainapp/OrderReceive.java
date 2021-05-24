package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderReceive extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_receive);
        Intent intent = getIntent();
        String id = intent.getStringExtra("order");
        textView1 = findViewById(R.id.content1);
        textView2 = findViewById(R.id.Content2);
        textView3 = findViewById(R.id.Content3);//ここでID付けしたテキストに繋がる。

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("03_非受注/"+id);
        reference1.addChildEventListener(new ChildEventListener() {
                 @Override
                 public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildValue) {
                     System.out.println("ID"+ id +"のキーデータ：" + (String)snapshot.getKey());

                     if(((String)snapshot.getKey()).compareTo("requester") == 0){
                         String requestData = snapshot.getValue(String.class);
                         textView1.setText(requestData);
                         System.out.println("Requester is " + requestData);
                     }else if(((String)snapshot.getKey()).compareTo("about") == 0) {
                         String requestData = snapshot.getValue(String.class);
                         textView2.setText(requestData);
                         System.out.println("About is " + requestData);
                     }else if(((String)snapshot.getKey()).compareTo("area") == 0) {
                         String requestData = snapshot.getValue(String.class);
                         textView3.setText(requestData);
                         System.out.println("Area is " + requestData);
                     }
                 }

                 @Override
                 public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                 }

                 @Override
                 public void onChildRemoved(@NonNull DataSnapshot snapshot) {


                 }

                 @Override
                 public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }
             }
        );

//        textView1 = (TextView) findViewById(R.id.content1);
//        textView2 = (TextView) findViewById(R.id.Content2);
//        textView3 = (TextView) findViewById(R.id.Content3);
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//        reference.child("03_非受注").child("2").child("requester").addValueEventListener(listener);
//        reference.child("03_非受注").child("2").child("about").addValueEventListener(listener2);
//        reference.child("03_非受注").child("2").child("area").addValueEventListener(listener3);

        //依頼受注画面→実行中画面に進むボタン
        Button DoButton = findViewById(R.id.DoButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        DoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理
                int input;
                input=1;

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(OrderReceive.this, Do.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //依頼受注画面→お断り画面に進むボタン
        Button RefuseButton = findViewById(R.id.RefuseButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        RefuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(OrderReceive.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //依頼受注画面→Top画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //依頼受注画面→Top画面に進むボタン
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(OrderReceive.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }

    //DBの結果をニックネームに表示
//    ValueEventListener listener = new ValueEventListener()
//    {
//        public void onDataChange(DataSnapshot snapshot)
//        {
//            TextView text = findViewById(R.id.content1);//ここでID付けしたテキストに繋がる。
//            String message = (String)snapshot.getValue();
//            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
//        }
//        public void onCancelled(DatabaseError error) {
//        }
//    };
//    //DBの結果を依頼内容に表示
//    ValueEventListener listener2 = new ValueEventListener()
//    {
//        public void onDataChange(DataSnapshot snapshot)
//        {
//            TextView text = findViewById(R.id.Content2);//ここでID付けしたテキストに繋がる。
//            String message = (String)snapshot.getValue();
//            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
//        }
//        public void onCancelled(DatabaseError error) {
//        }
//    };
//    //DBの結果をエリアに表示
//    ValueEventListener listener3 = new ValueEventListener()
//    {
//        public void onDataChange(DataSnapshot snapshot)
//        {
//            TextView text = findViewById(R.id.Content3);//ここでID付けしたテキストに繋がる。
//            String message = (String)snapshot.getValue();
//            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
//        }
//        public void onCancelled(DatabaseError error) {
//        }
//    };
}
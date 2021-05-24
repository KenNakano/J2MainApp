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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShopDetail extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        Intent intent = getIntent();
        String id = intent.getStringExtra("order");
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView);
//        textView3 = findViewById(R.id.Content3);//ここでID付けしたテキストに繋がる。

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("06_店舗情報/"+id);
        reference1.addChildEventListener(new ChildEventListener() {
             @Override
             public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildValue) {
                 System.out.println("ID"+ id +"のキーデータ：" + (String)snapshot.getKey());

                 if(((String)snapshot.getKey()).compareTo("storeName") == 0){
                     String requestData = snapshot.getValue(String.class);
                     textView1.setText(requestData);
                     System.out.println("ShopName is " + requestData);
                 }else if(((String)snapshot.getKey()).compareTo("sales") == 0) {
                     String requestData = snapshot.getValue(String.class);
                     textView2.setText(requestData);
                     System.out.println("Sales is " + requestData);
                 }/*else if(((String)snapshot.getKey()).compareTo("area") == 0) {
                     String requestData = snapshot.getValue(String.class);
                     textView3.setText(requestData);
                     System.out.println("Area is " + requestData);
                 }*/
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

        //お店詳細画面→Top画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //お店詳細画面→Top画面に進むボタン
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                //Refuseボタンを押すと、トップ画面に戻る
                Intent intent = new Intent(ShopDetail.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
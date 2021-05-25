package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ShopDetail extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

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
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("06_店舗情報/"+id);
        reference.addChildEventListener(new ChildEventListener() {
             @Override
             public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildValue) {
                 System.out.println("ID"+ id +"のキーデータ：" + (String)snapshot.getKey());

                 if(((String)snapshot.getKey()).compareTo("storeName") == 0){
                     String requestData = snapshot.getValue(String.class);
                     textView1.setText(requestData);
                     System.out.println("ShopName is " + requestData);
                 }else if(((String)snapshot.getKey()).compareTo("detail") == 0) {
                     String requestData = snapshot.getValue(String.class);
                     textView2.setText(requestData);
                     System.out.println("Detail is " + requestData);
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
         });

        listView = findViewById(R.id.SalesList);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        try{
            listView.setAdapter(arrayAdapter);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("07_お知らせ");
        reference1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot , @Nullable String previousChildName) {
                try {
                    if(((String)dataSnapshot.child("storeId").getValue()).compareTo(String.valueOf(id)) == 0){
                        String value = dataSnapshot.child("sales").getValue().toString();
                        arrayList.add(value);
                        arrayAdapter.notifyDataSetChanged();
                        System.out.println("value: " + value);
                    }
//                    System.out.println("getKey: " + (String)dataSnapshot.child("storeId").getValue());
//                    System.out.println("getValue: " + (String)dataSnapshot.child("sales").getValue());

                }catch(Exception e){
                    e.printStackTrace();
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
        });


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
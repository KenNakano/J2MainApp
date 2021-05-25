package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RequestConfirm extends AppCompatActivity{
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_confirm);
        listView = findViewById(R.id.RequestList);
//        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("03_非受注");
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);

        try{
            listView.setAdapter(arrayAdapter);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView)parent;

                String item = (String) listView.getItemAtPosition(position);
                Log.v("test",item);

                String[] values = item.split(":");
                for (String oneValue : values) {
                    System.out.println(oneValue);
                }

                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(RequestConfirm.this, OrderReceive.class);
                //画面遷移
                intent.putExtra("order",values[1]);

                startActivity(intent);

                System.out.println("クリック！→" + item);
//                reference.child("").child(item).addValueEventListener(listener);
            }
        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot , @Nullable String previousChildName) {
                try {
                    String value = dataSnapshot.getValue(RequestData.class).toString();
                    arrayList.add(value);
                    arrayAdapter.notifyDataSetChanged();

                    System.out.println("value: " + value);

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


        //手伝う画面→依頼内容受注画面に進むボタン(その１)
//        final Button Irai1button = findViewById(R.id.Irai1);
//
//        //Top画面→手伝う画面に進むボタンが操作された時の動作
//        Irai1button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //ボタンが押された時の処理
//
//                //インテントの作成
//                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
//                Intent intent = new Intent(RequestConfirm.this, OrderReceive.class);
//                //画面遷移
//                startActivity(intent);
//
//            }
//        });
//
//
//
//
        //手伝う画面→依頼内容受注画面に進むボタン（その２）
        final Button  InputHelpButton= findViewById(R.id.Inputhelp);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        InputHelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(RequestConfirm.this, InputReceiveInformation.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //手伝う画面→依頼内容受注画面に進むボタン（その２）
        final Button BackTopButton= findViewById(R.id.TopButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(RequestConfirm.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
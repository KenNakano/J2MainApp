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

public class ReceiveBoard extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_board);
        listView = findViewById(R.id.SuggestList);
//        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("01_提案");
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
                Intent intent = new Intent(ReceiveBoard.this, InputOrder.class);
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
                    String value = dataSnapshot.getValue(SuggestData.class).toString();
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

        //依頼側１　掲示板から選ぶ画面→依頼側２　　詳細情報入力画面に進むボタン
        Button ToInputOrderDetailButton = findViewById(R.id.InputOrderDetailButton);

        //依頼側１　掲示板から選ぶ画面→依頼側２　　詳細情報入力画面に進むボタンの動作処理
        ToInputOrderDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ReceiveBoard.this, InputOrderDetail.class);
                //画面遷移
                startActivity(intent);

            }
        });


//        //依頼側１　掲示板から選ぶ画面→依頼側２　　詳細情報入力画面に進むボタン
//        Button ToInputOrderButton = findViewById(R.id.Receive1);
//
//        //依頼側１　掲示板から選ぶ画面→依頼側１　　ついでに依頼画面に進むボタンの動作処理
//        ToInputOrderButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //ボタンが押された時の処理
//
//                //インテントの作成
//                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
//                Intent intent = new Intent(ReceiveBoard.this, InputOrder.class);
//                //画面遷移
//                startActivity(intent);
//
//            }
//        });

        //依頼側１　掲示板から選ぶ画面→Top画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //依頼側１　掲示板から選ぶ画面→Top画面に進むボタン処理
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ReceiveBoard.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });




    }
}
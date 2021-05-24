package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Top extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        listView = findViewById(R.id.topList);
//        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        //依頼リスト表示
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("03_非受注");
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        try{
            listView.setAdapter(arrayAdapter);
        }catch(NullPointerException e){
            e.printStackTrace();
        }

        //依頼リスト表示
        DatabaseReference referenceA = FirebaseDatabase.getInstance().getReference("01_提案");
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
                }System.out.println("データを分割しました。");

                if(values[0].compareTo("依頼") == 0){
                    //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                    Intent intent = new Intent(Top.this, OrderReceive.class);
                    //画面遷移
                    intent.putExtra("order",values[1]);
                    startActivity(intent);
//                    System.out.println("クリック！→" + item);
                }else if(values[0].compareTo("提案") == 0){
                    Intent intent = new Intent(Top.this, InputOrder.class);
                    intent.putExtra("order",values[1]);
                    startActivity(intent);
                }else if(values[0].compareTo("店舗から") == 0){
//                    Intent intent = new Intent(Top.this, InputOrder.class);
//                    intent.putExtra("order",values[1]);
//                    startActivity(intent);
//                    System.out.println("クリック！→" + item);
                }

//                reference.child("").child(item).addValueEventListener(listener);
            }
        });

//
//        reference.child("001").addValueEventListener(listener);
//
        i = i + 2;

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference("05_会員情報");

//        reference1.child(String.valueOf(i)).child("id").setValue(String.valueOf(i),null);
//        reference1.child(String.valueOf(i)).child("proposer").setValue("澤野",null);
//        reference1.child(String.valueOf(i)).child("about").setValue("ビックカメラ",null);
//        reference1.child(String.valueOf(i)).child("deadline").setValue("2021/05/26;20:00",null);
//        reference1.child(String.valueOf(i)).child("area").setValue("船橋",null);
//        reference1.child(String.valueOf(i)).child("etc").setValue("XXX",null);
//
//        reference1.child(String.valueOf(i)).child("id").setValue(String.valueOf(i),null);
//        reference1.child(String.valueOf(i)).child("area").setValue("新小岩",null);
//        reference1.child(String.valueOf(i)).child("etc").setValue("",null);
//        reference1.child(String.valueOf(i)).child("storeName").setValue("西船橋喫茶",null);
//        reference1.child(String.valueOf(i)).child("sales").setValue("毎月4日に新作のケーキを出してます。",null);

//        reference1.child(String.valueOf(i)).child("id").setValue(String.valueOf(i),null);
//        reference1.child(String.valueOf(i)).child("area").setValue("葛西",null);
//        reference1.child(String.valueOf(i)).child("etc").setValue("???",null);
//        reference1.child(String.valueOf(i)).child("name").setValue("斎藤",null);
//        reference1.child(String.valueOf(i)).child("gender").setValue("Female",null);
//        reference1.child(String.valueOf(i)).child("point").setValue("1200",null);

        //依頼データリスト追加
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

        //提案データリスト追加
        referenceA.addChildEventListener(new ChildEventListener() {
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


        //Top画面→店舗一覧画面に進むボタン
        final Button ShopListbutton = findViewById(R.id.ShopListButton);

        //Top画面→店舗一覧画面に進むボタン処理
        ShopListbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, ShopList.class);
                //画面遷移
                startActivity(intent);

            }
        });



        //Top画面→手伝う画面に進むボタン
        final Button OrderConfirmbutton = findViewById(R.id.RequestConfirmButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        OrderConfirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, RequestConfirm.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //↓↓↓↓消えていたので、５月２０日（木）に追加しました。
        //Top画面→頼む画面に進むボタン
        final Button ReceiveConfirmButton = findViewById(R.id.ReceiveConfirmButton);

        //Top画面→頼む画面に進むボタンが操作された時の動作
        ReceiveConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, ReceiveBoard.class);
                //画面遷移
                startActivity(intent);

            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    ValueEventListener listener = new ValueEventListener() {
        public void onDataChange(DataSnapshot snapshot) {
            System.out.println("データを受信しました。 "
                    + snapshot.getKey() + " = " + snapshot.getValue());
            TextView text = findViewById(R.id.textView);//ここでID付けしたテキストに繋がる。
            text.setText(snapshot.getValue().toString());

        }

        public void onCancelled(DatabaseError error) {
            System.out.println("データ受信がキャンセルされました。" + error.toString());
        }
    };

}
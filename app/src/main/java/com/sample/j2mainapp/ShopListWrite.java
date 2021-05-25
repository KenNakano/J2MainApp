package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ShopListWrite extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    private EditText editText;
    private String salesID = "1";
    private String storeName = "";
    private int newId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_write);

        Intent intent = getIntent();
        String id = intent.getStringExtra("order");

        editText = (EditText) findViewById(R.id.editTextTextShopSale);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("06_店舗情報/"+id);
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildValue) {
                //System.out.println("ID"+ ID +"のキーデータ：" + (String)snapshot.getKey());

                if(((String)snapshot.getKey()).compareTo("storeName") == 0){
                    String requestData = snapshot.getValue(String.class);
                    storeName = requestData;
                    System.out.println("ShopName is " + requestData);
                }/*else if(((String)snapshot.getKey()).compareTo("area") == 0) {
                    String requestData = snapshot.getValue(String.class);
                    editText2.setText(requestData);
                    System.out.println("Area is " + requestData);
                }else if(((String)snapshot.getKey()).compareTo("tel") == 0) {
                    String requestData = snapshot.getValue(String.class);
                    editText3.setText(requestData);
                    System.out.println("Tel is " + requestData);
                }else if(((String)snapshot.getKey()).compareTo("detail") == 0) {
                    String requestData = snapshot.getValue(String.class);
                    editText4.setText(requestData);
                    System.out.println("Detail is " + requestData);
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

//        salesID = reference.child(ID).child("sales").getKey();
//        let firebase_node = firebase.database().ref('/user');
//        firebase_node.once('value', parent => alert('Count: ' + parent.numChildren()));

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
                newId++;
                System.out.println("newId: " + newId);
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


        //お客側　　お店掲示板編集画面→　Top画面に進むボタン(投稿ボタンを押した場合)
        Button ShopSaleWriteButton= findViewById(R.id.ShopSaleWriteButton);

        //お客側　　お店掲示板編集画面→　Top画面に進むボタン(投稿ボタンを押した場合)
        ShopSaleWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理
                String text = editText.getText().toString();

                if(!text.equals("")){
//                    if(salesID != "1"){
//                        salesID = salesID + 1;
//                    }
                    newId++;
                    reference1.child(String.valueOf(newId)).child("sales").setValue(text,null);
                    reference1.child(String.valueOf(newId)).child("storeId").setValue(String.valueOf(id),null);
                    reference1.child(String.valueOf(newId)).child("storeName").setValue(storeName,null);

                    Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
//                    reference.child("07_お知らせ").child(id).child("sales").child(String.valueOf(salesID)).setValue(text,null);

                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
//                //インテントの作成
//                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
//                Intent intent = new Intent(ShopListWrite.this,ShopTop.class);
//                intent.putExtra("order",ID);
//                //画面遷移
//                startActivity(intent);

            }
        });


        //お店掲示板編集画面→Top画面に進むボタン（トップに戻るボタンを押したとき）
        Button BackTopButton = findViewById(R.id.ShopTopButton);

        //お店掲示板編集画面→Top画面に進むボタン（トップに戻るボタンを押したとき）
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopListWrite.this, ShopTop.class);
                intent.putExtra("order",id);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
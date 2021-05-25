package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShopListWrite extends AppCompatActivity {

    private EditText editText;
    private String salesID = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_write);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("order");

        editText = (EditText) findViewById(R.id.editTextTextShopSale);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//        salesID = reference.child(ID).child("sales").getKey();
//        let firebase_node = firebase.database().ref('/user');
//        firebase_node.once('value', parent => alert('Count: ' + parent.numChildren()));



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
                    Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
                    reference.child("06_店舗情報").child(ID).child("sales").child(String.valueOf(salesID)).setValue(text,null);

                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopListWrite.this,ShopTop.class);
                intent.putExtra("order",ID);
                //画面遷移
                startActivity(intent);

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
                intent.putExtra("order",ID);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
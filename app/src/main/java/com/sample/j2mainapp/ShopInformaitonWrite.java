package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShopInformaitonWrite extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_informaiton_write);

        editText1 = (EditText)findViewById(R.id.WriteShopNameContent);
        editText2 = (EditText)findViewById(R.id.WriteShopAreaContent);
        editText3 = (EditText)findViewById(R.id.WriteShopPhoneContent);
        editText4 = (EditText)findViewById(R.id.WriteShopMemoContent);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("order");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.child("06_店舗情報/"+ID).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildValue) {
                //System.out.println("ID"+ ID +"のキーデータ：" + (String)snapshot.getKey());

                if(((String)snapshot.getKey()).compareTo("storeName") == 0){
                    String requestData = snapshot.getValue(String.class);
                    editText1.setText(requestData);
                    System.out.println("ShopName is " + requestData);
                }else if(((String)snapshot.getKey()).compareTo("area") == 0) {
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


        //店側　お店基本情報編集画面→ShopTop画面に進むボタン
        final Button BackShopTopButton = findViewById(R.id.ShopTopButton);

        //店側　お店基本情報編集画面→ShopTop画面に進むボタン
        BackShopTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopInformaitonWrite.this, ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });



        //店側　お店基本情報編集画面→　お店基本情報画面に進むボタン（編集完了ボタン）
        final Button WrittenShopFinishButton = findViewById(R.id.WrittenShopFinishButton);

        //店側　お店基本情報編集画面→　お店基本情報画面に進むボタン（編集完了ボタン）
        WrittenShopFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                if(!text1.equals("")){
                    Toast.makeText(v.getContext(),text1,Toast.LENGTH_SHORT).show();
                    reference.child("06_店舗情報").child(ID).child("storeName").setValue(text1,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                String text2 = editText2.getText().toString();
                if(!text2.equals("")){
                    Toast.makeText(v.getContext(),text2,Toast.LENGTH_SHORT).show();
                    reference.child("06_店舗情報").child(ID).child("area").setValue(text2,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                String text3 = editText3.getText().toString();
                if(!text3.equals("")){
                    Toast.makeText(v.getContext(),text3,Toast.LENGTH_SHORT).show();
                    reference.child("06_店舗情報").child(ID).child("tel").setValue(text3,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                String text4 = editText4.getText().toString();
                if(!text4.equals("")){
                    Toast.makeText(v.getContext(),text4,Toast.LENGTH_SHORT).show();
                    reference.child("06_店舗情報").child(ID).child("detail").setValue(text4,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(ShopInformaitonWrite.this, InputShopInformation.class);
                intent.putExtra("order",ID);
                //画面遷移
                startActivity(intent);
            }
        });
    }

}
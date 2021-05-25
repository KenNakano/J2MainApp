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

public class InputShopInformation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_shop_information);

        Intent intent = getIntent();
        String ID = intent.getStringExtra("order");


//        String ID = "1";

        //listenerにDBの値を返す
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("06_店舗情報").child(ID).child("storeName").addValueEventListener(listener);
        reference.child("06_店舗情報").child(ID).child("area").addValueEventListener(listener2);
        reference.child("06_店舗情報").child(ID).child("tel").addValueEventListener(listener3);
        reference.child("06_店舗情報").child(ID).child("detail").addValueEventListener(listener4);


        //店側　お店基本情報表示画面→ShopTop画面に進むボタン
        final Button BackShopTopButton = findViewById(R.id.ShopTopButton);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        BackShopTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputShopInformation.this, ShopTop.class);
                intent.putExtra("order",ID);
                //画面遷移
                startActivity(intent);

            }
        });


        //店側　お店基本情報表示画面→お店基本情報表示編集　画面に進むボタン
        final Button WriteShopFinishButton= findViewById(R.id.WriteShopFinishButton);

        //店側　お店基本情報表示画面→お店基本情報表示編集　画面に進むボタン
        WriteShopFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputShopInformation.this, ShopInformaitonWrite.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }

//DBの結果をTextViewに表示
    ValueEventListener listener = new ValueEventListener()
    {
            public void onDataChange(DataSnapshot snapshot)
            {
                TextView text = findViewById(R.id.ShopNameContent);//ここでID付けしたテキストに繋がる。
                String message = (String)snapshot.getValue();
                text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
            }
            public void onCancelled(DatabaseError error) {
            }
        };
    ValueEventListener listener2 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.ShopAreaContent);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
    ValueEventListener listener3 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.ShopPhoneContent);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
    ValueEventListener listener4 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.ShopMemoContent);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
}
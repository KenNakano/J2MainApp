package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InputOrder extends AppCompatActivity {

    private EditText editText;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_order);

        editText = (EditText)findViewById(R.id.editTextTextPersonName2);
        textView1 = (TextView) findViewById(R.id.content1);
        textView2 = (TextView) findViewById(R.id.Content2);
        textView3 = (TextView) findViewById(R.id.Content3);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("01_提案").child("ID").child("proposer").addValueEventListener(listener);
        reference.child("01_提案").child("ID").child("about").addValueEventListener(listener2);
        reference.child("01_提案").child("ID").child("area").addValueEventListener(listener3);



        //依頼側　ついでに依頼画面→　実行者がタスクを完了するまで待機する画面に進む(実行ボタンを押したとき)
        Button WriteFinishButton = findViewById(R.id.WriteFinishButton);

        //依頼側　ついでに依頼画面→投稿完了画面に進むボタンが操作された時の動作
        WriteFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理
                String text = editText.getText().toString();
                if(!text.equals("")){
                    Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
                    reference.child("02_提案済み（ペア成立）").child("ID").child("about").setValue(text,null);
                    reference.child("04_受注済み（ペア成立）").child("ID").child("about").setValue(text,null);
                  }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputOrder.this,OrderTime.class);
                //画面遷移
                startActivity(intent);

            }
        });



        //依頼側　ついでに依頼画面→　Top画面に進む(お断りボタンを押したとき)
        Button IraiRefuseButton = findViewById(R.id.IraiRefuseButton);

        //依頼側　ついでに依頼画面→投稿完了画面に進むボタンが操作された時の動作
        IraiRefuseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputOrder.this,Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
        //依頼側　ついでに依頼画面→　Top画面に進む(トップボタンを押したとき)
        Button BackTopButton = findViewById(R.id.TopButton);

        //依頼側　ついでに依頼画面→投稿完了画面に進むボタンが操作された時の動作
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputOrder.this,Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }

    //DBの結果をニックネームに表示
    ValueEventListener listener = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.content1);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
    //DBの結果を紹介文に表示
    ValueEventListener listener2 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.Content2);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
    //DBの結果をエリアに表示
    ValueEventListener listener3 = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            TextView text = findViewById(R.id.Content3);//ここでID付けしたテキストに繋がる。
            String message = (String)snapshot.getValue();
            text.setText(message);  //TextViewにlistenerによってDBから受信したメッセージを表示
        }
        public void onCancelled(DatabaseError error) {
        }
    };
}
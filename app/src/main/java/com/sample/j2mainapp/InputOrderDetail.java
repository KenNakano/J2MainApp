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

public class InputOrderDetail extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_order_detail);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        editText = (EditText)findViewById(R.id.editTextTextPersonName2);
        editText2 = (EditText)findViewById(R.id.editText);

        //実行側　詳細情報入力画面→Top画面に進むボタン(完了ボタンが押されたとき)
        final Button FinishGoButton = findViewById(R.id.kanryo);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        FinishGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理
                String text = editText.getText().toString();
                if(!text.equals("")){
                    Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
                    reference.child("03_非受注").child("1").child("about").setValue(text,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                String text2 = editText2.getText().toString();
                if(!text2.equals("")){
                    Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
                    reference.child("03_非受注").child("1").child("etc").setValue(text2,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputOrderDetail.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //実行側　詳細情報入力画面→Top画面に進むボタン（Topに戻るボタンが押されたとき）
        final Button BackTopButton = findViewById(R.id.TopButton);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputOrderDetail.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
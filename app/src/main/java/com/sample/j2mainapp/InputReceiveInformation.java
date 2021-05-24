package com.sample.j2mainapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputReceiveInformation extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_receive_information);

        editText = (EditText)findViewById(R.id.editTextTextPersonName2);
//      button = (Button)findViewById(R.id.inputbutton);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        //実行側　詳細情報入力画面→Top画面に進むボタン（完了GO！ボタンが押されたとき）
        final Button FinishGoButton = findViewById(R.id.KanryoButton);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        FinishGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputReceiveInformation.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });

//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                String text = editText.getText().toString();
//                if(!text.equals("")){
//                    Toast.makeText(view.getContext(),text,Toast.LENGTH_SHORT).show();
//                    reference.child("01_提案").child("ID").child("about").setValue(text,null);
//
//                }
//                else {
//                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        //実行側　詳細情報入力画面→Top画面に進むボタン（トップボタンが押されたとき）
        final Button BackTopButton = findViewById(R.id.TopButton);

        //実行側　詳細情報入力画面→Top画面に進むボタンが操作された時の動作
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理
                String text = editText.getText().toString();
                if(!text.equals("")){
                    Toast.makeText(v.getContext(),text,Toast.LENGTH_SHORT).show();
                    reference.child("01_提案").child("ID").child("about").setValue(text,null);
                }
                else {
                    Toast.makeText(v.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(InputReceiveInformation.this, Top.class);
                //画面遷移
                startActivity(intent);

            }
        });
    }
}
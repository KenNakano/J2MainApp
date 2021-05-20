package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InputOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_order);

        //依頼側　ついでに依頼画面→　実行者がタスクを完了するまで待機する画面に進む(実行ボタンを押したとき)
        Button WriteFinishButton = findViewById(R.id.WriteFinishButton);

        //依頼側　ついでに依頼画面→投稿完了画面に進むボタンが操作された時の動作
        WriteFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

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
}
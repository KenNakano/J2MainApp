package com.sample.j2mainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShopList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);

        // ListViewに表示するリスト項目をArrayListで準備する
        ArrayList data = new ArrayList<>();
        data.add("○○パン屋");
        data.add("△△商店街 八百屋");
        data.add("西船橋喫茶店");
        data.add("○×パン屋");
        data.add("○○スーパー");
        data.add("商店街");
        data.add("○○店");
        data.add("○○八百屋");
        data.add("○×スーパー");

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);




        //お客側　　お店一覧画面→　　お店詳細画面に進むボタン
        Button  ToShopDetailButton= findViewById(R.id.ToShopDetailButton);

        //お客側　　お店一覧画面→　　お店詳細画面に進むボタン
        ToShopDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopList.this,ShopDetail.class);
                //画面遷移
                startActivity(intent);

            }
        });


        //お店一覧画面→ショップTop画面に進むボタン
        Button BackShopTopButton = findViewById(R.id.ShopTopButton);

        //お店詳細画面→Top画面に進むボタン
        BackShopTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopList.this, ShopTop.class);
                //画面遷移
                startActivity(intent);

            }
        });

        //お客側　　お店一覧画面→　　クーポン一覧画面に進むボタン
        Button  CouponInformationButton= findViewById(R.id.CouponInformationButton);

        //お客側　　お店一覧画面→　　クーポン一覧画面に進むボタン
        CouponInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopList.this,CouponList.class);
                //画面遷移
                startActivity(intent);

            }
        });

    }
}
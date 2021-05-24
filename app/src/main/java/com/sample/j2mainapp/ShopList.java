package com.sample.j2mainapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ShopList extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        listView = findViewById(R.id.ShopList);
//        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("06_店舗情報");
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

                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
//                OrderReceive.topOrder(values[0]);
                Intent intent = new Intent(ShopList.this, ShopDetail.class);
                //画面遷移
                intent.putExtra("order",values[0]);

                startActivity(intent);

                System.out.println("クリック！→" + item);
//                reference.child("").child(item).addValueEventListener(listener);
            }
        });

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot , @Nullable String previousChildName) {
                try {
                    String value = dataSnapshot.getValue(ShopData.class).toString();
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

/*
        // ListViewに表示するリスト項目をArrayListで準備する
        /*ArrayList data = new ArrayList<>();
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
        listView.setAdapter(adapter);*/





/*
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
*/


        //お店一覧画面→ショップTop画面に進むボタン
        Button BackTopButton = findViewById(R.id.TopButton);

        //お店詳細画面→Top画面に進むボタン
        BackTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(ShopList.this, Top.class);
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
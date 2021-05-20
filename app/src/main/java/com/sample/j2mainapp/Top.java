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

public class Top extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        listView = findViewById(R.id.topList);
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);

//        switch (pos) {
//            case 0:
//                startActivity(new Intent(this, RequestData.class));
//                break;
//            case 1:
//                startActivity(new Intent(this, RequestData.class));
//                break;
//        }

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("非受注");
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

                System.out.println("クリック！→" + item);
            }
        });

//
//        reference.child("001").addValueEventListener(listener);
//

        i = i + 3;

//        reference.child(String.valueOf(i)).child("name").setValue("向井",null);
//        reference.child(String.valueOf(i)).child("about").setValue("キッチンペーパーを買ってきてほしい",null);
//        reference.child(String.valueOf(i)).child("deadline").setValue("2021/05/22;18:00",null);
//        reference.child(String.valueOf(i)).child("area").setValue("西船橋",null);
//        reference.child(String.valueOf(i)).child("etc").setValue("特に急ぎではありません",null);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot , @Nullable String previousChildName) {
                try {
                    String value =dataSnapshot.getValue(RequestData.class).toString();
                    arrayList.add(value);
                    arrayAdapter.notifyDataSetChanged();
                    System.out.println("データを入れました。");
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

        //Top画面→店舗一覧画面に進むボタン
        final Button ShopListbutton = findViewById(R.id.ShopListButton);

        //Top画面→店舗一覧画面に進むボタン処理
        ShopListbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, ShopList.class);
                //画面遷移
                startActivity(intent);

            }
        });



        //Top画面→手伝う画面に進むボタン
        final Button OrderConfirmbutton = findViewById(R.id.RequestConfirmButton);

        //Top画面→手伝う画面に進むボタンが操作された時の動作
        OrderConfirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンが押された時の処理

                //インテントの作成
                //引数の1つ目は遷移元のアクティビティのクラス、2つ目は遷移先のアクティビティのクラスとなっています。
                Intent intent = new Intent(Top.this, RequestConfirm.class);
                //画面遷移
                startActivity(intent);

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

//    ValueEventListener listener = new ValueEventListener() {
//        public void onDataChange(DataSnapshot snapshot) {
//            System.out.println("データを受信しました。 "
//                    + snapshot.getKey() + " = " + snapshot.getValue());
//            TextView text = findViewById(R.id.textView);//ここでID付けしたテキストに繋がる。
//            text.setText(snapshot.getValue().toString());
//
//        }
//
//        public void onCancelled(DatabaseError error) {
//            System.out.println("データ受信がキャンセルされました。" + error.toString());
//        }
//
//        //Button button = findViewById(R.id.buttonChangeMessage);
//        //button.setOnClickListener( new MyOnClickListener() );
//
//    };

}
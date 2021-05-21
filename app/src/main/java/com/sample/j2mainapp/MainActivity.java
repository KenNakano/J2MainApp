package com.sample.j2mainapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference reference;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

/*
    public static void main(String[] args){
        System.out.println("mainが動いています。");
    }
*/

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_top);
            reference = FirebaseDatabase.getInstance().getReference("非受注");
            listView=(ListView) findViewById(R.id.topList);
            arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);

            reference.child("非受注").addValueEventListener(listener);

            reference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot , @Nullable String previousChildName) {
                    String value =dataSnapshot.getValue(RequestData.class).toString();
                    arrayList.add(value);
                    arrayAdapter.notifyDataSetChanged();
                    System.out.println("データを入れました。");
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

//        reference.child("key1").setValue("こんにちは！",null);
//        reference.child("key2").setValue("おはよう！",null);
//        reference.child("key3").setValue("こんばんは！",null);
//        reference.child("folder").child("a").child("ああああ！").setValue("いいいい！",null);
//        reference.child("folder").child("b").setValue("2021/05/13",null);
//        reference.child("folder").child("a").setValue("こんにちは",null);


/*
      reference.child("01_提案").child("ID").child("01_proposer").setValue("Jack",null);
      reference.child("01_提案").child("ID").child("02_about").setValue("About",null);
      reference.child("01_提案").child("ID").child("03_deadline").setValue("????/??/??",null);
      reference.child("01_提案").child("ID").child("04_area").setValue("London",null);
      reference.child("01_提案").child("ID").child("05_etc").setValue("ABC",null);

      reference.child("02_提案済み（ペア成立）").child("ID").child("01_proposer").setValue("Jack",null);
      reference.child("02_提案済み（ペア成立）").child("ID").child("02_about").setValue("About",null);
      reference.child("02_提案済み（ペア成立）").child("ID").child("03_deadline").setValue("????/??/??",null);
      reference.child("02_提案済み（ペア成立）").child("ID").child("04_area").setValue("London",null);
      reference.child("02_提案済み（ペア成立）").child("ID").child("05_etc").setValue("ABC",null);
      reference.child("02_提案済み（ペア成立）").child("ID").child("06_requester").setValue("Dan",null);

      reference.child("03_非受注").child("ID").child("01_requester").setValue("Jack",null);
      reference.child("03_非受注").child("ID").child("02_about").setValue("About",null);
      reference.child("03_非受注").child("ID").child("03_deadline").setValue("????/??/??",null);
      reference.child("03_非受注").child("ID").child("04_area").setValue("London",null);
      reference.child("03_非受注").child("ID").child("05_etc").setValue("ABC",null);

//        reference.child("非受注").child("002").child("提案者").setValue("中野",null);
//        reference.child("非受注").child("002").child("提案内容").setValue("ファミマのケーキが欲しい",null);
//        reference.child("非受注").child("002").child("受付締め切り").setValue("2021/05/13;15:00",null);
//        reference.child("非受注").child("002").child("エリア（所属場所）").setValue("西船橋",null);
//        reference.child("非受注").child("002").child("備考【テキスト】").setValue("？？？",null);

//        reference.child("非受注").child("001").child("備考【テキスト】").setValue(a[0],null);


      reference.child("04_受注済み（ペア成立）").child("ID").child("01_requester").setValue("Dan",null);
      reference.child("04_受注済み（ペア成立）").child("ID").child("02_about").setValue("About",null);
      reference.child("04_受注済み（ペア成立）").child("ID").child("03_deadline").setValue("????/??/??",null);
      reference.child("04_受注済み（ペア成立）").child("ID").child("04_area").setValue("London",null);
      reference.child("04_受注済み（ペア成立）").child("ID").child("05_etc").setValue("ABC",null);
      reference.child("04_受注済み（ペア成立）").child("ID").child("06_contractor").setValue("Jack",null);

    //会員情報
        reference.child("05_会員情報").child("会員番号").child("01_name").setValue("？？",null);
        reference.child("05_会員情報").child("会員番号").child("02_gender").setValue("？？",null);
        reference.child("05_会員情報").child("会員番号").child("03_area").setValue("？？",null);
        reference.child("05_会員情報").child("会員番号").child("04_point").setValue("？？",null);
        reference.child("05_会員情報").child("会員番号").child("05_etc").setValue("？？",null);

    //店舗情報
        reference.child("06_店舗情報").child("店舗ID").child("01_storeName").setValue("？？",null);
        reference.child("06_店舗情報").child("店舗ID").child("02_area").setValue("？？",null);
        reference.child("06_店舗情報").child("店舗ID").child("03_sales").child("セールID").child("01_item").setValue("人参3本",null);
        reference.child("06_店舗情報").child("店舗ID").child("03_sales").child("セールID").child("02_price").setValue("150",null);
        reference.child("06_店舗情報").child("店舗ID").child("03_sales").child("セールID").child("03_deadline").setValue("XXXX/XX/XX",null);
*/

/*
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
*/
        }

        ValueEventListener listener = new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("データを受信しました。 "
                        + snapshot.getKey() + " = " + snapshot.getValue());
                TextView text = findViewById(R.id.textView);//ここでID付けしたテキストに繋がる。
                text.setText(snapshot.getValue().toString());

            }

            public void onCancelled(DatabaseError error) {
                System.out.println("データ受信がキャンセルされました。" + error.toString());
            }

            //Button button = findViewById(R.id.buttonChangeMessage);
            //button.setOnClickListener( new MyOnClickListener() );

        };

//    public static void dataAdd(String value){
//
//    }

//    ValueEventListener listener2 = new ValueEventListener()
//    {
//
//        public void onDataChange(DataSnapshot snapshot)
//        {
//            System.out.println("データを受信しました。 "
//                    + snapshot.getKey() + " = " + snapshot.getValue());
//            TextView text = findViewById(R.id.mainText);//ここでID付けしたテキストに繋がる。
//            text.setText(snapshot.getValue().toString());
//        }
//
//        public void onCancelled(DatabaseError error)
//        {
//            System.out.println("データ受信がキャンセルされました。" + error.toString());
//        }
//
//    };

//        //Button button = findViewById(R.id.buttonChangeMessage);
//        //button.setOnClickListener( new MyOnClickListener() );


}
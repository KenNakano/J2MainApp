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

public class ListLineup extends AppCompatActivity {

    DatabaseReference reference;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

//        public static void main(String[] args){
//        System.out.println("mainが動いています。");
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        reference = FirebaseDatabase.getInstance().getReference("非受注");
        listView=(ListView) findViewById(R.id.topList);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        arrayList.add("胡椒");
        arrayList.add("あ");

        reference.child("非受注").child("002").addValueEventListener(listener);

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
    }

    ValueEventListener listener = new ValueEventListener() {
        public void onDataChange(DataSnapshot snapshot) {
            System.out.println("データを受信しました。 "
                    + snapshot.getKey() + " = " + snapshot.getValue());
            TextView text = findViewById(R.id.textView);//ここでID付けしたテキストに繋がる。
            text.setText(snapshot.getValue().toString());
            for (int i = 1; i < 3; i++) {
                String value = String.valueOf(snapshot.getValue());
                System.out.println("データを格納しました。　"
                        + i + " = " + value);
            }
        }

            public void onCancelled (DatabaseError error)
            {
                System.out.println("データ受信がキャンセルされました。" + error.toString());
            }

            //Button button = findViewById(R.id.buttonChangeMessage);
            //button.setOnClickListener( new MyOnClickListener() );

    };

}

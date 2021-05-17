package com.sample.j2mainapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
//        data.add("胡椒");
//        data.add("ターメリック");
//        data.add("コリアンダー");

        ListView listView = (ListView) findViewById(R.id.list);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("非受注").addValueEventListener(listener);
//        reference.child("非受注").child("002").addValueEventListener(listener2);


/*
       reference.addChildEventListener(new ChildEventListener() {
            //            データを読み込むときはイベントリスナーを登録して行う。
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                アイテムのリストを取得するか、アイテムのリストへの追加がないかリッスンします。
                RequestData requestData = dataSnapshot.getValue(RequestData.class);
//                adapter.add(requestData);
//                adapter.notifyDataSetChanged();
            }

//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
////                リスト内のアイテムに対する変更がないかリッスンします。
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
////                リストから削除されるアイテムがないかリッスンします。
//                Log.d("ToDoActivity", "onChildRemoved:" + dataSnapshot.getKey());
//                ToDoData result = dataSnapshot.getValue(ToDoData.class);
//                if (result == null) return;
//
//                ToDoData item = mCustomAdapter.getUserDataKey(result.getFirebaseKey());
//
//                mCustomAdapter.remove(item);
//                mCustomAdapter.notifyDataSetChanged();
//            }

//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
////                並べ替えリストの項目順に変更がないかリッスンします。
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
////                ログを記録するなどError時の処理を記載する。
//            }
        });
*/

//        reference.child("key1").setValue("こんにちは！",null);
//        reference.child("key2").setValue("おはよう！",null);
//        reference.child("key3").setValue("こんばんは！",null);
//        reference.child("folder").child("a").child("ああああ！").setValue("いいいい！",null);
//        reference.child("folder").child("b").setValue("2021/05/13",null);
//        reference.child("folder").child("a").setValue("こんにちは",null);



//      reference.child("提案").child("ID").child("提案者").setValue("提案者",null);
//      reference.child("提案").child("ID").child("提案内容").setValue("提案内容",null);
//		reference.child("提案").child("ID").child("受付締め切り").setValue("受付締め切り",null);
//		reference.child("提案").child("ID").child("エリア（所属場所）").setValue("エリア（所属場所）",null);
//		reference.child("提案").child("ID").child("備考【テキスト】").setValue("備考【テキスト】",null);
//
//		reference.child("提案済み（ペア成立）").child("ID").child("提案者").setValue("提案者",null);
//		reference.child("提案済み（ペア成立）").child("ID").child("依頼者").setValue("依頼者",null);
//		reference.child("提案済み（ペア成立）").child("ID").child("提案内容").setValue("提案内容",null);
//		reference.child("提案済み（ペア成立）").child("ID").child("受付締め切り").setValue("受付締め切り",null);
//		reference.child("提案済み（ペア成立）").child("ID").child("エリア（所属場所）").setValue("エリア（所属場所)",null);
//		reference.child("提案済み（ペア成立）").child("ID").child("備考【テキスト】").setValue("備考【テキスト】",null);
//
//        reference.child("非受注").child("ID").child("提案者").setValue("提案者",null);
//        reference.child("非受注").child("ID").child("提案内容").setValue("提案内容",null);
//        reference.child("非受注").child("ID").child("受付締め切り").setValue("受付締め切り",null);
//        reference.child("非受注").child("ID").child("エリア（所属場所）").setValue("エリア（所属場所）",null);
//        reference.child("非受注").child("ID").child("備考【テキスト】").setValue("備考【テキスト】",null);

//        reference.child("非受注").child("002").child("提案者").setValue("中野",null);
//        reference.child("非受注").child("002").child("提案内容").setValue("ファミマのケーキが欲しい",null);
//        reference.child("非受注").child("002").child("受付締め切り").setValue("2021/05/13;15:00",null);
//        reference.child("非受注").child("002").child("エリア（所属場所）").setValue("西船橋",null);
//        reference.child("非受注").child("002").child("備考【テキスト】").setValue("？？？",null);

//        reference.child("非受注").child("001").child("備考【テキスト】").setValue(a[0],null);


//        reference.child("受注済み（ペア成立）").child("ID").child("提案者").setValue("提案者",null);
//        reference.child("受注済み（ペア成立）").child("ID").child("依頼者").setValue("依頼者",null);
//        reference.child("受注済み（ペア成立）").child("ID").child("提案内容").setValue("提案内容",null);
//        reference.child("受注済み（ペア成立）").child("ID").child("受付締め切り").setValue("受付締め切り",null);
//        reference.child("受注済み（ペア成立）").child("ID").child("エリア（所属場所）").setValue("エリア（所属場所）",null);
//        reference.child("受注済み（ペア成立）").child("ID").child("備考【テキスト】").setValue("備考【テキスト】",null);

//会員情報
//        reference.child("会員情報").child("会員番号").child("名前").setValue("？？",null);
//        reference.child("会員情報").child("会員番号").child("性別").setValue("？？",null);
//        reference.child("会員情報").child("会員番号").child("エリア").setValue("？？",null);
//        reference.child("会員情報").child("会員番号").child("所持ポイント").setValue("？？",null);
//        reference.child("会員情報").child("会員番号").child("その他").setValue("？？",null);

//店舗情報
//        reference.child("店舗情報").child("店舗ID").child("店舗名").setValue("？？",null);
//        reference.child("店舗情報").child("店舗ID").child("エリア").setValue("？？",null);
//        reference.child("店舗情報").child("店舗ID").child("セール内容").child("セールID").child("セール品").setValue("？？",null);
//        reference.child("店舗情報").child("店舗ID").child("セール内容").child("セールID").child("値段").setValue("？？",null);
//        reference.child("店舗情報").child("店舗ID").child("セール内容").child("セールID").child("締め切り時間").setValue("？？",null);

/*
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
*/
    }

/*    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

            // A comment has changed, use the key to determine if we are displaying this
            // comment and if so displayed the changed comment.
           // Comment newComment = dataSnapshot.getValue(Comment.class);
            String commentKey = dataSnapshot.getKey();

            // ...
        }

    };
        databaseReference.addChildEventListener(childEventListener);
*/

    ValueEventListener listener = new ValueEventListener()
    {
        public void onDataChange(DataSnapshot snapshot)
        {
            System.out.println("データを受信しました。 "
                    + snapshot.getKey() + " = " + snapshot.getValue());
            TextView text = findViewById(R.id.mainText);//ここでID付けしたテキストに繋がる。
            text.setText(snapshot.getValue().toString());
            for(int i=1; i<3; i++){
                String value = String.valueOf(snapshot.getValue());

//                data.add(value);
//                dataAdd(value);
            }

            for (DataSnapshot ds : snapshot.getChildren()) {
//                RequestData object = ds.getValue(RequestData.class);
                data.add(snapshot.getValue().toString());
                list.setAdapter(adapter);
            }

        }

        public void onCancelled(DatabaseError error)
        {
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
//        //Button button = findViewById(R.id.buttonChangeMessage);
//        //button.setOnClickListener( new MyOnClickListener() );
//
//    };

}
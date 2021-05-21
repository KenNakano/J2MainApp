package com.sample.j2mainapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DatabaseUpdate  extends AppCompatActivity {

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
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

//        reference.child("key1").setValue("こんにちは！",null);
//        reference.child("key2").setValue("おはよう！",null);
//        reference.child("key3").setValue("こんばんは！",null);
//        reference.child("folder").child("a").child("ああああ！").setValue("いいいい！",null);
//        reference.child("folder").child("b").setValue("2021/05/13",null);
//        reference.child("folder").child("a").setValue("こんにちは",null);

//        reference.child("非受注").child("002").child("提案者").setValue("中野",null);
//        reference.child("非受注").child("002").child("提案内容").setValue("ファミマのケーキが欲しい",null);
//        reference.child("非受注").child("002").child("受付締め切り").setValue("2021/05/13;15:00",null);
//        reference.child("非受注").child("002").child("エリア（所属場所）").setValue("西船橋",null);
//        reference.child("非受注").child("002").child("備考【テキスト】").setValue("？？？",null);

//        reference.child("非受注").child("001").child("備考【テキスト】").setValue(a[0],null);



        //J班データベース　テンプレ
//        reference.child("01_提案").child("ID").child("id").setValue("Id",null);
//        reference.child("01_提案").child("ID").child("proposer").setValue("Jack",null);
//        reference.child("01_提案").child("ID").child("about").setValue("About",null);
//        reference.child("01_提案").child("ID").child("deadline").setValue("????/??/??",null);
//        reference.child("01_提案").child("ID").child("area").setValue("London",null);
//        reference.child("01_提案").child("ID").child("etc").setValue("ABC",null);
//
//        reference.child("02_提案済み（ペア成立）").child("ID").child("id").setValue("Id",null);
//        reference.child("02_提案済み（ペア成立）").child("ID").child("proposer").setValue("Jack",null);
//        reference.child("02_提案済み（ペア成立）").child("ID").child("about").setValue("About",null);
//        reference.child("02_提案済み（ペア成立）").child("ID").child("deadline").setValue("????/??/??",null);
//        reference.child("02_提案済み（ペア成立）").child("ID").child("area").setValue("London",null);
//        reference.child("02_提案済み（ペア成立）").child("ID").child("etc").setValue("ABC",null);
//        reference.child("02_提案済み（ペア成立）").child("ID").child("requester").setValue("Dan",null);
//
//        reference.child("03_非受注").child("ID").child("id").setValue("Id",null);
//        reference.child("03_非受注").child("ID").child("requester").setValue("Jack",null);
//        reference.child("03_非受注").child("ID").child("about").setValue("About",null);
//        reference.child("03_非受注").child("ID").child("deadline").setValue("????/??/??",null);
//        reference.child("03_非受注").child("ID").child("area").setValue("London",null);
//        reference.child("03_非受注").child("ID").child("etc").setValue("ABC",null);
//
//        reference.child("04_受注済み（ペア成立）").child("ID").child("id").setValue("Id",null);
//        reference.child("04_受注済み（ペア成立）").child("ID").child("requester").setValue("Dan",null);
//        reference.child("04_受注済み（ペア成立）").child("ID").child("about").setValue("About",null);
//        reference.child("04_受注済み（ペア成立）").child("ID").child("deadline").setValue("????/??/??",null);
//        reference.child("04_受注済み（ペア成立）").child("ID").child("area").setValue("London",null);
//        reference.child("04_受注済み（ペア成立）").child("ID").child("etc").setValue("ABC",null);
//        reference.child("04_受注済み（ペア成立）").child("ID").child("contractor").setValue("Jack",null);
//
//        //会員情報
//        reference.child("05_会員情報").child("会員番号").child("name").setValue("Jack",null);
//        reference.child("05_会員情報").child("会員番号").child("gender").setValue("Male",null);
//        reference.child("05_会員情報").child("会員番号").child("area").setValue("London",null);
//        reference.child("05_会員情報").child("会員番号").child("point").setValue("1200",null);
//        reference.child("05_会員情報").child("会員番号").child("etc").setValue("？？",null);
//
//        //店舗情報
//        reference.child("06_店舗情報").child("店舗ID").child("storeName").setValue("？？",null);
//        reference.child("06_店舗情報").child("店舗ID").child("area").setValue("？？",null);
//        reference.child("06_店舗情報").child("店舗ID").child("sales").child("セールID").child("id").setValue("Id",null);
//        reference.child("06_店舗情報").child("店舗ID").child("sales").child("セールID").child("item").setValue("人参3本",null);
//        reference.child("06_店舗情報").child("店舗ID").child("sales").child("セールID").child("price").setValue("150",null);
//        reference.child("06_店舗情報").child("店舗ID").child("sales").child("セールID").child("deadline").setValue("XXXX/XX/XX",null);

/*
        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
*/
    }
}

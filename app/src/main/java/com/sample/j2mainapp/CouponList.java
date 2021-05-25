package com.sample.j2mainapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class CouponList extends AppCompatActivity {

    private EditText editText;
    //    private EditText editText2;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    //    private Button button3;
    private TextView textView;
//    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        textView = (TextView) findViewById(R.id.textView);
//        textView2 = (TextView) findViewById(R.id.textView2);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("05_会員情報").child("会員番号").addValueEventListener(listener_root);



        String salemenu, salecost, saletime, message;
        //String proposename, proposecontents, requestcontents, deadline;
        String proposename[] = new String[100], proposecontents[] = new String[100], requestcontents[] = new String[100], deadline[] = new String[100];
        //String requestname;
        String requestname[] = new String[100];
        //String area, memberID, name, seibetu, point, other;
        String area[] = new String[100], memberID[] = new String[100], name[] = new String[100], seibetu[] = new String[100], other;

        int point[] = new int[100], s[] = new int[100], s1[] = new int[100], s2[] = new int[100];

        int i;



        other = "特になし";

//
        memberID[0] = "001";
        memberID[1] = "002";
        memberID[2] = "003";
        memberID[3] = "004";

        name[0] = "阿部";
        name[1] = "向井";
        name[2] = "野崎";
        name[3] = "兼子";

        area[0] = "西船橋";
        area[1] = "市川";
        area[2] = "西船橋";
        area[3] = "市川";

        seibetu[0] = "女性";
        seibetu[1] = "男性";
        seibetu[2] = "男性";
        seibetu[3] = "男性";

        point[0] = 100;
        point[1] = 400;
        point[2] = 500;
        point[3] = 1000;

        int input[] = new int[100];//Java内での入力
        input[0] = 1;
        input[1] = 0;
        input[2] = 1;



//        for (i = 0; i <= 3; i++) {
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s1[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
//            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);
//        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                int i;
//                if (!text.equals("")) {
                if (text.equals("001")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[0] = point[0] - 100;
                    if (point[0] >= 0) {
                        s[0] = s[0] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[0] = point[0] + 100;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    }
                } else if (text.equals("002")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[1] = point[1] - 100;
                    if (point[1] >= 0) {
                        s[1] = s[1] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    } else {
                        point[1] = point[1] + 100;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("003")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[2] = point[2] - 100;
                    if (point[2] >= 0) {
                        s[2] = s[2] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[2] = point[2] + 100;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("004")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[3] = point[3] - 100;
                    if (point[3] >= 0) {
                        s[3] = s[3] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[3] = point[3] + 100;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }


        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                int i;
//                if (!text.equals("")) {
                if (text.equals("001")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[0] = point[0] - 200;
                    if (point[0] >= 0) {
                        s1[0] = s1[0] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    } else {
                        point[0] = point[0] + 200;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("002")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[1] = point[1] - 200;
                    if (point[1] >= 0) {
                        s1[1] = s1[1] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[1] = point[1] + 200;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("003")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[2] = point[2] - 200;
                    if (point[2] >= 0) {
                        s1[2] = s1[2] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[2] = point[2] + 200;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("004")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[3] = point[3] - 200;
                    if (point[3] >= 0) {
                        s1[3] = s1[3] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[3] = point[3] + 200;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }


        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                int i;
//                if (!text.equals("")) {
                if (text.equals("001")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[0] = point[0] - 300;
                    if (point[0] >= 0) {
                        s2[0] = s2[0] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[0] = point[0] + 300;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("002")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[1] = point[1] - 300;
                    if (point[1] >= 0) {
                        s2[1] = s2[1] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[1] = point[1] + 300;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    }
                } else if (text.equals("003")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[2] = point[2] - 300;
                    if (point[2] >= 0) {
                        s2[2] = s2[2] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[2] = point[2] + 300;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("004")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    point[3] = point[3] - 300;
                    if (point[3] >= 0) {
                        s2[3] = s2[3] + 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        point[3] = point[3] + 300;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                int i;
//                if (!text.equals("")) {
                if (text.equals("001")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s[0] > 0) {
                        s[0] = s[0] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    }
                } else if (text.equals("002")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s[1] > 0) {
                        s[1] = s[1] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("003")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s[2] > 0) {
                        s[2] = s[2] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("004")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s[3] > 0) {
                        s[3] = s[3] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }


        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                int i;
//                if (!text.equals("")) {
                if (text.equals("001")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s1[0] > 0) {
                        s1[0] = s1[0] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    }
                } else if (text.equals("002")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s1[1] > 0) {
                        s1[1] = s1[1] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("003")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s1[2] > 0) {
                        s1[2] = s1[2] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("004")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s[3] > 0) {
                        s1[3] = s1[3] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }


        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                int i;
//                if (!text.equals("")) {
                if (text.equals("001")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s2[0] > 0) {
                        s2[0] = s2[0] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    }
                } else if (text.equals("002")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s2[1] > 0) {
                        s2[1] = s2[1] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }

                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("003")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s2[2] > 0) {
                        s2[2] = s2[2] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else if (text.equals("004")) {
                    textView.setText(text);
                    editText.setText("");
                    Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(view.getContext())
                            .setTitle("ダイアログ")
                            .setMessage(text)
                            .setPositiveButton("close", null)
                            .show();
//                    if (text == "001") {
                    if (s2[3] > 0) {
                        s2[3] = s2[3] - 1;
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    } else {
                        for (i = 0; i <= 3; i++) {
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("id").setValue(memberID[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("name").setValue(name[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("gender").setValue(seibetu[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("area").setValue(area[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("point").setValue(point[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("etc").setValue(other, null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon1").setValue(s[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon2").setValue(s1[i], null);
                            reference.child("05_会員情報").child("会員番号").child(memberID[i]).child("coupon3").setValue(s2[i], null);

                        }
                    }
                } else {
                    Toast.makeText(view.getContext(), "入力してください", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }

    ValueEventListener listener_root = new ValueEventListener() {

        public void onDataChange(DataSnapshot snapshot) {
            try {
                HashMap map = (HashMap) snapshot.getValue();
                Log.d("ishikawa", "onDataChange: " + map.toString());
                String number = textView.getText().toString();
                HashMap map_number = (HashMap) map.get(number);
                Log.d("ishikawa", "number = " + number);
                Long point = (Long) map_number.get("point");
                Log.d("ishikawa", "point = " + point);
//                HashMap map_coupon = (HashMap) map_number.get("所持クーポン１");
                Long coupon = (Long) map_number.get("coupon1");
//                Log.d("ishikawa", "coupon = " + coupon);
                Long coupon2 = (Long) map_number.get("coupon2");

                Long coupon3 = (Long) map_number.get("coupon3");

                TextView testtext = findViewById(R.id.testtext);
                testtext.setText(point + "");
                TextView testtext2 = findViewById(R.id.testtext2);
                testtext2.setText(coupon + "");
                TextView testtext3 = findViewById(R.id.testtext3);
                testtext3.setText(coupon2 + "");
                TextView testtext4 = findViewById(R.id.testtext4);
                testtext4.setText(coupon3 + "");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void onCancelled(DatabaseError error) {
        }
    };

}




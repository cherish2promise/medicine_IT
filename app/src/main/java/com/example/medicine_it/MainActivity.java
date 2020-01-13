package com.example.medicine_it;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "찾고자 하는 약 정보";
    public static final String EXTRA_MESSAGE2 = "찾고자 하는 약 정보2";

    Button medicineSearch, medicineRecom,Rgo; // 버튼
    LinearLayout SearchTab,RecomTab; //리니어 레이아웃
    EditText mediR, mediR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medicineSearch=(Button)findViewById(R.id.medicienSearch); // 1버튼
        medicineRecom=(Button)findViewById(R.id.medicienRecom); // 2 버튼
        SearchTab=(LinearLayout)findViewById(R.id.SearchTab); // 1L 버튼
        RecomTab=(LinearLayout)findViewById(R.id.RecomTab);// 2L 버튼
        Rgo = (Button)findViewById(R.id.Rgo); // resultActivity 가는 버튼
        mediR=(EditText)findViewById(R.id.mediR);
        mediR2=(EditText)findViewById(R.id.mediR2);


        medicineSearch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchTab.setVisibility(View.VISIBLE);
                RecomTab.setVisibility(View.GONE);
            }
        });
        medicineRecom.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchTab.setVisibility(View.GONE);
                RecomTab.setVisibility(View.VISIBLE);
                godb();

            }
        });
        Rgo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediInfo();
            }
        });
    }

    public void mediInfo() {
        Intent intent = new Intent(this, resultActivity.class);
        String message = mediR.getText().toString();
        String message2 = mediR2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }
    public void godb() {
        Intent intent = new Intent(this, dbTest.class);
        startActivity(intent);
    }
}

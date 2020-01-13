package com.example.medicine_it;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class dbTest extends AppCompatActivity {

    private DBManager mDBManager;
    String id = null;
    TextView settingDB;
    SQLiteDatabase sqlDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
        settingDB =(TextView)findViewById(R.id.settingDB);

        mDBManager = new DBManager(this);
        sqlDB= mDBManager.getReadableDatabase();
        Cursor cursor =sqlDB.rawQuery("SELECT * FROM medicineInfo",null);
        while(cursor.moveToNext()){
             id = cursor.getString(0);
        }
        settingDB.setText(id);
        mDBManager.close();

    }
}

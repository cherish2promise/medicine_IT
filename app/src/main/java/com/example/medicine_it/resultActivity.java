package com.example.medicine_it;

import androidx.appcompat.app.AppCompatActivity;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;

public class resultActivity extends AppCompatActivity {

    ListView list_excel ;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        list_excel = (ListView)findViewById(R.id.list_excel);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        Excel();

    }
    public void Excel() {
        Workbook workbook = null;
        Sheet sheet = null;


        try {
            InputStream inputStream = getBaseContext().getResources().getAssets().open("medicien.xlsx");
            System.out.println("동작중");
            workbook = Workbook.getWorkbook(inputStream);
            sheet = workbook.getSheet(0);

            int MaxColumn = 2, RowStart = 0, RowEnd = sheet.getColumn(MaxColumn - 1).length -1, ColumnStart = 0, ColumnEnd = sheet.getRow(2).length - 1;
            for(int row = RowStart;row <= RowEnd;row++) {
                String excelload = sheet.getCell(ColumnStart, row).getContents();
                arrayAdapter.add(excelload);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {
            list_excel.setAdapter(arrayAdapter);
            workbook.close();
        }
    }
}


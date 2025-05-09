package com.example.bai3_project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2, edt3;
    Button btncong,btntru, btnnhan, btnchia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edtA);
        edt2= findViewById(R.id.edtB);
        edt3= findViewById(R.id.edtC);
        btncong = findViewById(R.id.btnCong);
        btntru = findViewById(R.id.btnTru);
        btnnhan = findViewById(R.id.btnNhan);
        btnchia =findViewById(R.id.btnChia);

        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                int result = a+b;
                edt3.setText("" +result);
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                int result = a-b;
                edt3.setText("" +result);
            }
        });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                int result = a*b;
                edt3.setText("" +result);
            }
        });
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt("0"+edt1.getText());
                int b = Integer.parseInt("0" + edt2.getText());
                int result = a/b;
                edt3.setText("" +result);
            }
        });
    }
}
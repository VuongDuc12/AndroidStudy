package com.example.bai4_1_project_changetemplature;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtDoC, edtDoF;
    Button btncf, btnfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Đảm bảo layout này có các ID tương ứng

        edtDoC = findViewById(R.id.edtDoC);
        edtDoF = findViewById(R.id.edtDoF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.##");
                String doC = edtDoC.getText().toString().trim();

                if (!doC.isEmpty()) {
                    try {
                        int C = Integer.parseInt(doC);
                        double F = (C * 1.8) + 32;
                        edtDoF.setText(dcf.format(F));
                    } catch (NumberFormatException e) {
                        edtDoF.setText("Lỗi định dạng");
                        edtDoC.setText("");
                    }
                } else {
                    edtDoF.setText("");
                }
            }
        });

        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.##");
                String doF = edtDoF.getText().toString().trim();

                if (!doF.isEmpty()) {
                    try {
                        int F = Integer.parseInt(doF);
                        double C = (F - 32) / 1.8;
                        edtDoC.setText(dcf.format(C));
                    } catch (NumberFormatException e) {
                        edtDoC.setText("Lỗi định dạng");
                        edtDoF.setText("");
                    }
                } else {
                    edtDoC.setText("");
                }
            }
        });
    }
}
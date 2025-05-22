package com.example.lab7_2_giaiptb1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Activity_Secound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secound);
        EditText edtKetQua = findViewById(R.id.edtKetQua);
        Button btnback = findViewById(R.id.btnBack);
        Intent  yourIntent = getIntent();
        Bundle yourbundle = yourIntent.getBundleExtra("data");
        int soa = yourbundle.getInt("soa");
        int sob = yourbundle.getInt("sob");
        int a = yourbundle.getInt("soa");
        int b = yourbundle.getInt("sob");

        String kq = "";

        if (a == 0 && b == 0) {
            kq = "Vô số nghiệm";
        } else if (a == 0 && b != 0) {
            kq = "Vô nghiệm";
        } else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = dcf.format(-b * 1.0 / a);
        }

// Hiển thị kết quả lên EditText
        edtKetQua.setText(kq);

// Bắt sự kiện nút Quay lại
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc Activity hiện tại
            }

        });

    }
    }

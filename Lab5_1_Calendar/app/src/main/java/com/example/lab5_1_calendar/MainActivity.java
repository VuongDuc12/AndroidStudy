package com.example.lab5_1_calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtNamDuongLich;
    TextView textNamAmLich;
    Button btnChuyenDoi;

    String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Đảm bảo layout này là layout bạn đã tạo

        edtNamDuongLich = findViewById(R.id.edtNam);
        textNamAmLich = findViewById(R.id.textNamAmlich);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namDuongLichStr = edtNamDuongLich.getText().toString();

                if (namDuongLichStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập năm dương lịch", Toast.LENGTH_SHORT).show();
                    textNamAmLich.setText("");
                    return;
                }

                try {
                    int namDuongLich = Integer.parseInt(namDuongLichStr);
                    int canIndex = (namDuongLich % 10);
                    int chiIndex = (namDuongLich % 12);

                    String namAmLich = can[canIndex] + " " + chi[chiIndex];
                    textNamAmLich.setText(namAmLich);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Năm không hợp lệ", Toast.LENGTH_SHORT).show();
                    textNamAmLich.setText("");
                }
            }
        });
    }
}
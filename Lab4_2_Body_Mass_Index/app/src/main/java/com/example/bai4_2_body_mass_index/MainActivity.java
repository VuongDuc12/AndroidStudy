package com.example.bai4_2_body_mass_index;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editTen, editChieucao, editCannang, editBMI, editChuanDoan;
    Button btnTinhBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Đảm bảo layout này có các ID tương ứng

        editTen = findViewById(R.id.editTextTen);
        editChieucao = findViewById(R.id.editTextChieuCao);
        editCannang = findViewById(R.id.editTextCanNang);
        editBMI = findViewById(R.id.editTextBMI);
        editChuanDoan = findViewById(R.id.editTextChuanDoan);
        btnTinhBMI = findViewById(R.id.buttonTinhBMI);

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String chieucaoStr = editChieucao.getText().toString();
                String cannangStr = editCannang.getText().toString();

                if (chieucaoStr.isEmpty() || cannangStr.isEmpty()) {
                    editBMI.setText("Vui lòng nhập chiều cao và cân nặng");
                    editChuanDoan.setText("");
                    return;
                }

                double H = Double.parseDouble(chieucaoStr) / 100.0; // Chuyển cm sang mét
                double W = Double.parseDouble(cannangStr);
                double BMI = W / Math.pow(H, 2);

                String chandoan = "";
                if (BMI < 18.5) {
                    chandoan = "Bạn gầy";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }

                DecimalFormat dcf = new DecimalFormat("#.#");
                editBMI.setText(dcf.format(BMI));
                editChuanDoan.setText(chandoan);
            }
        });
    }
}
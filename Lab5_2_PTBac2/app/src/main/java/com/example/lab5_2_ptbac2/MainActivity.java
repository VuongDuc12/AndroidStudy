package com.example.lab5_2_ptbac2;

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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnTieptuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTieptuc = findViewById(R.id.btntieptuc);
        btnGiai = findViewById(R.id.btngiaipt);
        btnThoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtkq = findViewById(R.id.txtkq);


        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                txtkq.setText("Kết quả:");
                edita.requestFocus();
            }
        });

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText().toString().trim();
                String sb = editb.getText().toString().trim();
                String sc = editc.getText().toString().trim();

                if (sa.isEmpty() || sb.isEmpty() || sc.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ hệ số a, b, c", Toast.LENGTH_SHORT).show();
                    txtkq.setText("Kết quả:");
                    return;
                }

                try {
                    double a = Double.parseDouble(sa);
                    double b = Double.parseDouble(sb);
                    double c = Double.parseDouble(sc);
                    DecimalFormat dcf = new DecimalFormat("#.##");
                    String ketqua = "Kết quả: ";

                    if (a == 0) {
                        if (b == 0) {
                            if (c == 0) {
                                ketqua += "Phương trình vô số nghiệm";
                            } else {
                                ketqua += "Phương trình vô nghiệm";
                            }
                        } else {
                            double x = -c / b;
                            ketqua += "Phương trình có nghiệm x = " + dcf.format(x);
                        }
                    } else {
                        double delta = b * b - 4 * a * c;
                        if (delta < 0) {
                            ketqua += "Phương trình vô nghiệm";
                        } else if (delta == 0) {
                            double x = -b / (2 * a);
                            ketqua += "Phương trình có nghiệm kép x1 = x2 = " + dcf.format(x);
                        } else {
                            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                            ketqua += "Phương trình có 2 nghiệm: x1 = " + dcf.format(x1) + "; x2 = " + dcf.format(x2);
                        }
                    }
                    txtkq.setText(ketqua);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Hệ số không hợp lệ", Toast.LENGTH_SHORT).show();
                    txtkq.setText("Kết quả:");
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
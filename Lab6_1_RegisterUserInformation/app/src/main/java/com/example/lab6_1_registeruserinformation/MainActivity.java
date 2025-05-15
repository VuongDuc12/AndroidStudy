package com.example.lab6_1_registeruserinformation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lab6_1_registeruserinformation.R;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtCMND, edtGhiChu;
    RadioGroup rgBangCap;
    CheckBox cbDocBao, cbDocSach, cbDocCoding;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        edtName = findViewById(R.id.editName);
        edtCMND = findViewById(R.id.editCMND);
        edtGhiChu = findViewById(R.id.edtGhiChu);
        rgBangCap = findViewById(R.id.dgGroup);
        cbDocBao = findViewById(R.id.cbDocBao);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbDocCoding = findViewById(R.id.cbDocCoding);
        btnGui = findViewById(R.id.button2);

        // Bắt sự kiện nút "Gửi thông tin"
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtName.getText().toString().trim();
                String cmnd = edtCMND.getText().toString().trim();
                String ghichu = edtGhiChu.getText().toString().trim();

                // Kiểm tra hợp lệ
                if (ten.length() < 3) {
                    edtName.requestFocus();
                    Toast.makeText(MainActivity.this, "Họ tên phải >= 3 ký tự", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (cmnd.length() != 9) {
                    edtCMND.requestFocus();
                    Toast.makeText(MainActivity.this, "CMND phải đúng 9 ký tự", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Bằng cấp
                int idBangCap = rgBangCap.getCheckedRadioButtonId();
                if (idBangCap == -1) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn bằng cấp", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton radBangCap = findViewById(idBangCap);
                String bangCap = radBangCap.getText().toString();

                // Sở thích
                String sothich = "";
                if (cbDocBao.isChecked()) sothich += "Đọc Báo\n";
                if (cbDocSach.isChecked()) sothich += "Đọc Sách\n";
                if (cbDocCoding.isChecked()) sothich += "Đọc Coding\n";

                // Gộp thông tin
                String thongtin = "Họ tên: " + ten + "\n"
                        + "CMND: " + cmnd + "\n"
                        + "Bằng cấp: " + bangCap + "\n"
                        + "Sở thích:\n" + sothich
                        + "Ghi chú: " + ghichu;

                // Hiển thị Dialog
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông tin cá nhân")
                        .setMessage(thongtin)
                        .setPositiveButton("Đóng", null)
                        .show();
            }
        });
    }
}

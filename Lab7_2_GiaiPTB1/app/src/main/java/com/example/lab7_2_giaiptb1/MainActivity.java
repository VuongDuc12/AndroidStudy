package com.example.lab7_2_giaiptb1;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText edtA = findViewById(R.id.edtA);
        EditText edtB = findViewById(R.id.edtB);
        Button btnSubmit = findViewById(R.id.btnSubmit);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Activity_Secound.class);
                Bundle bundle = new Bundle();
                int soa = Integer.parseInt(edtA.getText()+"");
                int sob = Integer.parseInt(edtB.getText()+"");
                bundle.putInt("soa",soa);
                bundle.putInt("sob",sob);
                intent1.putExtra("data",bundle);
                startActivity(intent1);

            }
        });
    }
}
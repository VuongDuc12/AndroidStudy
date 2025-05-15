package com.example.schoollearn_bai4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.schoollearn_bai4.Models.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listStudent;
    String [] names = {"An", "bình","châu", "dũng", " Hà"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listStudent = findViewById(R.id.listStudent);

        ArrayList<Student> lstOfStudents = new ArrayList<>();
        lstOfStudents.add(new Student("Nguyen Van A", 20 , "64KTPM1"));
        lstOfStudents.add(new Student("Nguyen Van b", 20 , "64KTPM1"));
        lstOfStudents.add(new Student("Nguyen Van C", 20 , "64KTPM1"));
        lstOfStudents.add(new Student("Nguyen Van D", 20 , "64KTPM1"));
        lstOfStudents.add(new Student("Nguyen Van E", 20 , "64KTPM1"));

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, R.layout.item_student, lstOfStudents);
        listStudent.setAdapter(adapter);
        listStudent.setOnItemClickListener((parent, view, position, id) -> {
            String selectedName = names[position];
            Toast.makeText(this, "Bạn chọn: " + selectedName, Toast.LENGTH_SHORT).show();
        });

    }}

package com.example.studentrecycle;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.studentrecycle.Models.Student;
import com.example.studentrecycle.adapter.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcyStudent;
    private List<Student> listofStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcyStudent = findViewById(R.id.rcy_students);
        listofStudent = new ArrayList<>();
        listofStudent.add(new Student("Nguyễn Văn An", 17, "12A1"));
        listofStudent.add(new Student("Trần Thị Bình", 18, "12A2"));
        listofStudent.add(new Student("Lê Văn Cường", 17, "12A3"));

        StudentAdapter adapter = new StudentAdapter(listofStudent,this);
//        rcyStudent.setLayoutManager(new GridLayoutManager(this,3
//                ));

        rcyStudent.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL
        ));


        rcyStudent.setAdapter(adapter);

    }
}
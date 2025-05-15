package com.example.schoollearn_bai4.Adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.schoollearn_bai4.Models.Student;
import com.example.schoollearn_bai4.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private  Context context;
    private ArrayList<Student> lstOfStudent;
    public StudentAdapter(Context context, ArrayList<Student> objects) {
        super(context, 0, objects);
        context = context;
        lstOfStudent = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_student,parent);
            Student = lst
        }
    }

    private
}

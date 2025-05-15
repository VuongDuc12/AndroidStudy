package com.example.studentrecycle.Models;

public class Student {
    private String name;
    private int age;
    private String classroom;

    public Student(String name, int age, String classroom) {
        this.name = name;
        this.age = age;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setName(String name) {
        this.name = name;
    }
}

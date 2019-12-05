package com.androidproject.adapterviewlab;

public class Student {
    private String name;
    private int mark = 0;

    public Student (String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return this.mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}

package com.kindleheart.model;

public class Student {
    private int id;
    private String scold;
    private String name;
    private String sex;

    public Student(int id, String scold, String name, String sex) {
        this.id = id;
        this.scold = scold;
        this.name = name;
        this.sex = sex;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScold() {
        return scold;
    }

    public void setScold(String scold) {
        this.scold = scold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}

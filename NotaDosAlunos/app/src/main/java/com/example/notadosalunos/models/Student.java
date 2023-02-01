package com.example.notadosalunos.models;

public class Student {

    private Integer id;
    private String name;
    private String grade1;
    private String grade2;

    private Float finalGrade;

//    private Str


    public Student(int id,String name,Float finalGrade){
        this.id = id;
        this.name = name;
        this.finalGrade = finalGrade;
    }
//    public Student (String name, String score1, String score2){
//        this.name = name;
//        this.grade1 = score1;
//        this.grade2 = score2;
//    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFinalGrade() {
        return String.valueOf(finalGrade);
    }
}

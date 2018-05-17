package com.ccc.bean;

public class TblStudent {
    private String StuId;//学号
    private  String StuName;//学生姓名
    private int StuAge;//学生年龄
    private String StuSex;//学生性别


    public String getStuId() {
        return StuId;
    }

    public void setStuId(String stuId) {
        StuId = stuId;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public int getStuAge() {
        return StuAge;
    }

    public void setStuAge(int stuAge) {
        StuAge = stuAge;
    }

    public String getStuSex() {
        return StuSex;
    }

    public void setStuSex(String stuSex) {
        StuSex = stuSex;
    }

    public TblStudent(String stuId, String stuName, int stuAge, String stuSex) {
        StuId = stuId;
        StuName = stuName;
        StuAge = stuAge;
        StuSex = stuSex;
    }

    @Override
    public String toString() {
        return "TblStudent{" +
                "StuId='" + StuId + '\'' +
                ", StuName='" + StuName + '\'' +
                ", StuAge=" + StuAge +
                ", StuSex='" + StuSex + '\'' +
                '}';
    }


    public TblStudent() {
        super();
    }
}

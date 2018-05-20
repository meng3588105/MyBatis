package com.mmm.bean;

import java.util.Set;

public class Country {

    private Integer cId;//国家编号
    private  String cName;//国家名称
        //一个国家对应N个省会
    private Set<Provincial> Provincials;


    public Country(Integer cId, String cName, Set<Provincial> provincials) {
        this.cId = cId;
        this.cName = cName;
        Provincials = provincials;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Set<Provincial> getProvincials() {
        return Provincials;
    }

    public void setProvincials(Set<Provincial> provincials) {
        Provincials = provincials;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", Provincials=" + Provincials +
                '}';
    }

    public Country() {
        super();
    }
}

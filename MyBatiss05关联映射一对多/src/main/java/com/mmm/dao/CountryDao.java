package com.mmm.dao;

import com.mmm.bean.Country;

import java.io.Serializable;

public interface CountryDao {

    /**
     * 根据国家的编号 查询出 国家对应省会的信息
     * 返回值是 Country 因为实体类中有
     *
     *  private Set<Provincial> Provincials;
     */
    Country  selectContryById(Serializable id);




}

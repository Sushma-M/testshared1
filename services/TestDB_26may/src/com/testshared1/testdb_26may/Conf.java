/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Conf generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`conf`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`name`"})})
public class Conf implements Serializable {

    private Integer idConf;
    private String name;
    private String value_;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_conf`", nullable = false, scale = 0, precision = 10)
    public Integer getIdConf() {
        return this.idConf;
    }

    public void setIdConf(Integer idConf) {
        this.idConf = idConf;
    }

    @Column(name = "`name`", nullable = false, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`value?`", nullable = false, length = 25)
    public String getValue_() {
        return this.value_;
    }

    public void setValue_(String value_) {
        this.value_ = value_;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conf)) return false;
        final Conf conf = (Conf) o;
        return Objects.equals(getIdConf(), conf.getIdConf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdConf());
    }
}

/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Country generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`country`")
public class Country implements Serializable {

    private Integer idCountry;
    private Short codIso1;
    private String codIso2;
    private String codIso3;
    private String name;
    private String nationality;
    private Integer userMode;
    private Date userFecha;
    private List<User> users = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<EmployeeGeneralDetail> employeeGeneralDetails = new ArrayList<>();
    private List<ApplicantToPosition> applicantToPositions = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_country`", nullable = false, scale = 0, precision = 10)
    public Integer getIdCountry() {
        return this.idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    @Column(name = "`cod_iso1`", nullable = false, scale = 0, precision = 5)
    public Short getCodIso1() {
        return this.codIso1;
    }

    public void setCodIso1(Short codIso1) {
        this.codIso1 = codIso1;
    }

    @Column(name = "`cod_iso2`", nullable = false, length = 2)
    public String getCodIso2() {
        return this.codIso2;
    }

    public void setCodIso2(String codIso2) {
        this.codIso2 = codIso2;
    }

    @Column(name = "`cod_iso3`", nullable = false, length = 3)
    public String getCodIso3() {
        return this.codIso3;
    }

    public void setCodIso3(String codIso3) {
        this.codIso3 = codIso3;
    }

    @Column(name = "`name`", nullable = false, length = 80)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`nationality`", nullable = false, length = 255)
    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "`user_mode`", nullable = false, scale = 0, precision = 10)
    public Integer getUserMode() {
        return this.userMode;
    }

    public void setUserMode(Integer userMode) {
        this.userMode = userMode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`user_fecha`", nullable = false)
    public Date getUserFecha() {
        return this.userFecha;
    }

    public void setUserFecha(Date userFecha) {
        this.userFecha = userFecha;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    public List<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    public List<EmployeeGeneralDetail> getEmployeeGeneralDetails() {
        return this.employeeGeneralDetails;
    }

    public void setEmployeeGeneralDetails(List<EmployeeGeneralDetail> employeeGeneralDetails) {
        this.employeeGeneralDetails = employeeGeneralDetails;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    public List<ApplicantToPosition> getApplicantToPositions() {
        return this.applicantToPositions;
    }

    public void setApplicantToPositions(List<ApplicantToPosition> applicantToPositions) {
        this.applicantToPositions = applicantToPositions;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        final Country country = (Country) o;
        return Objects.equals(getIdCountry(), country.getIdCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCountry());
    }
}


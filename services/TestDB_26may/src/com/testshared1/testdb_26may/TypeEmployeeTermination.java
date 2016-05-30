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
 * TypeEmployeeTermination generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`type_employee_termination`")
public class TypeEmployeeTermination implements Serializable {

    private Integer idEmployeeTermination;
    private String nombre;
    private String name;
    private String observation;
    private Integer userMode;
    private Date userFecha;
    private List<EmployeeTermination> employeeTerminations = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_employee_termination`", nullable = false, scale = 0, precision = 10)
    public Integer getIdEmployeeTermination() {
        return this.idEmployeeTermination;
    }

    public void setIdEmployeeTermination(Integer idEmployeeTermination) {
        this.idEmployeeTermination = idEmployeeTermination;
    }

    @Column(name = "`nombre`", nullable = false, length = 50)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "`name`", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`observation`", nullable = true, length = 255)
    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "typeEmployeeTermination")
    public List<EmployeeTermination> getEmployeeTerminations() {
        return this.employeeTerminations;
    }

    public void setEmployeeTerminations(List<EmployeeTermination> employeeTerminations) {
        this.employeeTerminations = employeeTerminations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeEmployeeTermination)) return false;
        final TypeEmployeeTermination typeEmployeeTermination = (TypeEmployeeTermination) o;
        return Objects.equals(getIdEmployeeTermination(), typeEmployeeTermination.getIdEmployeeTermination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEmployeeTermination());
    }
}


/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EmployeeTermination generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`employee_termination`")
public class EmployeeTermination implements Serializable {

    private Integer idEmployeeTermination;
    private Date terminationDate;
    private String reason;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Employee employee;
    private TypeEmployeeTermination typeEmployeeTermination;

    @Id
    @Column(name = "`id_employee_termination`", nullable = false, scale = 0, precision = 10)
    public Integer getIdEmployeeTermination() {
        return this.idEmployeeTermination;
    }

    public void setIdEmployeeTermination(Integer idEmployeeTermination) {
        this.idEmployeeTermination = idEmployeeTermination;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`termination_date`", nullable = false)
    public Date getTerminationDate() {
        return this.terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    @Column(name = "`reason`", nullable = false, length = 255)
    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "`user_location`", nullable = false, scale = 0, precision = 10)
    public Integer getUserLocation() {
        return this.userLocation;
    }

    public void setUserLocation(Integer userLocation) {
        this.userLocation = userLocation;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_employee`", referencedColumnName = "`id_employee`", insertable = true, updatable = true)
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_type_employee_termination`", referencedColumnName = "`id_employee_termination`", insertable = true, updatable = true)
    public TypeEmployeeTermination getTypeEmployeeTermination() {
        return this.typeEmployeeTermination;
    }

    public void setTypeEmployeeTermination(TypeEmployeeTermination typeEmployeeTermination) {
        this.typeEmployeeTermination = typeEmployeeTermination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeTermination)) return false;
        final EmployeeTermination employeeTermination = (EmployeeTermination) o;
        return Objects.equals(getIdEmployeeTermination(), employeeTermination.getIdEmployeeTermination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEmployeeTermination());
    }
}


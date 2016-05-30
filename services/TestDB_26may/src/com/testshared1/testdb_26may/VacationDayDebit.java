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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VacationDayDebit generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`vacation_day_debit`")
public class VacationDayDebit implements Serializable {

    private Integer idVacationDayDebit;
    private Date startPeriodDate;
    private Date endPeriodDate;
    private Integer generatedDay;
    private String observation;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_vacation_day_debit`", nullable = false, scale = 0, precision = 10)
    public Integer getIdVacationDayDebit() {
        return this.idVacationDayDebit;
    }

    public void setIdVacationDayDebit(Integer idVacationDayDebit) {
        this.idVacationDayDebit = idVacationDayDebit;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`start_period_date`", nullable = false)
    public Date getStartPeriodDate() {
        return this.startPeriodDate;
    }

    public void setStartPeriodDate(Date startPeriodDate) {
        this.startPeriodDate = startPeriodDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`end_period_date`", nullable = false)
    public Date getEndPeriodDate() {
        return this.endPeriodDate;
    }

    public void setEndPeriodDate(Date endPeriodDate) {
        this.endPeriodDate = endPeriodDate;
    }

    @Column(name = "`generated_day`", nullable = false, scale = 0, precision = 10)
    public Integer getGeneratedDay() {
        return this.generatedDay;
    }

    public void setGeneratedDay(Integer generatedDay) {
        this.generatedDay = generatedDay;
    }

    @Column(name = "`observation`", nullable = true, length = 255)
    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Column(name = "`user_location`", nullable = true, scale = 0, precision = 10)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacationDayDebit)) return false;
        final VacationDayDebit vacationDayDebit = (VacationDayDebit) o;
        return Objects.equals(getIdVacationDayDebit(), vacationDayDebit.getIdVacationDayDebit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdVacationDayDebit());
    }
}


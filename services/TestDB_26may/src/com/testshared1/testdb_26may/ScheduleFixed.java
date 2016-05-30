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
 * ScheduleFixed generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`schedule_fixed`")
public class ScheduleFixed implements Serializable {

    private Integer idScheduleFixed;
    private String name;
    private Double totalWorkedWeekHours;
    private Double lunchTotalTime;
    private Integer userMode;
    private Date userFecha;
    private List<EmployeeSalary> employeeSalaries = new ArrayList<>();
    private List<ScheduleFixedDay> scheduleFixedDays = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_schedule_fixed`", nullable = false, scale = 0, precision = 10)
    public Integer getIdScheduleFixed() {
        return this.idScheduleFixed;
    }

    public void setIdScheduleFixed(Integer idScheduleFixed) {
        this.idScheduleFixed = idScheduleFixed;
    }

    @Column(name = "`name`", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`total_worked_week_hours`", nullable = false, scale = 4, precision = 19)
    public Double getTotalWorkedWeekHours() {
        return this.totalWorkedWeekHours;
    }

    public void setTotalWorkedWeekHours(Double totalWorkedWeekHours) {
        this.totalWorkedWeekHours = totalWorkedWeekHours;
    }

    @Column(name = "`lunch_total_time`", nullable = false, scale = 4, precision = 19)
    public Double getLunchTotalTime() {
        return this.lunchTotalTime;
    }

    public void setLunchTotalTime(Double lunchTotalTime) {
        this.lunchTotalTime = lunchTotalTime;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "scheduleFixed")
    public List<EmployeeSalary> getEmployeeSalaries() {
        return this.employeeSalaries;
    }

    public void setEmployeeSalaries(List<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "scheduleFixed")
    public List<ScheduleFixedDay> getScheduleFixedDays() {
        return this.scheduleFixedDays;
    }

    public void setScheduleFixedDays(List<ScheduleFixedDay> scheduleFixedDays) {
        this.scheduleFixedDays = scheduleFixedDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduleFixed)) return false;
        final ScheduleFixed scheduleFixed = (ScheduleFixed) o;
        return Objects.equals(getIdScheduleFixed(), scheduleFixed.getIdScheduleFixed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdScheduleFixed());
    }
}

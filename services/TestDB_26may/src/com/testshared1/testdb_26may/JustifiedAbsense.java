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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JustifiedAbsense generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`justified_absense`")
public class JustifiedAbsense implements Serializable {

    private Integer idJustifiedAbsense;
    private Date absenceDateStart;
    private Date absenceDateFinal;
    private Integer totalJustifiedDays;
    private String observation;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private List<JustifiedLeaveFile> justifiedLeaveFiles = new ArrayList<>();
    private Employee employee;
    private TypeAbsenceJustification typeAbsenceJustification;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_justified_absense`", nullable = false, scale = 0, precision = 10)
    public Integer getIdJustifiedAbsense() {
        return this.idJustifiedAbsense;
    }

    public void setIdJustifiedAbsense(Integer idJustifiedAbsense) {
        this.idJustifiedAbsense = idJustifiedAbsense;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`absence_date_start`", nullable = false)
    public Date getAbsenceDateStart() {
        return this.absenceDateStart;
    }

    public void setAbsenceDateStart(Date absenceDateStart) {
        this.absenceDateStart = absenceDateStart;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`absence_date_final`", nullable = false)
    public Date getAbsenceDateFinal() {
        return this.absenceDateFinal;
    }

    public void setAbsenceDateFinal(Date absenceDateFinal) {
        this.absenceDateFinal = absenceDateFinal;
    }

    @Column(name = "`total_justified_days`", nullable = false, scale = 0, precision = 10)
    public Integer getTotalJustifiedDays() {
        return this.totalJustifiedDays;
    }

    public void setTotalJustifiedDays(Integer totalJustifiedDays) {
        this.totalJustifiedDays = totalJustifiedDays;
    }

    @Column(name = "`observation`", nullable = true, length = 255)
    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "justifiedAbsense")
    public List<JustifiedLeaveFile> getJustifiedLeaveFiles() {
        return this.justifiedLeaveFiles;
    }

    public void setJustifiedLeaveFiles(List<JustifiedLeaveFile> justifiedLeaveFiles) {
        this.justifiedLeaveFiles = justifiedLeaveFiles;
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
    @JoinColumn(name = "`fk_type_absence_justification`", referencedColumnName = "`id_type_absence_justification`", insertable = true, updatable = true)
    public TypeAbsenceJustification getTypeAbsenceJustification() {
        return this.typeAbsenceJustification;
    }

    public void setTypeAbsenceJustification(TypeAbsenceJustification typeAbsenceJustification) {
        this.typeAbsenceJustification = typeAbsenceJustification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JustifiedAbsense)) return false;
        final JustifiedAbsense justifiedAbsense = (JustifiedAbsense) o;
        return Objects.equals(getIdJustifiedAbsense(), justifiedAbsense.getIdJustifiedAbsense());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdJustifiedAbsense());
    }
}

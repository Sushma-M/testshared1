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
 * DeductionPeriodic generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`deduction_periodic`")
public class DeductionPeriodic implements Serializable {

    private Integer idDeductionPeriodic;
    private String nombre;
    private String name;
    private Boolean calculations;
    private Double suggestedValue;
    private String observation;
    private Integer userMode;
    private Date userFecha;
    private Currency currency;
    private List<ListPeriodicDeductionPayroll> listPeriodicDeductionPayrolls = new ArrayList<>();
    private List<ListPeriodicDeductionEmployee> listPeriodicDeductionEmployees = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_deduction_periodic`", nullable = false, scale = 0, precision = 10)
    public Integer getIdDeductionPeriodic() {
        return this.idDeductionPeriodic;
    }

    public void setIdDeductionPeriodic(Integer idDeductionPeriodic) {
        this.idDeductionPeriodic = idDeductionPeriodic;
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

    @Column(name = "`calculations`", nullable = false)
    public Boolean isCalculations() {
        return this.calculations;
    }

    public void setCalculations(Boolean calculations) {
        this.calculations = calculations;
    }

    @Column(name = "`suggested_value`", nullable = false, scale = 4, precision = 19)
    public Double getSuggestedValue() {
        return this.suggestedValue;
    }

    public void setSuggestedValue(Double suggestedValue) {
        this.suggestedValue = suggestedValue;
    }

    @Column(name = "`observation`", nullable = true, length = 150)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_currency`", referencedColumnName = "`id_currency`", insertable = true, updatable = true)
    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deductionPeriodic")
    public List<ListPeriodicDeductionPayroll> getListPeriodicDeductionPayrolls() {
        return this.listPeriodicDeductionPayrolls;
    }

    public void setListPeriodicDeductionPayrolls(List<ListPeriodicDeductionPayroll> listPeriodicDeductionPayrolls) {
        this.listPeriodicDeductionPayrolls = listPeriodicDeductionPayrolls;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deductionPeriodic")
    public List<ListPeriodicDeductionEmployee> getListPeriodicDeductionEmployees() {
        return this.listPeriodicDeductionEmployees;
    }

    public void setListPeriodicDeductionEmployees(List<ListPeriodicDeductionEmployee> listPeriodicDeductionEmployees) {
        this.listPeriodicDeductionEmployees = listPeriodicDeductionEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeductionPeriodic)) return false;
        final DeductionPeriodic deductionPeriodic = (DeductionPeriodic) o;
        return Objects.equals(getIdDeductionPeriodic(), deductionPeriodic.getIdDeductionPeriodic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDeductionPeriodic());
    }
}


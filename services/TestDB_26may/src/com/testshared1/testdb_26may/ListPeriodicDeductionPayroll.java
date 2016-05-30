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
 * ListPeriodicDeductionPayroll generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`list_periodic_deduction_payroll`")
public class ListPeriodicDeductionPayroll implements Serializable {

    private Integer idListPeriodicDeductionPayroll;
    private Double value_;
    private String observation;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Currency currency;
    private DeductionPeriodic deductionPeriodic;
    private PayrollDetail payrollDetail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_list_periodic_deduction_payroll`", nullable = false, scale = 0, precision = 10)
    public Integer getIdListPeriodicDeductionPayroll() {
        return this.idListPeriodicDeductionPayroll;
    }

    public void setIdListPeriodicDeductionPayroll(Integer idListPeriodicDeductionPayroll) {
        this.idListPeriodicDeductionPayroll = idListPeriodicDeductionPayroll;
    }

    @Column(name = "`value?`", nullable = false, scale = 4, precision = 19)
    public Double getValue_() {
        return this.value_;
    }

    public void setValue_(Double value_) {
        this.value_ = value_;
    }

    @Column(name = "`observation`", nullable = true, length = 100)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_currency`", referencedColumnName = "`id_currency`", insertable = true, updatable = true)
    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_deduction_periodic`", referencedColumnName = "`id_deduction_periodic`", insertable = true, updatable = true)
    public DeductionPeriodic getDeductionPeriodic() {
        return this.deductionPeriodic;
    }

    public void setDeductionPeriodic(DeductionPeriodic deductionPeriodic) {
        this.deductionPeriodic = deductionPeriodic;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_payroll_detail`", referencedColumnName = "`id_payroll_detail`", insertable = true, updatable = true)
    public PayrollDetail getPayrollDetail() {
        return this.payrollDetail;
    }

    public void setPayrollDetail(PayrollDetail payrollDetail) {
        this.payrollDetail = payrollDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListPeriodicDeductionPayroll)) return false;
        final ListPeriodicDeductionPayroll listPeriodicDeductionPayroll = (ListPeriodicDeductionPayroll) o;
        return Objects.equals(getIdListPeriodicDeductionPayroll(), listPeriodicDeductionPayroll.getIdListPeriodicDeductionPayroll());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdListPeriodicDeductionPayroll());
    }
}

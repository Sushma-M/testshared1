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
 * ListCelphoneDetailPayroll generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`list_celphone_detail_payroll`")
public class ListCelphoneDetailPayroll implements Serializable {

    private Integer idListCelphoneDetailPayroll;
    private String employeeResponsibilities;
    private Double invoiceValue;
    private Float monthlyExpenses;
    private Double impuesto;
    private Double companyBonus;
    private Double employeeCharge;
    private Double totalValue;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Currency currency;
    private MobileNumber mobileNumber;
    private Payroll payroll;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_list_celphone_detail_payroll`", nullable = false, scale = 0, precision = 10)
    public Integer getIdListCelphoneDetailPayroll() {
        return this.idListCelphoneDetailPayroll;
    }

    public void setIdListCelphoneDetailPayroll(Integer idListCelphoneDetailPayroll) {
        this.idListCelphoneDetailPayroll = idListCelphoneDetailPayroll;
    }

    @Column(name = "`employee_responsibilities`", nullable = false, length = 150)
    public String getEmployeeResponsibilities() {
        return this.employeeResponsibilities;
    }

    public void setEmployeeResponsibilities(String employeeResponsibilities) {
        this.employeeResponsibilities = employeeResponsibilities;
    }

    @Column(name = "`invoice_value`", nullable = false, scale = 4, precision = 19)
    public Double getInvoiceValue() {
        return this.invoiceValue;
    }

    public void setInvoiceValue(Double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    @Column(name = "`monthly_expenses`", nullable = false, scale = 4, precision = 4)
    public Float getMonthlyExpenses() {
        return this.monthlyExpenses;
    }

    public void setMonthlyExpenses(Float monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    @Column(name = "`impuesto`", nullable = false, scale = 4, precision = 19)
    public Double getImpuesto() {
        return this.impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    @Column(name = "`company_bonus`", nullable = false, scale = 4, precision = 19)
    public Double getCompanyBonus() {
        return this.companyBonus;
    }

    public void setCompanyBonus(Double companyBonus) {
        this.companyBonus = companyBonus;
    }

    @Column(name = "`employee_charge`", nullable = false, scale = 4, precision = 19)
    public Double getEmployeeCharge() {
        return this.employeeCharge;
    }

    public void setEmployeeCharge(Double employeeCharge) {
        this.employeeCharge = employeeCharge;
    }

    @Column(name = "`total_value`", nullable = false, scale = 4, precision = 19)
    public Double getTotalValue() {
        return this.totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
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
    @JoinColumn(name = "`fk_cellphone`", referencedColumnName = "`id_cellphone`", insertable = true, updatable = true)
    public MobileNumber getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_payroll_detail`", referencedColumnName = "`id_payroll`", insertable = true, updatable = true)
    public Payroll getPayroll() {
        return this.payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListCelphoneDetailPayroll)) return false;
        final ListCelphoneDetailPayroll listCelphoneDetailPayroll = (ListCelphoneDetailPayroll) o;
        return Objects.equals(getIdListCelphoneDetailPayroll(), listCelphoneDetailPayroll.getIdListCelphoneDetailPayroll());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdListCelphoneDetailPayroll());
    }
}


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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * RateCurrency generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`rate_currency`", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"`rate_date`", "`currency`"})})
public class RateCurrency implements Serializable {

    private Integer idRateCurrency;
    private Date rateDate;
    private String currency;
    private Double value_;
    private Integer userMode;
    private Date userFecha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_rate_currency`", nullable = false, scale = 0, precision = 10)
    public Integer getIdRateCurrency() {
        return this.idRateCurrency;
    }

    public void setIdRateCurrency(Integer idRateCurrency) {
        this.idRateCurrency = idRateCurrency;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`rate_date`", nullable = false)
    public Date getRateDate() {
        return this.rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    @Column(name = "`currency`", nullable = false, length = 6)
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "`value?`", nullable = false, scale = 4, precision = 19)
    public Double getValue_() {
        return this.value_;
    }

    public void setValue_(Double value_) {
        this.value_ = value_;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateCurrency)) return false;
        final RateCurrency rateCurrency = (RateCurrency) o;
        return Objects.equals(getIdRateCurrency(), rateCurrency.getIdRateCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRateCurrency());
    }
}

/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigInteger;
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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * OverTimeSegmentPayroll generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`over_time_segment_payroll`")
public class OverTimeSegmentPayroll implements Serializable {

    private Integer idOverTimeSegmentPayroll;
    @Type(type = "DateTime")
    private LocalDateTime startTime;
    @Type(type = "DateTime")
    private LocalDateTime endTime;
    private Double hourDifference;
    private Double rate;
    private Double hoursByRate;
    private BigInteger value_;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Currency currency;
    private ListOvertimePayroll listOvertimePayroll;
    private TypeExtraHourSegment typeExtraHourSegment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_over_time_segment_payroll`", nullable = false, scale = 0, precision = 10)
    public Integer getIdOverTimeSegmentPayroll() {
        return this.idOverTimeSegmentPayroll;
    }

    public void setIdOverTimeSegmentPayroll(Integer idOverTimeSegmentPayroll) {
        this.idOverTimeSegmentPayroll = idOverTimeSegmentPayroll;
    }

    @Column(name = "`start_time`", nullable = false)
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Column(name = "`end_time`", nullable = false)
    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Column(name = "`hour_difference`", nullable = false, scale = 4, precision = 19)
    public Double getHourDifference() {
        return this.hourDifference;
    }

    public void setHourDifference(Double hourDifference) {
        this.hourDifference = hourDifference;
    }

    @Column(name = "`rate`", nullable = false, scale = 4, precision = 19)
    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Column(name = "`hours_by_rate`", nullable = false, scale = 4, precision = 19)
    public Double getHoursByRate() {
        return this.hoursByRate;
    }

    public void setHoursByRate(Double hoursByRate) {
        this.hoursByRate = hoursByRate;
    }

    @Column(name = "`value?`", nullable = false, scale = 0, precision = 19)
    public BigInteger getValue_() {
        return this.value_;
    }

    public void setValue_(BigInteger value_) {
        this.value_ = value_;
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
    @JoinColumn(name = "`fk_list_overtime_payroll`", referencedColumnName = "`id_list_overtime_payroll`", insertable = true, updatable = true)
    public ListOvertimePayroll getListOvertimePayroll() {
        return this.listOvertimePayroll;
    }

    public void setListOvertimePayroll(ListOvertimePayroll listOvertimePayroll) {
        this.listOvertimePayroll = listOvertimePayroll;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_type_extra_hour_segment`", referencedColumnName = "`id_type_extra_hour_segment`", insertable = true, updatable = true)
    public TypeExtraHourSegment getTypeExtraHourSegment() {
        return this.typeExtraHourSegment;
    }

    public void setTypeExtraHourSegment(TypeExtraHourSegment typeExtraHourSegment) {
        this.typeExtraHourSegment = typeExtraHourSegment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OverTimeSegmentPayroll)) return false;
        final OverTimeSegmentPayroll overTimeSegmentPayroll = (OverTimeSegmentPayroll) o;
        return Objects.equals(getIdOverTimeSegmentPayroll(), overTimeSegmentPayroll.getIdOverTimeSegmentPayroll());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdOverTimeSegmentPayroll());
    }
}


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
 * WorkPositionRequiement generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`work_position_requiement`")
public class WorkPositionRequiement implements Serializable {

    private Integer idWorkPositionRequiement;
    private String name;
    private String observation;
    private Integer userMode;
    private Date userFecha;
    private WorkPosition workPosition;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_work_position_requiement`", nullable = false, scale = 0, precision = 10)
    public Integer getIdWorkPositionRequiement() {
        return this.idWorkPositionRequiement;
    }

    public void setIdWorkPositionRequiement(Integer idWorkPositionRequiement) {
        this.idWorkPositionRequiement = idWorkPositionRequiement;
    }

    @Column(name = "`name`", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
    @JoinColumn(name = "`fk_work_position`", referencedColumnName = "`id_work_position`", insertable = true, updatable = true)
    public WorkPosition getWorkPosition() {
        return this.workPosition;
    }

    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkPositionRequiement)) return false;
        final WorkPositionRequiement workPositionRequiement = (WorkPositionRequiement) o;
        return Objects.equals(getIdWorkPositionRequiement(), workPositionRequiement.getIdWorkPositionRequiement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdWorkPositionRequiement());
    }
}

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
 * Announcement generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`announcement`")
public class Announcement implements Serializable {

    private Integer idAnnouncement;
    private String issue;
    private String details;
    private Boolean highPriority;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private TypeAnnouncement typeAnnouncement;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_announcement`", nullable = false, scale = 0, precision = 10)
    public Integer getIdAnnouncement() {
        return this.idAnnouncement;
    }

    public void setIdAnnouncement(Integer idAnnouncement) {
        this.idAnnouncement = idAnnouncement;
    }

    @Column(name = "`issue`", nullable = false, length = 25)
    public String getIssue() {
        return this.issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Column(name = "`details`", nullable = false, length = 150)
    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Column(name = "`high_priority`", nullable = false)
    public Boolean isHighPriority() {
        return this.highPriority;
    }

    public void setHighPriority(Boolean highPriority) {
        this.highPriority = highPriority;
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
    @JoinColumn(name = "`fk_type_announcement`", referencedColumnName = "`id_type_announcement`", insertable = true, updatable = true)
    public TypeAnnouncement getTypeAnnouncement() {
        return this.typeAnnouncement;
    }

    public void setTypeAnnouncement(TypeAnnouncement typeAnnouncement) {
        this.typeAnnouncement = typeAnnouncement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Announcement)) return false;
        final Announcement announcement = (Announcement) o;
        return Objects.equals(getIdAnnouncement(), announcement.getIdAnnouncement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAnnouncement());
    }
}


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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * AssetAssignDocument generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`asset_assign_document`")
public class AssetAssignDocument implements Serializable {

    private Integer idAssetAssignDocument;
    @Type(type = "DateTime")
    private LocalDateTime noteOfficeDate;
    private Boolean printedNote;
    private Integer userDevelops;
    private String observation;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Employee employee;
    private List<ListAssetLoaded> listAssetLoadeds = new ArrayList<>();

    @Id
    @Column(name = "`id_asset_assign_document`", nullable = false, scale = 0, precision = 10)
    public Integer getIdAssetAssignDocument() {
        return this.idAssetAssignDocument;
    }

    public void setIdAssetAssignDocument(Integer idAssetAssignDocument) {
        this.idAssetAssignDocument = idAssetAssignDocument;
    }

    @Column(name = "`note_office_date`", nullable = false)
    public LocalDateTime getNoteOfficeDate() {
        return this.noteOfficeDate;
    }

    public void setNoteOfficeDate(LocalDateTime noteOfficeDate) {
        this.noteOfficeDate = noteOfficeDate;
    }

    @Column(name = "`printed_note`", nullable = false)
    public Boolean isPrintedNote() {
        return this.printedNote;
    }

    public void setPrintedNote(Boolean printedNote) {
        this.printedNote = printedNote;
    }

    @Column(name = "`user_develops`", nullable = false, scale = 0, precision = 10)
    public Integer getUserDevelops() {
        return this.userDevelops;
    }

    public void setUserDevelops(Integer userDevelops) {
        this.userDevelops = userDevelops;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_employee`", referencedColumnName = "`id_employee`", insertable = true, updatable = true)
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "assetAssignDocument")
    public List<ListAssetLoaded> getListAssetLoadeds() {
        return this.listAssetLoadeds;
    }

    public void setListAssetLoadeds(List<ListAssetLoaded> listAssetLoadeds) {
        this.listAssetLoadeds = listAssetLoadeds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetAssignDocument)) return false;
        final AssetAssignDocument assetAssignDocument = (AssetAssignDocument) o;
        return Objects.equals(getIdAssetAssignDocument(), assetAssignDocument.getIdAssetAssignDocument());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAssetAssignDocument());
    }
}


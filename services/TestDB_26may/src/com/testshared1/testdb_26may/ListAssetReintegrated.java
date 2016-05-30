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
 * ListAssetReintegrated generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`list_asset_reintegrated`")
public class ListAssetReintegrated implements Serializable {

    private Integer idListAssetReintegrated;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private Asset asset;
    private AssetReintegrationDocument assetReintegrationDocument;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_list_asset_reintegrated`", nullable = false, scale = 0, precision = 10)
    public Integer getIdListAssetReintegrated() {
        return this.idListAssetReintegrated;
    }

    public void setIdListAssetReintegrated(Integer idListAssetReintegrated) {
        this.idListAssetReintegrated = idListAssetReintegrated;
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
    @JoinColumn(name = "`fk_asset`", referencedColumnName = "`id_asset`", insertable = true, updatable = true)
    public Asset getAsset() {
        return this.asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_asset_reintegration_document`", referencedColumnName = "`id_asset_reintegration_document`", insertable = true, updatable = true)
    public AssetReintegrationDocument getAssetReintegrationDocument() {
        return this.assetReintegrationDocument;
    }

    public void setAssetReintegrationDocument(AssetReintegrationDocument assetReintegrationDocument) {
        this.assetReintegrationDocument = assetReintegrationDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListAssetReintegrated)) return false;
        final ListAssetReintegrated listAssetReintegrated = (ListAssetReintegrated) o;
        return Objects.equals(getIdListAssetReintegrated(), listAssetReintegrated.getIdListAssetReintegrated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdListAssetReintegrated());
    }
}

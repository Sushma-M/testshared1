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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RolePermission generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`role_permission`")
public class RolePermission implements Serializable {

    private Integer idRolePermission;
    private String rolePermissionName;
    private String spanishLabel;
    private String englishLabel;
    private String category;
    private Integer userMode;
    private Date userFecha;
    private List<ListRolePermission> listRolePermissions = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_role_permission`", nullable = false, scale = 0, precision = 10)
    public Integer getIdRolePermission() {
        return this.idRolePermission;
    }

    public void setIdRolePermission(Integer idRolePermission) {
        this.idRolePermission = idRolePermission;
    }

    @Column(name = "`role_permission_name`", nullable = false, length = 32)
    public String getRolePermissionName() {
        return this.rolePermissionName;
    }

    public void setRolePermissionName(String rolePermissionName) {
        this.rolePermissionName = rolePermissionName;
    }

    @Column(name = "`spanish_label`", nullable = false, length = 32)
    public String getSpanishLabel() {
        return this.spanishLabel;
    }

    public void setSpanishLabel(String spanishLabel) {
        this.spanishLabel = spanishLabel;
    }

    @Column(name = "`english_label`", nullable = false, length = 32)
    public String getEnglishLabel() {
        return this.englishLabel;
    }

    public void setEnglishLabel(String englishLabel) {
        this.englishLabel = englishLabel;
    }

    @Column(name = "`category`", nullable = false, length = 32)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rolePermission")
    public List<ListRolePermission> getListRolePermissions() {
        return this.listRolePermissions;
    }

    public void setListRolePermissions(List<ListRolePermission> listRolePermissions) {
        this.listRolePermissions = listRolePermissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePermission)) return false;
        final RolePermission rolePermission = (RolePermission) o;
        return Objects.equals(getIdRolePermission(), rolePermission.getIdRolePermission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRolePermission());
    }
}


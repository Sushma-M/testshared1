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
 * ListRolePermission generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`list_role_permission`")
public class ListRolePermission implements Serializable {

    private Integer idListRolePermission;
    private Integer userMode;
    private Date userFecha;
    private Role role;
    private RolePermission rolePermission;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_list_role_permission`", nullable = false, scale = 0, precision = 10)
    public Integer getIdListRolePermission() {
        return this.idListRolePermission;
    }

    public void setIdListRolePermission(Integer idListRolePermission) {
        this.idListRolePermission = idListRolePermission;
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
    @JoinColumn(name = "`fk_role`", referencedColumnName = "`id_role`", insertable = true, updatable = true)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_role_permission`", referencedColumnName = "`id_role_permission`", insertable = true, updatable = true)
    public RolePermission getRolePermission() {
        return this.rolePermission;
    }

    public void setRolePermission(RolePermission rolePermission) {
        this.rolePermission = rolePermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListRolePermission)) return false;
        final ListRolePermission listRolePermission = (ListRolePermission) o;
        return Objects.equals(getIdListRolePermission(), listRolePermission.getIdListRolePermission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdListRolePermission());
    }
}


/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

public class DetallePlanillaIngresosId implements Serializable {

    private Integer idPayrollDetail;
    private String type_;
    private String code;
    private String description_;
    private String currency;
    private Double value_;

    public Integer getIdPayrollDetail() {
        return this.idPayrollDetail;
    }

    public void setIdPayrollDetail(Integer idPayrollDetail) {
        this.idPayrollDetail = idPayrollDetail;
    }

    public String getType_() {
        return this.type_;
    }

    public void setType_(String type_) {
        this.type_ = type_;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription_() {
        return this.description_;
    }

    public void setDescription_(String description_) {
        this.description_ = description_;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getValue_() {
        return this.value_;
    }

    public void setValue_(Double value_) {
        this.value_ = value_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallePlanillaIngresos)) return false;
        final DetallePlanillaIngresos detallePlanillaIngresos = (DetallePlanillaIngresos) o;
        return Objects.equals(getIdPayrollDetail(), detallePlanillaIngresos.getIdPayrollDetail()) &&
                Objects.equals(getType_(), detallePlanillaIngresos.getType_()) &&
                Objects.equals(getCode(), detallePlanillaIngresos.getCode()) &&
                Objects.equals(getDescription_(), detallePlanillaIngresos.getDescription_()) &&
                Objects.equals(getCurrency(), detallePlanillaIngresos.getCurrency()) &&
                Objects.equals(getValue_(), detallePlanillaIngresos.getValue_());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPayrollDetail(),
                getType_(),
                getCode(),
                getDescription_(),
                getCurrency(),
                getValue_());
    }
}

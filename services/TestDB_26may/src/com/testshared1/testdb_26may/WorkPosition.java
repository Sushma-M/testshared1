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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * WorkPosition generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`work_position`")
public class WorkPosition implements Serializable {

    private Integer idWorkPosition;
    private String postName;
    private String jobDescription;
    private String descripcionFuncionesContrato;
    private String terminosContrato;
    private Double rangoPagoMin;
    private Double rangoPagoMax;
    private String observation;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private List<WorkPositionRequiement> workPositionRequiements = new ArrayList<>();
    private List<WorkPositionVacant> workPositionVacants = new ArrayList<>();
    private List<WorkPositionResponsibility> workPositionResponsibilities = new ArrayList<>();
    private CompanyDepartment companyDepartment;
    private WorkPosition workPositionByFkSuperiorPosition;
    private List<WorkPosition> workPositionsForFkSuperiorPosition = new ArrayList<>();
    private List<WorkPositionScope> workPositionScopes = new ArrayList<>();
    private List<ListEmployeePosition> listEmployeePositions = new ArrayList<>();
    private List<EmployeeAssessment> employeeAssessments = new ArrayList<>();
    private List<WorkPositionPerformanceIndicator> workPositionPerformanceIndicators = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`id_work_position`", nullable = false, scale = 0, precision = 10)
    public Integer getIdWorkPosition() {
        return this.idWorkPosition;
    }

    public void setIdWorkPosition(Integer idWorkPosition) {
        this.idWorkPosition = idWorkPosition;
    }

    @Column(name = "`post_name`", nullable = false, length = 100)
    public String getPostName() {
        return this.postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Column(name = "`job_description`", nullable = false, length = 1024)
    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Column(name = "`descripcion_funciones_contrato`", nullable = false, length = 4096)
    public String getDescripcionFuncionesContrato() {
        return this.descripcionFuncionesContrato;
    }

    public void setDescripcionFuncionesContrato(String descripcionFuncionesContrato) {
        this.descripcionFuncionesContrato = descripcionFuncionesContrato;
    }

    @Column(name = "`terminos_contrato`", nullable = false, length = 4096)
    public String getTerminosContrato() {
        return this.terminosContrato;
    }

    public void setTerminosContrato(String terminosContrato) {
        this.terminosContrato = terminosContrato;
    }

    @Column(name = "`rango_pago_min`", nullable = false, scale = 2, precision = 11)
    public Double getRangoPagoMin() {
        return this.rangoPagoMin;
    }

    public void setRangoPagoMin(Double rangoPagoMin) {
        this.rangoPagoMin = rangoPagoMin;
    }

    @Column(name = "`rango_pago_max`", nullable = false, scale = 2, precision = 11)
    public Double getRangoPagoMax() {
        return this.rangoPagoMax;
    }

    public void setRangoPagoMax(Double rangoPagoMax) {
        this.rangoPagoMax = rangoPagoMax;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<WorkPositionRequiement> getWorkPositionRequiements() {
        return this.workPositionRequiements;
    }

    public void setWorkPositionRequiements(List<WorkPositionRequiement> workPositionRequiements) {
        this.workPositionRequiements = workPositionRequiements;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<WorkPositionVacant> getWorkPositionVacants() {
        return this.workPositionVacants;
    }

    public void setWorkPositionVacants(List<WorkPositionVacant> workPositionVacants) {
        this.workPositionVacants = workPositionVacants;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<WorkPositionResponsibility> getWorkPositionResponsibilities() {
        return this.workPositionResponsibilities;
    }

    public void setWorkPositionResponsibilities(List<WorkPositionResponsibility> workPositionResponsibilities) {
        this.workPositionResponsibilities = workPositionResponsibilities;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_company_department`", referencedColumnName = "`id_company_department`", insertable = true, updatable = true)
    public CompanyDepartment getCompanyDepartment() {
        return this.companyDepartment;
    }

    public void setCompanyDepartment(CompanyDepartment companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"workPositionByFkSuperiorPosition", "workPositionsForFkSuperiorPosition"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_superior_position`", referencedColumnName = "`id_work_position`", insertable = true, updatable = true)
    public WorkPosition getWorkPositionByFkSuperiorPosition() {
        return this.workPositionByFkSuperiorPosition;
    }

    public void setWorkPositionByFkSuperiorPosition(WorkPosition workPositionByFkSuperiorPosition) {
        this.workPositionByFkSuperiorPosition = workPositionByFkSuperiorPosition;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"workPositionByFkSuperiorPosition", "workPositionsForFkSuperiorPosition"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPositionByFkSuperiorPosition")
    public List<WorkPosition> getWorkPositionsForFkSuperiorPosition() {
        return this.workPositionsForFkSuperiorPosition;
    }

    public void setWorkPositionsForFkSuperiorPosition(List<WorkPosition> workPositionsForFkSuperiorPosition) {
        this.workPositionsForFkSuperiorPosition = workPositionsForFkSuperiorPosition;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<WorkPositionScope> getWorkPositionScopes() {
        return this.workPositionScopes;
    }

    public void setWorkPositionScopes(List<WorkPositionScope> workPositionScopes) {
        this.workPositionScopes = workPositionScopes;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<ListEmployeePosition> getListEmployeePositions() {
        return this.listEmployeePositions;
    }

    public void setListEmployeePositions(List<ListEmployeePosition> listEmployeePositions) {
        this.listEmployeePositions = listEmployeePositions;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<EmployeeAssessment> getEmployeeAssessments() {
        return this.employeeAssessments;
    }

    public void setEmployeeAssessments(List<EmployeeAssessment> employeeAssessments) {
        this.employeeAssessments = employeeAssessments;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "workPosition")
    public List<WorkPositionPerformanceIndicator> getWorkPositionPerformanceIndicators() {
        return this.workPositionPerformanceIndicators;
    }

    public void setWorkPositionPerformanceIndicators(List<WorkPositionPerformanceIndicator> workPositionPerformanceIndicators) {
        this.workPositionPerformanceIndicators = workPositionPerformanceIndicators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkPosition)) return false;
        final WorkPosition workPosition = (WorkPosition) o;
        return Objects.equals(getIdWorkPosition(), workPosition.getIdWorkPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdWorkPosition());
    }
}


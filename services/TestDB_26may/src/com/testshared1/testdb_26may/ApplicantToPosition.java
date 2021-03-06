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

/**
 * ApplicantToPosition generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`applicant_to_position`")
public class ApplicantToPosition implements Serializable {

    private Integer idApplicantToPosition;
    private String firstName;
    private String secondName;
    private String surname;
    private String secondSurname;
    private String marriageName;
    private Character sex;
    private String identityNumber;
    private Date birthDate;
    private String email;
    private String observation;
    private Integer userLocation;
    private Integer userMode;
    private Date userFecha;
    private List<WorkPositionVacant> workPositionVacantsForFkAspiranteAsignado = new ArrayList<>();
    private List<ApplicantFile> applicantFiles = new ArrayList<>();
    private Country country;
    private TypeApplicantStatus typeApplicantStatus;
    private TypeMaritalStatus typeMaritalStatus;
    private WorkPositionVacant workPositionVacantByFkWorkPositionVacant;
    private List<Employee> employees = new ArrayList<>();
    private List<ApplicantNote> applicantNotes = new ArrayList<>();
    private List<ApplicantAppointment> applicantAppointments = new ArrayList<>();

    @Id
    @Column(name = "`id_applicant_to_position`", nullable = false, scale = 0, precision = 10)
    public Integer getIdApplicantToPosition() {
        return this.idApplicantToPosition;
    }

    public void setIdApplicantToPosition(Integer idApplicantToPosition) {
        this.idApplicantToPosition = idApplicantToPosition;
    }

    @Column(name = "`first_name`", nullable = false, length = 25)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "`second_name`", nullable = true, length = 25)
    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Column(name = "`surname`", nullable = false, length = 25)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "`second_surname`", nullable = true, length = 25)
    public String getSecondSurname() {
        return this.secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    @Column(name = "`marriage_name`", nullable = true, length = 25)
    public String getMarriageName() {
        return this.marriageName;
    }

    public void setMarriageName(String marriageName) {
        this.marriageName = marriageName;
    }

    @Column(name = "`sex`", nullable = false, length = 1)
    public Character getSex() {
        return this.sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Column(name = "`identity_number`", nullable = false, length = 25)
    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`birth_date`", nullable = false)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "`email`", nullable = false, length = 60)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "applicantToPositionByFkAspiranteAsignado")
    public List<WorkPositionVacant> getWorkPositionVacantsForFkAspiranteAsignado() {
        return this.workPositionVacantsForFkAspiranteAsignado;
    }

    public void setWorkPositionVacantsForFkAspiranteAsignado(List<WorkPositionVacant> workPositionVacantsForFkAspiranteAsignado) {
        this.workPositionVacantsForFkAspiranteAsignado = workPositionVacantsForFkAspiranteAsignado;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "applicantToPosition")
    public List<ApplicantFile> getApplicantFiles() {
        return this.applicantFiles;
    }

    public void setApplicantFiles(List<ApplicantFile> applicantFiles) {
        this.applicantFiles = applicantFiles;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_nationality`", referencedColumnName = "`id_country`", insertable = true, updatable = true)
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_type_applicant_status`", referencedColumnName = "`id_type_marital_status`", insertable = true, updatable = true)
    public TypeApplicantStatus getTypeApplicantStatus() {
        return this.typeApplicantStatus;
    }

    public void setTypeApplicantStatus(TypeApplicantStatus typeApplicantStatus) {
        this.typeApplicantStatus = typeApplicantStatus;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_type_marital_status`", referencedColumnName = "`id_type_employee_termination`", insertable = true, updatable = true)
    public TypeMaritalStatus getTypeMaritalStatus() {
        return this.typeMaritalStatus;
    }

    public void setTypeMaritalStatus(TypeMaritalStatus typeMaritalStatus) {
        this.typeMaritalStatus = typeMaritalStatus;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`fk_work_position_vacant`", referencedColumnName = "`id_work_position_vacant`", insertable = true, updatable = true)
    public WorkPositionVacant getWorkPositionVacantByFkWorkPositionVacant() {
        return this.workPositionVacantByFkWorkPositionVacant;
    }

    public void setWorkPositionVacantByFkWorkPositionVacant(WorkPositionVacant workPositionVacantByFkWorkPositionVacant) {
        this.workPositionVacantByFkWorkPositionVacant = workPositionVacantByFkWorkPositionVacant;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "applicantToPosition")
    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "applicantToPosition")
    public List<ApplicantNote> getApplicantNotes() {
        return this.applicantNotes;
    }

    public void setApplicantNotes(List<ApplicantNote> applicantNotes) {
        this.applicantNotes = applicantNotes;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "applicantToPosition")
    public List<ApplicantAppointment> getApplicantAppointments() {
        return this.applicantAppointments;
    }

    public void setApplicantAppointments(List<ApplicantAppointment> applicantAppointments) {
        this.applicantAppointments = applicantAppointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicantToPosition)) return false;
        final ApplicantToPosition applicantToPosition = (ApplicantToPosition) o;
        return Objects.equals(getIdApplicantToPosition(), applicantToPosition.getIdApplicantToPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdApplicantToPosition());
    }
}


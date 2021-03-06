/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testshared1.testdb_26may.ApplicantAppointment;

/**
 * ServiceImpl object for domain model class ApplicantAppointment.
 *
 * @see ApplicantAppointment
 */
@Service("TestDB_26may.ApplicantAppointmentService")
public class ApplicantAppointmentServiceImpl implements ApplicantAppointmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantAppointmentServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.ApplicantAppointmentDao")
    private WMGenericDao<ApplicantAppointment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ApplicantAppointment, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public ApplicantAppointment create(ApplicantAppointment applicantappointment) {
        LOGGER.debug("Creating a new ApplicantAppointment with information: {}", applicantappointment);
        return this.wmGenericDao.create(applicantappointment);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public ApplicantAppointment getById(Integer applicantappointmentId) throws EntityNotFoundException {
        LOGGER.debug("Finding ApplicantAppointment by id: {}", applicantappointmentId);
        ApplicantAppointment applicantappointment = this.wmGenericDao.findById(applicantappointmentId);
        if (applicantappointment == null){
            LOGGER.debug("No ApplicantAppointment found with id: {}", applicantappointmentId);
            throw new EntityNotFoundException(String.valueOf(applicantappointmentId));
        }
        return applicantappointment;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public ApplicantAppointment update(ApplicantAppointment applicantappointment) throws EntityNotFoundException {
        LOGGER.debug("Updating ApplicantAppointment with information: {}", applicantappointment);
        this.wmGenericDao.update(applicantappointment);

        Integer applicantappointmentId = applicantappointment.getIdApplicantAppointment();

        return this.wmGenericDao.findById(applicantappointmentId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public ApplicantAppointment delete(Integer applicantappointmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ApplicantAppointment with id: {}", applicantappointmentId);
        ApplicantAppointment deleted = this.wmGenericDao.findById(applicantappointmentId);
        if (deleted == null) {
            LOGGER.debug("No ApplicantAppointment found with id: {}", applicantappointmentId);
            throw new EntityNotFoundException(String.valueOf(applicantappointmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<ApplicantAppointment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ApplicantAppointments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<ApplicantAppointment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ApplicantAppointments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table ApplicantAppointment to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @SuppressWarnings("unchecked")
	@Override
    public Page<ApplicantAppointment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


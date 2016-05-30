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

import com.testshared1.testdb_26may.EmployeeAssessment;

/**
 * ServiceImpl object for domain model class EmployeeAssessment.
 *
 * @see EmployeeAssessment
 */
@Service("TestDB_26may.EmployeeAssessmentService")
public class EmployeeAssessmentServiceImpl implements EmployeeAssessmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAssessmentServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeeAssessmentDao")
    private WMGenericDao<EmployeeAssessment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeAssessment, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public EmployeeAssessment create(EmployeeAssessment employeeassessment) {
        LOGGER.debug("Creating a new EmployeeAssessment with information: {}", employeeassessment);
        return this.wmGenericDao.create(employeeassessment);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeAssessment getById(Integer employeeassessmentId) throws EntityNotFoundException {
        LOGGER.debug("Finding EmployeeAssessment by id: {}", employeeassessmentId);
        EmployeeAssessment employeeassessment = this.wmGenericDao.findById(employeeassessmentId);
        if (employeeassessment == null){
            LOGGER.debug("No EmployeeAssessment found with id: {}", employeeassessmentId);
            throw new EntityNotFoundException(String.valueOf(employeeassessmentId));
        }
        return employeeassessment;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeAssessment update(EmployeeAssessment employeeassessment) throws EntityNotFoundException {
        LOGGER.debug("Updating EmployeeAssessment with information: {}", employeeassessment);
        this.wmGenericDao.update(employeeassessment);

        Integer employeeassessmentId = employeeassessment.getIdEmployeeAssessment();

        return this.wmGenericDao.findById(employeeassessmentId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeAssessment delete(Integer employeeassessmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeAssessment with id: {}", employeeassessmentId);
        EmployeeAssessment deleted = this.wmGenericDao.findById(employeeassessmentId);
        if (deleted == null) {
            LOGGER.debug("No EmployeeAssessment found with id: {}", employeeassessmentId);
            throw new EntityNotFoundException(String.valueOf(employeeassessmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<EmployeeAssessment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EmployeeAssessments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<EmployeeAssessment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EmployeeAssessments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table EmployeeAssessment to {} format", exportType);
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
    public Page<EmployeeAssessment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


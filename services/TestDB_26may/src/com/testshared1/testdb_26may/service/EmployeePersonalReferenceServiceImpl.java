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

import com.testshared1.testdb_26may.EmployeePersonalReference;

/**
 * ServiceImpl object for domain model class EmployeePersonalReference.
 *
 * @see EmployeePersonalReference
 */
@Service("TestDB_26may.EmployeePersonalReferenceService")
public class EmployeePersonalReferenceServiceImpl implements EmployeePersonalReferenceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePersonalReferenceServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeePersonalReferenceDao")
    private WMGenericDao<EmployeePersonalReference, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeePersonalReference, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public EmployeePersonalReference create(EmployeePersonalReference employeepersonalreference) {
        LOGGER.debug("Creating a new EmployeePersonalReference with information: {}", employeepersonalreference);
        return this.wmGenericDao.create(employeepersonalreference);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeePersonalReference getById(Integer employeepersonalreferenceId) throws EntityNotFoundException {
        LOGGER.debug("Finding EmployeePersonalReference by id: {}", employeepersonalreferenceId);
        EmployeePersonalReference employeepersonalreference = this.wmGenericDao.findById(employeepersonalreferenceId);
        if (employeepersonalreference == null){
            LOGGER.debug("No EmployeePersonalReference found with id: {}", employeepersonalreferenceId);
            throw new EntityNotFoundException(String.valueOf(employeepersonalreferenceId));
        }
        return employeepersonalreference;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeePersonalReference update(EmployeePersonalReference employeepersonalreference) throws EntityNotFoundException {
        LOGGER.debug("Updating EmployeePersonalReference with information: {}", employeepersonalreference);
        this.wmGenericDao.update(employeepersonalreference);

        Integer employeepersonalreferenceId = employeepersonalreference.getIdEmployeePersonalReference();

        return this.wmGenericDao.findById(employeepersonalreferenceId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeePersonalReference delete(Integer employeepersonalreferenceId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeePersonalReference with id: {}", employeepersonalreferenceId);
        EmployeePersonalReference deleted = this.wmGenericDao.findById(employeepersonalreferenceId);
        if (deleted == null) {
            LOGGER.debug("No EmployeePersonalReference found with id: {}", employeepersonalreferenceId);
            throw new EntityNotFoundException(String.valueOf(employeepersonalreferenceId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<EmployeePersonalReference> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EmployeePersonalReferences");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<EmployeePersonalReference> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EmployeePersonalReferences");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table EmployeePersonalReference to {} format", exportType);
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
    public Page<EmployeePersonalReference> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


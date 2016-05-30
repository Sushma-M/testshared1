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

import com.testshared1.testdb_26may.EmployeeFileLocation;

/**
 * ServiceImpl object for domain model class EmployeeFileLocation.
 *
 * @see EmployeeFileLocation
 */
@Service("TestDB_26may.EmployeeFileLocationService")
public class EmployeeFileLocationServiceImpl implements EmployeeFileLocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFileLocationServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeeFileLocationDao")
    private WMGenericDao<EmployeeFileLocation, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeFileLocation, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public EmployeeFileLocation create(EmployeeFileLocation employeefilelocation) {
        LOGGER.debug("Creating a new EmployeeFileLocation with information: {}", employeefilelocation);
        return this.wmGenericDao.create(employeefilelocation);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeFileLocation getById(Integer employeefilelocationId) throws EntityNotFoundException {
        LOGGER.debug("Finding EmployeeFileLocation by id: {}", employeefilelocationId);
        EmployeeFileLocation employeefilelocation = this.wmGenericDao.findById(employeefilelocationId);
        if (employeefilelocation == null){
            LOGGER.debug("No EmployeeFileLocation found with id: {}", employeefilelocationId);
            throw new EntityNotFoundException(String.valueOf(employeefilelocationId));
        }
        return employeefilelocation;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeFileLocation update(EmployeeFileLocation employeefilelocation) throws EntityNotFoundException {
        LOGGER.debug("Updating EmployeeFileLocation with information: {}", employeefilelocation);
        this.wmGenericDao.update(employeefilelocation);

        Integer employeefilelocationId = employeefilelocation.getIdEmployeeFileLocation();

        return this.wmGenericDao.findById(employeefilelocationId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeFileLocation delete(Integer employeefilelocationId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeFileLocation with id: {}", employeefilelocationId);
        EmployeeFileLocation deleted = this.wmGenericDao.findById(employeefilelocationId);
        if (deleted == null) {
            LOGGER.debug("No EmployeeFileLocation found with id: {}", employeefilelocationId);
            throw new EntityNotFoundException(String.valueOf(employeefilelocationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<EmployeeFileLocation> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EmployeeFileLocations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<EmployeeFileLocation> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EmployeeFileLocations");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table EmployeeFileLocation to {} format", exportType);
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
    public Page<EmployeeFileLocation> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

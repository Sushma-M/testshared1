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

import com.testshared1.testdb_26may.OverTimeEmployee;

/**
 * ServiceImpl object for domain model class OverTimeEmployee.
 *
 * @see OverTimeEmployee
 */
@Service("TestDB_26may.OverTimeEmployeeService")
public class OverTimeEmployeeServiceImpl implements OverTimeEmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OverTimeEmployeeServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.OverTimeEmployeeDao")
    private WMGenericDao<OverTimeEmployee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<OverTimeEmployee, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public OverTimeEmployee create(OverTimeEmployee overtimeemployee) {
        LOGGER.debug("Creating a new OverTimeEmployee with information: {}", overtimeemployee);
        return this.wmGenericDao.create(overtimeemployee);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public OverTimeEmployee getById(Integer overtimeemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Finding OverTimeEmployee by id: {}", overtimeemployeeId);
        OverTimeEmployee overtimeemployee = this.wmGenericDao.findById(overtimeemployeeId);
        if (overtimeemployee == null){
            LOGGER.debug("No OverTimeEmployee found with id: {}", overtimeemployeeId);
            throw new EntityNotFoundException(String.valueOf(overtimeemployeeId));
        }
        return overtimeemployee;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public OverTimeEmployee update(OverTimeEmployee overtimeemployee) throws EntityNotFoundException {
        LOGGER.debug("Updating OverTimeEmployee with information: {}", overtimeemployee);
        this.wmGenericDao.update(overtimeemployee);

        Integer overtimeemployeeId = overtimeemployee.getIdOverTimeEmployee();

        return this.wmGenericDao.findById(overtimeemployeeId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public OverTimeEmployee delete(Integer overtimeemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting OverTimeEmployee with id: {}", overtimeemployeeId);
        OverTimeEmployee deleted = this.wmGenericDao.findById(overtimeemployeeId);
        if (deleted == null) {
            LOGGER.debug("No OverTimeEmployee found with id: {}", overtimeemployeeId);
            throw new EntityNotFoundException(String.valueOf(overtimeemployeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<OverTimeEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all OverTimeEmployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<OverTimeEmployee> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all OverTimeEmployees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table OverTimeEmployee to {} format", exportType);
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
    public Page<OverTimeEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


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

import com.testshared1.testdb_26may.WorkPositionScope;

/**
 * ServiceImpl object for domain model class WorkPositionScope.
 *
 * @see WorkPositionScope
 */
@Service("TestDB_26may.WorkPositionScopeService")
public class WorkPositionScopeServiceImpl implements WorkPositionScopeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionScopeServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.WorkPositionScopeDao")
    private WMGenericDao<WorkPositionScope, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<WorkPositionScope, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public WorkPositionScope create(WorkPositionScope workpositionscope) {
        LOGGER.debug("Creating a new WorkPositionScope with information: {}", workpositionscope);
        return this.wmGenericDao.create(workpositionscope);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public WorkPositionScope getById(Integer workpositionscopeId) throws EntityNotFoundException {
        LOGGER.debug("Finding WorkPositionScope by id: {}", workpositionscopeId);
        WorkPositionScope workpositionscope = this.wmGenericDao.findById(workpositionscopeId);
        if (workpositionscope == null){
            LOGGER.debug("No WorkPositionScope found with id: {}", workpositionscopeId);
            throw new EntityNotFoundException(String.valueOf(workpositionscopeId));
        }
        return workpositionscope;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public WorkPositionScope update(WorkPositionScope workpositionscope) throws EntityNotFoundException {
        LOGGER.debug("Updating WorkPositionScope with information: {}", workpositionscope);
        this.wmGenericDao.update(workpositionscope);

        Integer workpositionscopeId = workpositionscope.getIdWorkPositionScope();

        return this.wmGenericDao.findById(workpositionscopeId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public WorkPositionScope delete(Integer workpositionscopeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting WorkPositionScope with id: {}", workpositionscopeId);
        WorkPositionScope deleted = this.wmGenericDao.findById(workpositionscopeId);
        if (deleted == null) {
            LOGGER.debug("No WorkPositionScope found with id: {}", workpositionscopeId);
            throw new EntityNotFoundException(String.valueOf(workpositionscopeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<WorkPositionScope> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all WorkPositionScopes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<WorkPositionScope> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all WorkPositionScopes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table WorkPositionScope to {} format", exportType);
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
    public Page<WorkPositionScope> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


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

import com.testshared1.testdb_26may.ListEmployeePosition;

/**
 * ServiceImpl object for domain model class ListEmployeePosition.
 *
 * @see ListEmployeePosition
 */
@Service("TestDB_26may.ListEmployeePositionService")
public class ListEmployeePositionServiceImpl implements ListEmployeePositionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListEmployeePositionServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.ListEmployeePositionDao")
    private WMGenericDao<ListEmployeePosition, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ListEmployeePosition, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public ListEmployeePosition create(ListEmployeePosition listemployeeposition) {
        LOGGER.debug("Creating a new ListEmployeePosition with information: {}", listemployeeposition);
        return this.wmGenericDao.create(listemployeeposition);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public ListEmployeePosition getById(Integer listemployeepositionId) throws EntityNotFoundException {
        LOGGER.debug("Finding ListEmployeePosition by id: {}", listemployeepositionId);
        ListEmployeePosition listemployeeposition = this.wmGenericDao.findById(listemployeepositionId);
        if (listemployeeposition == null){
            LOGGER.debug("No ListEmployeePosition found with id: {}", listemployeepositionId);
            throw new EntityNotFoundException(String.valueOf(listemployeepositionId));
        }
        return listemployeeposition;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public ListEmployeePosition update(ListEmployeePosition listemployeeposition) throws EntityNotFoundException {
        LOGGER.debug("Updating ListEmployeePosition with information: {}", listemployeeposition);
        this.wmGenericDao.update(listemployeeposition);

        Integer listemployeepositionId = listemployeeposition.getIdListEmployeePosition();

        return this.wmGenericDao.findById(listemployeepositionId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public ListEmployeePosition delete(Integer listemployeepositionId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListEmployeePosition with id: {}", listemployeepositionId);
        ListEmployeePosition deleted = this.wmGenericDao.findById(listemployeepositionId);
        if (deleted == null) {
            LOGGER.debug("No ListEmployeePosition found with id: {}", listemployeepositionId);
            throw new EntityNotFoundException(String.valueOf(listemployeepositionId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<ListEmployeePosition> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ListEmployeePositions");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<ListEmployeePosition> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ListEmployeePositions");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table ListEmployeePosition to {} format", exportType);
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
    public Page<ListEmployeePosition> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


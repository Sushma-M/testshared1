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

import com.testshared1.testdb_26may.ScheduleDynamic;

/**
 * ServiceImpl object for domain model class ScheduleDynamic.
 *
 * @see ScheduleDynamic
 */
@Service("TestDB_26may.ScheduleDynamicService")
public class ScheduleDynamicServiceImpl implements ScheduleDynamicService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleDynamicServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.ScheduleDynamicDao")
    private WMGenericDao<ScheduleDynamic, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ScheduleDynamic, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public ScheduleDynamic create(ScheduleDynamic scheduledynamic) {
        LOGGER.debug("Creating a new ScheduleDynamic with information: {}", scheduledynamic);
        return this.wmGenericDao.create(scheduledynamic);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public ScheduleDynamic getById(Integer scheduledynamicId) throws EntityNotFoundException {
        LOGGER.debug("Finding ScheduleDynamic by id: {}", scheduledynamicId);
        ScheduleDynamic scheduledynamic = this.wmGenericDao.findById(scheduledynamicId);
        if (scheduledynamic == null){
            LOGGER.debug("No ScheduleDynamic found with id: {}", scheduledynamicId);
            throw new EntityNotFoundException(String.valueOf(scheduledynamicId));
        }
        return scheduledynamic;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public ScheduleDynamic update(ScheduleDynamic scheduledynamic) throws EntityNotFoundException {
        LOGGER.debug("Updating ScheduleDynamic with information: {}", scheduledynamic);
        this.wmGenericDao.update(scheduledynamic);

        Integer scheduledynamicId = scheduledynamic.getIdScheduleDynamic();

        return this.wmGenericDao.findById(scheduledynamicId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public ScheduleDynamic delete(Integer scheduledynamicId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ScheduleDynamic with id: {}", scheduledynamicId);
        ScheduleDynamic deleted = this.wmGenericDao.findById(scheduledynamicId);
        if (deleted == null) {
            LOGGER.debug("No ScheduleDynamic found with id: {}", scheduledynamicId);
            throw new EntityNotFoundException(String.valueOf(scheduledynamicId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<ScheduleDynamic> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ScheduleDynamics");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<ScheduleDynamic> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ScheduleDynamics");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table ScheduleDynamic to {} format", exportType);
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
    public Page<ScheduleDynamic> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

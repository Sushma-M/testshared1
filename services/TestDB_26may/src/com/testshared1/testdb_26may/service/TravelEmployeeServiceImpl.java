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

import com.testshared1.testdb_26may.TravelEmployee;

/**
 * ServiceImpl object for domain model class TravelEmployee.
 *
 * @see TravelEmployee
 */
@Service("TestDB_26may.TravelEmployeeService")
public class TravelEmployeeServiceImpl implements TravelEmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelEmployeeServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.TravelEmployeeDao")
    private WMGenericDao<TravelEmployee, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TravelEmployee, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public TravelEmployee create(TravelEmployee travelemployee) {
        LOGGER.debug("Creating a new TravelEmployee with information: {}", travelemployee);
        return this.wmGenericDao.create(travelemployee);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public TravelEmployee getById(Integer travelemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Finding TravelEmployee by id: {}", travelemployeeId);
        TravelEmployee travelemployee = this.wmGenericDao.findById(travelemployeeId);
        if (travelemployee == null){
            LOGGER.debug("No TravelEmployee found with id: {}", travelemployeeId);
            throw new EntityNotFoundException(String.valueOf(travelemployeeId));
        }
        return travelemployee;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public TravelEmployee update(TravelEmployee travelemployee) throws EntityNotFoundException {
        LOGGER.debug("Updating TravelEmployee with information: {}", travelemployee);
        this.wmGenericDao.update(travelemployee);

        Integer travelemployeeId = travelemployee.getIdTravelEmployee();

        return this.wmGenericDao.findById(travelemployeeId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public TravelEmployee delete(Integer travelemployeeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TravelEmployee with id: {}", travelemployeeId);
        TravelEmployee deleted = this.wmGenericDao.findById(travelemployeeId);
        if (deleted == null) {
            LOGGER.debug("No TravelEmployee found with id: {}", travelemployeeId);
            throw new EntityNotFoundException(String.valueOf(travelemployeeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<TravelEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TravelEmployees");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<TravelEmployee> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TravelEmployees");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table TravelEmployee to {} format", exportType);
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
    public Page<TravelEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


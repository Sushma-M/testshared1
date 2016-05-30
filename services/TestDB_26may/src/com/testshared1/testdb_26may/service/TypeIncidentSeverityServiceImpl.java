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

import com.testshared1.testdb_26may.TypeIncidentSeverity;

/**
 * ServiceImpl object for domain model class TypeIncidentSeverity.
 *
 * @see TypeIncidentSeverity
 */
@Service("TestDB_26may.TypeIncidentSeverityService")
public class TypeIncidentSeverityServiceImpl implements TypeIncidentSeverityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeIncidentSeverityServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeIncidentSeverityDao")
    private WMGenericDao<TypeIncidentSeverity, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeIncidentSeverity, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public TypeIncidentSeverity create(TypeIncidentSeverity typeincidentseverity) {
        LOGGER.debug("Creating a new TypeIncidentSeverity with information: {}", typeincidentseverity);
        return this.wmGenericDao.create(typeincidentseverity);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeIncidentSeverity getById(Integer typeincidentseverityId) throws EntityNotFoundException {
        LOGGER.debug("Finding TypeIncidentSeverity by id: {}", typeincidentseverityId);
        TypeIncidentSeverity typeincidentseverity = this.wmGenericDao.findById(typeincidentseverityId);
        if (typeincidentseverity == null){
            LOGGER.debug("No TypeIncidentSeverity found with id: {}", typeincidentseverityId);
            throw new EntityNotFoundException(String.valueOf(typeincidentseverityId));
        }
        return typeincidentseverity;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeIncidentSeverity update(TypeIncidentSeverity typeincidentseverity) throws EntityNotFoundException {
        LOGGER.debug("Updating TypeIncidentSeverity with information: {}", typeincidentseverity);
        this.wmGenericDao.update(typeincidentseverity);

        Integer typeincidentseverityId = typeincidentseverity.getIdTypeIncidentSeverity();

        return this.wmGenericDao.findById(typeincidentseverityId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public TypeIncidentSeverity delete(Integer typeincidentseverityId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeIncidentSeverity with id: {}", typeincidentseverityId);
        TypeIncidentSeverity deleted = this.wmGenericDao.findById(typeincidentseverityId);
        if (deleted == null) {
            LOGGER.debug("No TypeIncidentSeverity found with id: {}", typeincidentseverityId);
            throw new EntityNotFoundException(String.valueOf(typeincidentseverityId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<TypeIncidentSeverity> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TypeIncidentSeverities");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<TypeIncidentSeverity> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TypeIncidentSeverities");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table TypeIncidentSeverity to {} format", exportType);
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
    public Page<TypeIncidentSeverity> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


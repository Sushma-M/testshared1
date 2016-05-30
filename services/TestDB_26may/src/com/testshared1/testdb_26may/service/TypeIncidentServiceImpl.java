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

import com.testshared1.testdb_26may.TypeIncident;

/**
 * ServiceImpl object for domain model class TypeIncident.
 *
 * @see TypeIncident
 */
@Service("TestDB_26may.TypeIncidentService")
public class TypeIncidentServiceImpl implements TypeIncidentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeIncidentServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeIncidentDao")
    private WMGenericDao<TypeIncident, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeIncident, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public TypeIncident create(TypeIncident typeincident) {
        LOGGER.debug("Creating a new TypeIncident with information: {}", typeincident);
        return this.wmGenericDao.create(typeincident);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeIncident getById(Integer typeincidentId) throws EntityNotFoundException {
        LOGGER.debug("Finding TypeIncident by id: {}", typeincidentId);
        TypeIncident typeincident = this.wmGenericDao.findById(typeincidentId);
        if (typeincident == null){
            LOGGER.debug("No TypeIncident found with id: {}", typeincidentId);
            throw new EntityNotFoundException(String.valueOf(typeincidentId));
        }
        return typeincident;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeIncident update(TypeIncident typeincident) throws EntityNotFoundException {
        LOGGER.debug("Updating TypeIncident with information: {}", typeincident);
        this.wmGenericDao.update(typeincident);

        Integer typeincidentId = typeincident.getIdTypeIncident();

        return this.wmGenericDao.findById(typeincidentId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public TypeIncident delete(Integer typeincidentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeIncident with id: {}", typeincidentId);
        TypeIncident deleted = this.wmGenericDao.findById(typeincidentId);
        if (deleted == null) {
            LOGGER.debug("No TypeIncident found with id: {}", typeincidentId);
            throw new EntityNotFoundException(String.valueOf(typeincidentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<TypeIncident> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TypeIncidents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<TypeIncident> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TypeIncidents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table TypeIncident to {} format", exportType);
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
    public Page<TypeIncident> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

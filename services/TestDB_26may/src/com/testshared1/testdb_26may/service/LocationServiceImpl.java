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

import com.testshared1.testdb_26may.Location;

/**
 * ServiceImpl object for domain model class Location.
 *
 * @see Location
 */
@Service("TestDB_26may.LocationService")
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.LocationDao")
    private WMGenericDao<Location, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Location, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public Location create(Location location) {
        LOGGER.debug("Creating a new Location with information: {}", location);
        return this.wmGenericDao.create(location);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Location getById(Integer locationId) throws EntityNotFoundException {
        LOGGER.debug("Finding Location by id: {}", locationId);
        Location location = this.wmGenericDao.findById(locationId);
        if (location == null){
            LOGGER.debug("No Location found with id: {}", locationId);
            throw new EntityNotFoundException(String.valueOf(locationId));
        }
        return location;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public Location update(Location location) throws EntityNotFoundException {
        LOGGER.debug("Updating Location with information: {}", location);
        this.wmGenericDao.update(location);

        Integer locationId = location.getIdLocation();

        return this.wmGenericDao.findById(locationId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public Location delete(Integer locationId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Location with id: {}", locationId);
        Location deleted = this.wmGenericDao.findById(locationId);
        if (deleted == null) {
            LOGGER.debug("No Location found with id: {}", locationId);
            throw new EntityNotFoundException(String.valueOf(locationId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<Location> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Locations");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<Location> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Locations");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table Location to {} format", exportType);
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
    public Page<Location> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


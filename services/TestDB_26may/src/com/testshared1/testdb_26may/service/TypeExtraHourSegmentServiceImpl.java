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

import com.testshared1.testdb_26may.TypeExtraHourSegment;

/**
 * ServiceImpl object for domain model class TypeExtraHourSegment.
 *
 * @see TypeExtraHourSegment
 */
@Service("TestDB_26may.TypeExtraHourSegmentService")
public class TypeExtraHourSegmentServiceImpl implements TypeExtraHourSegmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeExtraHourSegmentServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeExtraHourSegmentDao")
    private WMGenericDao<TypeExtraHourSegment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeExtraHourSegment, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public TypeExtraHourSegment create(TypeExtraHourSegment typeextrahoursegment) {
        LOGGER.debug("Creating a new TypeExtraHourSegment with information: {}", typeextrahoursegment);
        return this.wmGenericDao.create(typeextrahoursegment);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeExtraHourSegment getById(Integer typeextrahoursegmentId) throws EntityNotFoundException {
        LOGGER.debug("Finding TypeExtraHourSegment by id: {}", typeextrahoursegmentId);
        TypeExtraHourSegment typeextrahoursegment = this.wmGenericDao.findById(typeextrahoursegmentId);
        if (typeextrahoursegment == null){
            LOGGER.debug("No TypeExtraHourSegment found with id: {}", typeextrahoursegmentId);
            throw new EntityNotFoundException(String.valueOf(typeextrahoursegmentId));
        }
        return typeextrahoursegment;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeExtraHourSegment update(TypeExtraHourSegment typeextrahoursegment) throws EntityNotFoundException {
        LOGGER.debug("Updating TypeExtraHourSegment with information: {}", typeextrahoursegment);
        this.wmGenericDao.update(typeextrahoursegment);

        Integer typeextrahoursegmentId = typeextrahoursegment.getIdTypeExtraHourSegment();

        return this.wmGenericDao.findById(typeextrahoursegmentId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public TypeExtraHourSegment delete(Integer typeextrahoursegmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeExtraHourSegment with id: {}", typeextrahoursegmentId);
        TypeExtraHourSegment deleted = this.wmGenericDao.findById(typeextrahoursegmentId);
        if (deleted == null) {
            LOGGER.debug("No TypeExtraHourSegment found with id: {}", typeextrahoursegmentId);
            throw new EntityNotFoundException(String.valueOf(typeextrahoursegmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<TypeExtraHourSegment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TypeExtraHourSegments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<TypeExtraHourSegment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TypeExtraHourSegments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table TypeExtraHourSegment to {} format", exportType);
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
    public Page<TypeExtraHourSegment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


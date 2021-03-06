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

import com.testshared1.testdb_26may.TypeApplicantStatus;

/**
 * ServiceImpl object for domain model class TypeApplicantStatus.
 *
 * @see TypeApplicantStatus
 */
@Service("TestDB_26may.TypeApplicantStatusService")
public class TypeApplicantStatusServiceImpl implements TypeApplicantStatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeApplicantStatusServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeApplicantStatusDao")
    private WMGenericDao<TypeApplicantStatus, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeApplicantStatus, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public TypeApplicantStatus create(TypeApplicantStatus typeapplicantstatus) {
        LOGGER.debug("Creating a new TypeApplicantStatus with information: {}", typeapplicantstatus);
        return this.wmGenericDao.create(typeapplicantstatus);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeApplicantStatus getById(Integer typeapplicantstatusId) throws EntityNotFoundException {
        LOGGER.debug("Finding TypeApplicantStatus by id: {}", typeapplicantstatusId);
        TypeApplicantStatus typeapplicantstatus = this.wmGenericDao.findById(typeapplicantstatusId);
        if (typeapplicantstatus == null){
            LOGGER.debug("No TypeApplicantStatus found with id: {}", typeapplicantstatusId);
            throw new EntityNotFoundException(String.valueOf(typeapplicantstatusId));
        }
        return typeapplicantstatus;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeApplicantStatus update(TypeApplicantStatus typeapplicantstatus) throws EntityNotFoundException {
        LOGGER.debug("Updating TypeApplicantStatus with information: {}", typeapplicantstatus);
        this.wmGenericDao.update(typeapplicantstatus);

        Integer typeapplicantstatusId = typeapplicantstatus.getIdTypeMaritalStatus();

        return this.wmGenericDao.findById(typeapplicantstatusId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public TypeApplicantStatus delete(Integer typeapplicantstatusId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeApplicantStatus with id: {}", typeapplicantstatusId);
        TypeApplicantStatus deleted = this.wmGenericDao.findById(typeapplicantstatusId);
        if (deleted == null) {
            LOGGER.debug("No TypeApplicantStatus found with id: {}", typeapplicantstatusId);
            throw new EntityNotFoundException(String.valueOf(typeapplicantstatusId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<TypeApplicantStatus> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TypeApplicantStatuses");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<TypeApplicantStatus> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TypeApplicantStatuses");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table TypeApplicantStatus to {} format", exportType);
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
    public Page<TypeApplicantStatus> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


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

import com.testshared1.testdb_26may.TypeRecruitment;

/**
 * ServiceImpl object for domain model class TypeRecruitment.
 *
 * @see TypeRecruitment
 */
@Service("TestDB_26may.TypeRecruitmentService")
public class TypeRecruitmentServiceImpl implements TypeRecruitmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeRecruitmentServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeRecruitmentDao")
    private WMGenericDao<TypeRecruitment, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TypeRecruitment, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public TypeRecruitment create(TypeRecruitment typerecruitment) {
        LOGGER.debug("Creating a new TypeRecruitment with information: {}", typerecruitment);
        return this.wmGenericDao.create(typerecruitment);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeRecruitment getById(Integer typerecruitmentId) throws EntityNotFoundException {
        LOGGER.debug("Finding TypeRecruitment by id: {}", typerecruitmentId);
        TypeRecruitment typerecruitment = this.wmGenericDao.findById(typerecruitmentId);
        if (typerecruitment == null){
            LOGGER.debug("No TypeRecruitment found with id: {}", typerecruitmentId);
            throw new EntityNotFoundException(String.valueOf(typerecruitmentId));
        }
        return typerecruitment;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public TypeRecruitment update(TypeRecruitment typerecruitment) throws EntityNotFoundException {
        LOGGER.debug("Updating TypeRecruitment with information: {}", typerecruitment);
        this.wmGenericDao.update(typerecruitment);

        Integer typerecruitmentId = typerecruitment.getIdTypeRecruitment();

        return this.wmGenericDao.findById(typerecruitmentId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public TypeRecruitment delete(Integer typerecruitmentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeRecruitment with id: {}", typerecruitmentId);
        TypeRecruitment deleted = this.wmGenericDao.findById(typerecruitmentId);
        if (deleted == null) {
            LOGGER.debug("No TypeRecruitment found with id: {}", typerecruitmentId);
            throw new EntityNotFoundException(String.valueOf(typerecruitmentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<TypeRecruitment> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TypeRecruitments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<TypeRecruitment> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TypeRecruitments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table TypeRecruitment to {} format", exportType);
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
    public Page<TypeRecruitment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


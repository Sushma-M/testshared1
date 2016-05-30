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

import com.testshared1.testdb_26may.EmployeePhotoFile;

/**
 * ServiceImpl object for domain model class EmployeePhotoFile.
 *
 * @see EmployeePhotoFile
 */
@Service("TestDB_26may.EmployeePhotoFileService")
public class EmployeePhotoFileServiceImpl implements EmployeePhotoFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePhotoFileServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeePhotoFileDao")
    private WMGenericDao<EmployeePhotoFile, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeePhotoFile, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public EmployeePhotoFile create(EmployeePhotoFile employeephotofile) {
        LOGGER.debug("Creating a new EmployeePhotoFile with information: {}", employeephotofile);
        return this.wmGenericDao.create(employeephotofile);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeePhotoFile getById(Integer employeephotofileId) throws EntityNotFoundException {
        LOGGER.debug("Finding EmployeePhotoFile by id: {}", employeephotofileId);
        EmployeePhotoFile employeephotofile = this.wmGenericDao.findById(employeephotofileId);
        if (employeephotofile == null){
            LOGGER.debug("No EmployeePhotoFile found with id: {}", employeephotofileId);
            throw new EntityNotFoundException(String.valueOf(employeephotofileId));
        }
        return employeephotofile;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeePhotoFile update(EmployeePhotoFile employeephotofile) throws EntityNotFoundException {
        LOGGER.debug("Updating EmployeePhotoFile with information: {}", employeephotofile);
        this.wmGenericDao.update(employeephotofile);

        Integer employeephotofileId = employeephotofile.getIdEmployeePhotoFile();

        return this.wmGenericDao.findById(employeephotofileId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeePhotoFile delete(Integer employeephotofileId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeePhotoFile with id: {}", employeephotofileId);
        EmployeePhotoFile deleted = this.wmGenericDao.findById(employeephotofileId);
        if (deleted == null) {
            LOGGER.debug("No EmployeePhotoFile found with id: {}", employeephotofileId);
            throw new EntityNotFoundException(String.valueOf(employeephotofileId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<EmployeePhotoFile> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EmployeePhotoFiles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<EmployeePhotoFile> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EmployeePhotoFiles");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table EmployeePhotoFile to {} format", exportType);
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
    public Page<EmployeePhotoFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


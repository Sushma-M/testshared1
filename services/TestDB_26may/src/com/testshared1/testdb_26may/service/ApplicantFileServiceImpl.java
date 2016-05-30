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

import com.testshared1.testdb_26may.ApplicantFile;

/**
 * ServiceImpl object for domain model class ApplicantFile.
 *
 * @see ApplicantFile
 */
@Service("TestDB_26may.ApplicantFileService")
public class ApplicantFileServiceImpl implements ApplicantFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantFileServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.ApplicantFileDao")
    private WMGenericDao<ApplicantFile, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ApplicantFile, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public ApplicantFile create(ApplicantFile applicantfile) {
        LOGGER.debug("Creating a new ApplicantFile with information: {}", applicantfile);
        return this.wmGenericDao.create(applicantfile);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public ApplicantFile getById(Integer applicantfileId) throws EntityNotFoundException {
        LOGGER.debug("Finding ApplicantFile by id: {}", applicantfileId);
        ApplicantFile applicantfile = this.wmGenericDao.findById(applicantfileId);
        if (applicantfile == null){
            LOGGER.debug("No ApplicantFile found with id: {}", applicantfileId);
            throw new EntityNotFoundException(String.valueOf(applicantfileId));
        }
        return applicantfile;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public ApplicantFile update(ApplicantFile applicantfile) throws EntityNotFoundException {
        LOGGER.debug("Updating ApplicantFile with information: {}", applicantfile);
        this.wmGenericDao.update(applicantfile);

        Integer applicantfileId = applicantfile.getIdApplicantFile();

        return this.wmGenericDao.findById(applicantfileId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public ApplicantFile delete(Integer applicantfileId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ApplicantFile with id: {}", applicantfileId);
        ApplicantFile deleted = this.wmGenericDao.findById(applicantfileId);
        if (deleted == null) {
            LOGGER.debug("No ApplicantFile found with id: {}", applicantfileId);
            throw new EntityNotFoundException(String.valueOf(applicantfileId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<ApplicantFile> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ApplicantFiles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<ApplicantFile> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ApplicantFiles");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table ApplicantFile to {} format", exportType);
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
    public Page<ApplicantFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

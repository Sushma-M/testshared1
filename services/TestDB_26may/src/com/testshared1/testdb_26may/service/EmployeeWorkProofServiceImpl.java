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

import com.testshared1.testdb_26may.EmployeeWorkProof;

/**
 * ServiceImpl object for domain model class EmployeeWorkProof.
 *
 * @see EmployeeWorkProof
 */
@Service("TestDB_26may.EmployeeWorkProofService")
public class EmployeeWorkProofServiceImpl implements EmployeeWorkProofService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeWorkProofServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeeWorkProofDao")
    private WMGenericDao<EmployeeWorkProof, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EmployeeWorkProof, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public EmployeeWorkProof create(EmployeeWorkProof employeeworkproof) {
        LOGGER.debug("Creating a new EmployeeWorkProof with information: {}", employeeworkproof);
        return this.wmGenericDao.create(employeeworkproof);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeWorkProof getById(Integer employeeworkproofId) throws EntityNotFoundException {
        LOGGER.debug("Finding EmployeeWorkProof by id: {}", employeeworkproofId);
        EmployeeWorkProof employeeworkproof = this.wmGenericDao.findById(employeeworkproofId);
        if (employeeworkproof == null){
            LOGGER.debug("No EmployeeWorkProof found with id: {}", employeeworkproofId);
            throw new EntityNotFoundException(String.valueOf(employeeworkproofId));
        }
        return employeeworkproof;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeWorkProof update(EmployeeWorkProof employeeworkproof) throws EntityNotFoundException {
        LOGGER.debug("Updating EmployeeWorkProof with information: {}", employeeworkproof);
        this.wmGenericDao.update(employeeworkproof);

        Integer employeeworkproofId = employeeworkproof.getIdEmployeeWorkProof();

        return this.wmGenericDao.findById(employeeworkproofId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public EmployeeWorkProof delete(Integer employeeworkproofId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeWorkProof with id: {}", employeeworkproofId);
        EmployeeWorkProof deleted = this.wmGenericDao.findById(employeeworkproofId);
        if (deleted == null) {
            LOGGER.debug("No EmployeeWorkProof found with id: {}", employeeworkproofId);
            throw new EntityNotFoundException(String.valueOf(employeeworkproofId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<EmployeeWorkProof> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EmployeeWorkProofs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<EmployeeWorkProof> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EmployeeWorkProofs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table EmployeeWorkProof to {} format", exportType);
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
    public Page<EmployeeWorkProof> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

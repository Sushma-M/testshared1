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

import com.testshared1.testdb_26may.Payroll;

/**
 * ServiceImpl object for domain model class Payroll.
 *
 * @see Payroll
 */
@Service("TestDB_26may.PayrollService")
public class PayrollServiceImpl implements PayrollService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.PayrollDao")
    private WMGenericDao<Payroll, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Payroll, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public Payroll create(Payroll payroll) {
        LOGGER.debug("Creating a new Payroll with information: {}", payroll);
        return this.wmGenericDao.create(payroll);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Payroll getById(Integer payrollId) throws EntityNotFoundException {
        LOGGER.debug("Finding Payroll by id: {}", payrollId);
        Payroll payroll = this.wmGenericDao.findById(payrollId);
        if (payroll == null){
            LOGGER.debug("No Payroll found with id: {}", payrollId);
            throw new EntityNotFoundException(String.valueOf(payrollId));
        }
        return payroll;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public Payroll update(Payroll payroll) throws EntityNotFoundException {
        LOGGER.debug("Updating Payroll with information: {}", payroll);
        this.wmGenericDao.update(payroll);

        Integer payrollId = payroll.getIdPayroll();

        return this.wmGenericDao.findById(payrollId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public Payroll delete(Integer payrollId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Payroll with id: {}", payrollId);
        Payroll deleted = this.wmGenericDao.findById(payrollId);
        if (deleted == null) {
            LOGGER.debug("No Payroll found with id: {}", payrollId);
            throw new EntityNotFoundException(String.valueOf(payrollId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<Payroll> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Payrolls");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<Payroll> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Payrolls");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table Payroll to {} format", exportType);
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
    public Page<Payroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


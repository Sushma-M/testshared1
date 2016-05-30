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

import com.testshared1.testdb_26may.ListPeriodicDeductionPayroll;

/**
 * ServiceImpl object for domain model class ListPeriodicDeductionPayroll.
 *
 * @see ListPeriodicDeductionPayroll
 */
@Service("TestDB_26may.ListPeriodicDeductionPayrollService")
public class ListPeriodicDeductionPayrollServiceImpl implements ListPeriodicDeductionPayrollService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListPeriodicDeductionPayrollServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.ListPeriodicDeductionPayrollDao")
    private WMGenericDao<ListPeriodicDeductionPayroll, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ListPeriodicDeductionPayroll, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public ListPeriodicDeductionPayroll create(ListPeriodicDeductionPayroll listperiodicdeductionpayroll) {
        LOGGER.debug("Creating a new ListPeriodicDeductionPayroll with information: {}", listperiodicdeductionpayroll);
        return this.wmGenericDao.create(listperiodicdeductionpayroll);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public ListPeriodicDeductionPayroll getById(Integer listperiodicdeductionpayrollId) throws EntityNotFoundException {
        LOGGER.debug("Finding ListPeriodicDeductionPayroll by id: {}", listperiodicdeductionpayrollId);
        ListPeriodicDeductionPayroll listperiodicdeductionpayroll = this.wmGenericDao.findById(listperiodicdeductionpayrollId);
        if (listperiodicdeductionpayroll == null){
            LOGGER.debug("No ListPeriodicDeductionPayroll found with id: {}", listperiodicdeductionpayrollId);
            throw new EntityNotFoundException(String.valueOf(listperiodicdeductionpayrollId));
        }
        return listperiodicdeductionpayroll;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public ListPeriodicDeductionPayroll update(ListPeriodicDeductionPayroll listperiodicdeductionpayroll) throws EntityNotFoundException {
        LOGGER.debug("Updating ListPeriodicDeductionPayroll with information: {}", listperiodicdeductionpayroll);
        this.wmGenericDao.update(listperiodicdeductionpayroll);

        Integer listperiodicdeductionpayrollId = listperiodicdeductionpayroll.getIdListPeriodicDeductionPayroll();

        return this.wmGenericDao.findById(listperiodicdeductionpayrollId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public ListPeriodicDeductionPayroll delete(Integer listperiodicdeductionpayrollId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListPeriodicDeductionPayroll with id: {}", listperiodicdeductionpayrollId);
        ListPeriodicDeductionPayroll deleted = this.wmGenericDao.findById(listperiodicdeductionpayrollId);
        if (deleted == null) {
            LOGGER.debug("No ListPeriodicDeductionPayroll found with id: {}", listperiodicdeductionpayrollId);
            throw new EntityNotFoundException(String.valueOf(listperiodicdeductionpayrollId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<ListPeriodicDeductionPayroll> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ListPeriodicDeductionPayrolls");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<ListPeriodicDeductionPayroll> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ListPeriodicDeductionPayrolls");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table ListPeriodicDeductionPayroll to {} format", exportType);
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
    public Page<ListPeriodicDeductionPayroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

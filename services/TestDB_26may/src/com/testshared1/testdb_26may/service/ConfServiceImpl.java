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

import com.testshared1.testdb_26may.Conf;

/**
 * ServiceImpl object for domain model class Conf.
 *
 * @see Conf
 */
@Service("TestDB_26may.ConfService")
public class ConfServiceImpl implements ConfService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.ConfDao")
    private WMGenericDao<Conf, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Conf, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public Conf create(Conf conf) {
        LOGGER.debug("Creating a new Conf with information: {}", conf);
        return this.wmGenericDao.create(conf);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Conf getById(Integer confId) throws EntityNotFoundException {
        LOGGER.debug("Finding Conf by id: {}", confId);
        Conf conf = this.wmGenericDao.findById(confId);
        if (conf == null){
            LOGGER.debug("No Conf found with id: {}", confId);
            throw new EntityNotFoundException(String.valueOf(confId));
        }
        return conf;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public Conf update(Conf conf) throws EntityNotFoundException {
        LOGGER.debug("Updating Conf with information: {}", conf);
        this.wmGenericDao.update(conf);

        Integer confId = conf.getIdConf();

        return this.wmGenericDao.findById(confId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public Conf delete(Integer confId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Conf with id: {}", confId);
        Conf deleted = this.wmGenericDao.findById(confId);
        if (deleted == null) {
            LOGGER.debug("No Conf found with id: {}", confId);
            throw new EntityNotFoundException(String.valueOf(confId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<Conf> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Confs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<Conf> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Confs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table Conf to {} format", exportType);
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
    public Page<Conf> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


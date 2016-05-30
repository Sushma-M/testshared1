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

import com.testshared1.testdb_26may.AssetFile;

/**
 * ServiceImpl object for domain model class AssetFile.
 *
 * @see AssetFile
 */
@Service("TestDB_26may.AssetFileService")
public class AssetFileServiceImpl implements AssetFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetFileServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.AssetFileDao")
    private WMGenericDao<AssetFile, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AssetFile, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public AssetFile create(AssetFile assetfile) {
        LOGGER.debug("Creating a new AssetFile with information: {}", assetfile);
        return this.wmGenericDao.create(assetfile);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public AssetFile getById(Integer assetfileId) throws EntityNotFoundException {
        LOGGER.debug("Finding AssetFile by id: {}", assetfileId);
        AssetFile assetfile = this.wmGenericDao.findById(assetfileId);
        if (assetfile == null){
            LOGGER.debug("No AssetFile found with id: {}", assetfileId);
            throw new EntityNotFoundException(String.valueOf(assetfileId));
        }
        return assetfile;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public AssetFile update(AssetFile assetfile) throws EntityNotFoundException {
        LOGGER.debug("Updating AssetFile with information: {}", assetfile);
        this.wmGenericDao.update(assetfile);

        Integer assetfileId = assetfile.getIdAssetFile();

        return this.wmGenericDao.findById(assetfileId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public AssetFile delete(Integer assetfileId) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssetFile with id: {}", assetfileId);
        AssetFile deleted = this.wmGenericDao.findById(assetfileId);
        if (deleted == null) {
            LOGGER.debug("No AssetFile found with id: {}", assetfileId);
            throw new EntityNotFoundException(String.valueOf(assetfileId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<AssetFile> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AssetFiles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<AssetFile> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AssetFiles");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table AssetFile to {} format", exportType);
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
    public Page<AssetFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

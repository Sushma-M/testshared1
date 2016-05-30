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

import com.testshared1.testdb_26may.AssetPhotoFile;

/**
 * ServiceImpl object for domain model class AssetPhotoFile.
 *
 * @see AssetPhotoFile
 */
@Service("TestDB_26may.AssetPhotoFileService")
public class AssetPhotoFileServiceImpl implements AssetPhotoFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetPhotoFileServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.AssetPhotoFileDao")
    private WMGenericDao<AssetPhotoFile, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<AssetPhotoFile, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public AssetPhotoFile create(AssetPhotoFile assetphotofile) {
        LOGGER.debug("Creating a new AssetPhotoFile with information: {}", assetphotofile);
        return this.wmGenericDao.create(assetphotofile);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public AssetPhotoFile getById(Integer assetphotofileId) throws EntityNotFoundException {
        LOGGER.debug("Finding AssetPhotoFile by id: {}", assetphotofileId);
        AssetPhotoFile assetphotofile = this.wmGenericDao.findById(assetphotofileId);
        if (assetphotofile == null){
            LOGGER.debug("No AssetPhotoFile found with id: {}", assetphotofileId);
            throw new EntityNotFoundException(String.valueOf(assetphotofileId));
        }
        return assetphotofile;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public AssetPhotoFile update(AssetPhotoFile assetphotofile) throws EntityNotFoundException {
        LOGGER.debug("Updating AssetPhotoFile with information: {}", assetphotofile);
        this.wmGenericDao.update(assetphotofile);

        Integer assetphotofileId = assetphotofile.getIdAssetPhotoFile();

        return this.wmGenericDao.findById(assetphotofileId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public AssetPhotoFile delete(Integer assetphotofileId) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssetPhotoFile with id: {}", assetphotofileId);
        AssetPhotoFile deleted = this.wmGenericDao.findById(assetphotofileId);
        if (deleted == null) {
            LOGGER.debug("No AssetPhotoFile found with id: {}", assetphotofileId);
            throw new EntityNotFoundException(String.valueOf(assetphotofileId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<AssetPhotoFile> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all AssetPhotoFiles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<AssetPhotoFile> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all AssetPhotoFiles");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table AssetPhotoFile to {} format", exportType);
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
    public Page<AssetPhotoFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}

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

import com.testshared1.testdb_26may.Role;

/**
 * ServiceImpl object for domain model class Role.
 *
 * @see Role
 */
@Service("TestDB_26may.RoleService")
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    @Qualifier("TestDB_26may.RoleDao")
    private WMGenericDao<Role, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Role, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
    @Override
	public Role create(Role role) {
        LOGGER.debug("Creating a new Role with information: {}", role);
        return this.wmGenericDao.create(role);
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Role getById(Integer roleId) throws EntityNotFoundException {
        LOGGER.debug("Finding Role by id: {}", roleId);
        Role role = this.wmGenericDao.findById(roleId);
        if (role == null){
            LOGGER.debug("No Role found with id: {}", roleId);
            throw new EntityNotFoundException(String.valueOf(roleId));
        }
        return role;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "TestDB_26mayTransactionManager")
	@Override
	public Role update(Role role) throws EntityNotFoundException {
        LOGGER.debug("Updating Role with information: {}", role);
        this.wmGenericDao.update(role);

        Integer roleId = role.getIdRole();

        return this.wmGenericDao.findById(roleId);
    }

    @Transactional(value = "TestDB_26mayTransactionManager")
	@Override
	public Role delete(Integer roleId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Role with id: {}", roleId);
        Role deleted = this.wmGenericDao.findById(roleId);
        if (deleted == null) {
            LOGGER.debug("No Role found with id: {}", roleId);
            throw new EntityNotFoundException(String.valueOf(roleId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
	@Override
	public Page<Role> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Roles");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Page<Role> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Roles");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "TestDB_26mayTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service TestDB_26may for table Role to {} format", exportType);
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
    public Page<Role> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable) {
        LOGGER.debug("Fetching all associated");
        return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
    }
}


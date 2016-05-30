/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testshared1.testdb_26may.RolePermission;

/**
 * Service object for domain model class RolePermission.
 *
 * @see {@link RolePermission}
 */
public interface RolePermissionService {

    /**
     * Creates a new RolePermission.
     *
     * @param rolePermission The information of the created CompositeTable.
     * @return The created RolePermission.
     */
	RolePermission create(RolePermission rolePermission);


	/**
	 * Finds RolePermission by id.
	 *
	 * @param rolePermissionId The id of the wanted RolePermission.
	 * @return The found RolePermission. If no RolePermission is found, this method returns null.
	 */
	RolePermission getById(Integer rolePermissionId) throws EntityNotFoundException;

	/**
	 * Updates the information of a RolePermission.
	 *
	 * @param rolePermission The information of the updated RolePermission.
	 * @return The updated RolePermission.
     *
	 * @throws EntityNotFoundException if no RolePermission is found with given id.
	 */
	RolePermission update(RolePermission rolePermission) throws EntityNotFoundException;

    /**
	 * Deletes a RolePermission.
	 *
	 * @param rolePermissionId The id of the deleted RolePermission.
	 * @return The deleted RolePermission.
     *
	 * @throws EntityNotFoundException if no RolePermission is found with the given id.
	 */
	RolePermission delete(Integer rolePermissionId) throws EntityNotFoundException;

	/**
	 * Finds all RolePermissions.
	 *
	 * @return A list of RolePermissions.
	 */
    @Deprecated
	Page<RolePermission> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all RolePermissions.
	 * @return A list of RolePermissions.
	 */
    Page<RolePermission> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the RolePermissions in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the RolePermission.
	 */
	long count(String query);

    Page<RolePermission> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

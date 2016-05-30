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

import com.testshared1.testdb_26may.TypeOperationTimesheet;

/**
 * Service object for domain model class TypeOperationTimesheet.
 *
 * @see {@link TypeOperationTimesheet}
 */
public interface TypeOperationTimesheetService {

    /**
     * Creates a new TypeOperationTimesheet.
     *
     * @param typeOperationTimesheet The information of the created CompositeTable.
     * @return The created TypeOperationTimesheet.
     */
	TypeOperationTimesheet create(TypeOperationTimesheet typeOperationTimesheet);


	/**
	 * Finds TypeOperationTimesheet by id.
	 *
	 * @param typeOperationTimesheetId The id of the wanted TypeOperationTimesheet.
	 * @return The found TypeOperationTimesheet. If no TypeOperationTimesheet is found, this method returns null.
	 */
	TypeOperationTimesheet getById(Integer typeOperationTimesheetId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TypeOperationTimesheet.
	 *
	 * @param typeOperationTimesheet The information of the updated TypeOperationTimesheet.
	 * @return The updated TypeOperationTimesheet.
     *
	 * @throws EntityNotFoundException if no TypeOperationTimesheet is found with given id.
	 */
	TypeOperationTimesheet update(TypeOperationTimesheet typeOperationTimesheet) throws EntityNotFoundException;

    /**
	 * Deletes a TypeOperationTimesheet.
	 *
	 * @param typeOperationTimesheetId The id of the deleted TypeOperationTimesheet.
	 * @return The deleted TypeOperationTimesheet.
     *
	 * @throws EntityNotFoundException if no TypeOperationTimesheet is found with the given id.
	 */
	TypeOperationTimesheet delete(Integer typeOperationTimesheetId) throws EntityNotFoundException;

	/**
	 * Finds all TypeOperationTimesheets.
	 *
	 * @return A list of TypeOperationTimesheets.
	 */
    @Deprecated
	Page<TypeOperationTimesheet> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TypeOperationTimesheets.
	 * @return A list of TypeOperationTimesheets.
	 */
    Page<TypeOperationTimesheet> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TypeOperationTimesheets in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TypeOperationTimesheet.
	 */
	long count(String query);

    Page<TypeOperationTimesheet> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


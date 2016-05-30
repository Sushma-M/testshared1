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

import com.testshared1.testdb_26may.TypeEmployeeTermination;

/**
 * Service object for domain model class TypeEmployeeTermination.
 *
 * @see {@link TypeEmployeeTermination}
 */
public interface TypeEmployeeTerminationService {

    /**
     * Creates a new TypeEmployeeTermination.
     *
     * @param typeEmployeeTermination The information of the created CompositeTable.
     * @return The created TypeEmployeeTermination.
     */
	TypeEmployeeTermination create(TypeEmployeeTermination typeEmployeeTermination);


	/**
	 * Finds TypeEmployeeTermination by id.
	 *
	 * @param typeEmployeeTerminationId The id of the wanted TypeEmployeeTermination.
	 * @return The found TypeEmployeeTermination. If no TypeEmployeeTermination is found, this method returns null.
	 */
	TypeEmployeeTermination getById(Integer typeEmployeeTerminationId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TypeEmployeeTermination.
	 *
	 * @param typeEmployeeTermination The information of the updated TypeEmployeeTermination.
	 * @return The updated TypeEmployeeTermination.
     *
	 * @throws EntityNotFoundException if no TypeEmployeeTermination is found with given id.
	 */
	TypeEmployeeTermination update(TypeEmployeeTermination typeEmployeeTermination) throws EntityNotFoundException;

    /**
	 * Deletes a TypeEmployeeTermination.
	 *
	 * @param typeEmployeeTerminationId The id of the deleted TypeEmployeeTermination.
	 * @return The deleted TypeEmployeeTermination.
     *
	 * @throws EntityNotFoundException if no TypeEmployeeTermination is found with the given id.
	 */
	TypeEmployeeTermination delete(Integer typeEmployeeTerminationId) throws EntityNotFoundException;

	/**
	 * Finds all TypeEmployeeTerminations.
	 *
	 * @return A list of TypeEmployeeTerminations.
	 */
    @Deprecated
	Page<TypeEmployeeTermination> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TypeEmployeeTerminations.
	 * @return A list of TypeEmployeeTerminations.
	 */
    Page<TypeEmployeeTermination> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TypeEmployeeTerminations in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TypeEmployeeTermination.
	 */
	long count(String query);

    Page<TypeEmployeeTermination> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


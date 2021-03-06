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

import com.testshared1.testdb_26may.ListEmployeePosition;

/**
 * Service object for domain model class ListEmployeePosition.
 *
 * @see {@link ListEmployeePosition}
 */
public interface ListEmployeePositionService {

    /**
     * Creates a new ListEmployeePosition.
     *
     * @param listEmployeePosition The information of the created CompositeTable.
     * @return The created ListEmployeePosition.
     */
	ListEmployeePosition create(ListEmployeePosition listEmployeePosition);


	/**
	 * Finds ListEmployeePosition by id.
	 *
	 * @param listEmployeePositionId The id of the wanted ListEmployeePosition.
	 * @return The found ListEmployeePosition. If no ListEmployeePosition is found, this method returns null.
	 */
	ListEmployeePosition getById(Integer listEmployeePositionId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ListEmployeePosition.
	 *
	 * @param listEmployeePosition The information of the updated ListEmployeePosition.
	 * @return The updated ListEmployeePosition.
     *
	 * @throws EntityNotFoundException if no ListEmployeePosition is found with given id.
	 */
	ListEmployeePosition update(ListEmployeePosition listEmployeePosition) throws EntityNotFoundException;

    /**
	 * Deletes a ListEmployeePosition.
	 *
	 * @param listEmployeePositionId The id of the deleted ListEmployeePosition.
	 * @return The deleted ListEmployeePosition.
     *
	 * @throws EntityNotFoundException if no ListEmployeePosition is found with the given id.
	 */
	ListEmployeePosition delete(Integer listEmployeePositionId) throws EntityNotFoundException;

	/**
	 * Finds all ListEmployeePositions.
	 *
	 * @return A list of ListEmployeePositions.
	 */
    @Deprecated
	Page<ListEmployeePosition> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ListEmployeePositions.
	 * @return A list of ListEmployeePositions.
	 */
    Page<ListEmployeePosition> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ListEmployeePositions in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ListEmployeePosition.
	 */
	long count(String query);

    Page<ListEmployeePosition> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


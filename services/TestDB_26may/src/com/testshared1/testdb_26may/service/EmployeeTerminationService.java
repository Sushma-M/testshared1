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

import com.testshared1.testdb_26may.EmployeeTermination;

/**
 * Service object for domain model class EmployeeTermination.
 *
 * @see {@link EmployeeTermination}
 */
public interface EmployeeTerminationService {

    /**
     * Creates a new EmployeeTermination.
     *
     * @param employeeTermination The information of the created CompositeTable.
     * @return The created EmployeeTermination.
     */
	EmployeeTermination create(EmployeeTermination employeeTermination);


	/**
	 * Finds EmployeeTermination by id.
	 *
	 * @param employeeTerminationId The id of the wanted EmployeeTermination.
	 * @return The found EmployeeTermination. If no EmployeeTermination is found, this method returns null.
	 */
	EmployeeTermination getById(Integer employeeTerminationId) throws EntityNotFoundException;

	/**
	 * Updates the information of a EmployeeTermination.
	 *
	 * @param employeeTermination The information of the updated EmployeeTermination.
	 * @return The updated EmployeeTermination.
     *
	 * @throws EntityNotFoundException if no EmployeeTermination is found with given id.
	 */
	EmployeeTermination update(EmployeeTermination employeeTermination) throws EntityNotFoundException;

    /**
	 * Deletes a EmployeeTermination.
	 *
	 * @param employeeTerminationId The id of the deleted EmployeeTermination.
	 * @return The deleted EmployeeTermination.
     *
	 * @throws EntityNotFoundException if no EmployeeTermination is found with the given id.
	 */
	EmployeeTermination delete(Integer employeeTerminationId) throws EntityNotFoundException;

	/**
	 * Finds all EmployeeTerminations.
	 *
	 * @return A list of EmployeeTerminations.
	 */
    @Deprecated
	Page<EmployeeTermination> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all EmployeeTerminations.
	 * @return A list of EmployeeTerminations.
	 */
    Page<EmployeeTermination> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the EmployeeTerminations in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the EmployeeTermination.
	 */
	long count(String query);

    Page<EmployeeTermination> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

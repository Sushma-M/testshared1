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

import com.testshared1.testdb_26may.EmployeeWorkDay;

/**
 * Service object for domain model class EmployeeWorkDay.
 *
 * @see {@link EmployeeWorkDay}
 */
public interface EmployeeWorkDayService {

    /**
     * Creates a new EmployeeWorkDay.
     *
     * @param employeeWorkDay The information of the created CompositeTable.
     * @return The created EmployeeWorkDay.
     */
	EmployeeWorkDay create(EmployeeWorkDay employeeWorkDay);


	/**
	 * Finds EmployeeWorkDay by id.
	 *
	 * @param employeeWorkDayId The id of the wanted EmployeeWorkDay.
	 * @return The found EmployeeWorkDay. If no EmployeeWorkDay is found, this method returns null.
	 */
	EmployeeWorkDay getById(Integer employeeWorkDayId) throws EntityNotFoundException;

	/**
	 * Updates the information of a EmployeeWorkDay.
	 *
	 * @param employeeWorkDay The information of the updated EmployeeWorkDay.
	 * @return The updated EmployeeWorkDay.
     *
	 * @throws EntityNotFoundException if no EmployeeWorkDay is found with given id.
	 */
	EmployeeWorkDay update(EmployeeWorkDay employeeWorkDay) throws EntityNotFoundException;

    /**
	 * Deletes a EmployeeWorkDay.
	 *
	 * @param employeeWorkDayId The id of the deleted EmployeeWorkDay.
	 * @return The deleted EmployeeWorkDay.
     *
	 * @throws EntityNotFoundException if no EmployeeWorkDay is found with the given id.
	 */
	EmployeeWorkDay delete(Integer employeeWorkDayId) throws EntityNotFoundException;

	/**
	 * Finds all EmployeeWorkDays.
	 *
	 * @return A list of EmployeeWorkDays.
	 */
    @Deprecated
	Page<EmployeeWorkDay> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all EmployeeWorkDays.
	 * @return A list of EmployeeWorkDays.
	 */
    Page<EmployeeWorkDay> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the EmployeeWorkDays in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the EmployeeWorkDay.
	 */
	long count(String query);

    Page<EmployeeWorkDay> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


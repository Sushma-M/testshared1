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

import com.testshared1.testdb_26may.ListCommissionEmployee;

/**
 * Service object for domain model class ListCommissionEmployee.
 *
 * @see {@link ListCommissionEmployee}
 */
public interface ListCommissionEmployeeService {

    /**
     * Creates a new ListCommissionEmployee.
     *
     * @param listCommissionEmployee The information of the created CompositeTable.
     * @return The created ListCommissionEmployee.
     */
	ListCommissionEmployee create(ListCommissionEmployee listCommissionEmployee);


	/**
	 * Finds ListCommissionEmployee by id.
	 *
	 * @param listCommissionEmployeeId The id of the wanted ListCommissionEmployee.
	 * @return The found ListCommissionEmployee. If no ListCommissionEmployee is found, this method returns null.
	 */
	ListCommissionEmployee getById(Integer listCommissionEmployeeId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ListCommissionEmployee.
	 *
	 * @param listCommissionEmployee The information of the updated ListCommissionEmployee.
	 * @return The updated ListCommissionEmployee.
     *
	 * @throws EntityNotFoundException if no ListCommissionEmployee is found with given id.
	 */
	ListCommissionEmployee update(ListCommissionEmployee listCommissionEmployee) throws EntityNotFoundException;

    /**
	 * Deletes a ListCommissionEmployee.
	 *
	 * @param listCommissionEmployeeId The id of the deleted ListCommissionEmployee.
	 * @return The deleted ListCommissionEmployee.
     *
	 * @throws EntityNotFoundException if no ListCommissionEmployee is found with the given id.
	 */
	ListCommissionEmployee delete(Integer listCommissionEmployeeId) throws EntityNotFoundException;

	/**
	 * Finds all ListCommissionEmployees.
	 *
	 * @return A list of ListCommissionEmployees.
	 */
    @Deprecated
	Page<ListCommissionEmployee> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ListCommissionEmployees.
	 * @return A list of ListCommissionEmployees.
	 */
    Page<ListCommissionEmployee> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ListCommissionEmployees in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ListCommissionEmployee.
	 */
	long count(String query);

    Page<ListCommissionEmployee> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

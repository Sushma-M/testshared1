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

import com.testshared1.testdb_26may.ListCommissionPayroll;

/**
 * Service object for domain model class ListCommissionPayroll.
 *
 * @see {@link ListCommissionPayroll}
 */
public interface ListCommissionPayrollService {

    /**
     * Creates a new ListCommissionPayroll.
     *
     * @param listCommissionPayroll The information of the created CompositeTable.
     * @return The created ListCommissionPayroll.
     */
	ListCommissionPayroll create(ListCommissionPayroll listCommissionPayroll);


	/**
	 * Finds ListCommissionPayroll by id.
	 *
	 * @param listCommissionPayrollId The id of the wanted ListCommissionPayroll.
	 * @return The found ListCommissionPayroll. If no ListCommissionPayroll is found, this method returns null.
	 */
	ListCommissionPayroll getById(Integer listCommissionPayrollId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ListCommissionPayroll.
	 *
	 * @param listCommissionPayroll The information of the updated ListCommissionPayroll.
	 * @return The updated ListCommissionPayroll.
     *
	 * @throws EntityNotFoundException if no ListCommissionPayroll is found with given id.
	 */
	ListCommissionPayroll update(ListCommissionPayroll listCommissionPayroll) throws EntityNotFoundException;

    /**
	 * Deletes a ListCommissionPayroll.
	 *
	 * @param listCommissionPayrollId The id of the deleted ListCommissionPayroll.
	 * @return The deleted ListCommissionPayroll.
     *
	 * @throws EntityNotFoundException if no ListCommissionPayroll is found with the given id.
	 */
	ListCommissionPayroll delete(Integer listCommissionPayrollId) throws EntityNotFoundException;

	/**
	 * Finds all ListCommissionPayrolls.
	 *
	 * @return A list of ListCommissionPayrolls.
	 */
    @Deprecated
	Page<ListCommissionPayroll> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ListCommissionPayrolls.
	 * @return A list of ListCommissionPayrolls.
	 */
    Page<ListCommissionPayroll> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ListCommissionPayrolls in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ListCommissionPayroll.
	 */
	long count(String query);

    Page<ListCommissionPayroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

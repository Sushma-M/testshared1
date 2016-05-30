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

import com.testshared1.testdb_26may.ListCelphoneDetailPayroll;

/**
 * Service object for domain model class ListCelphoneDetailPayroll.
 *
 * @see {@link ListCelphoneDetailPayroll}
 */
public interface ListCelphoneDetailPayrollService {

    /**
     * Creates a new ListCelphoneDetailPayroll.
     *
     * @param listCelphoneDetailPayroll The information of the created CompositeTable.
     * @return The created ListCelphoneDetailPayroll.
     */
	ListCelphoneDetailPayroll create(ListCelphoneDetailPayroll listCelphoneDetailPayroll);


	/**
	 * Finds ListCelphoneDetailPayroll by id.
	 *
	 * @param listCelphoneDetailPayrollId The id of the wanted ListCelphoneDetailPayroll.
	 * @return The found ListCelphoneDetailPayroll. If no ListCelphoneDetailPayroll is found, this method returns null.
	 */
	ListCelphoneDetailPayroll getById(Integer listCelphoneDetailPayrollId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ListCelphoneDetailPayroll.
	 *
	 * @param listCelphoneDetailPayroll The information of the updated ListCelphoneDetailPayroll.
	 * @return The updated ListCelphoneDetailPayroll.
     *
	 * @throws EntityNotFoundException if no ListCelphoneDetailPayroll is found with given id.
	 */
	ListCelphoneDetailPayroll update(ListCelphoneDetailPayroll listCelphoneDetailPayroll) throws EntityNotFoundException;

    /**
	 * Deletes a ListCelphoneDetailPayroll.
	 *
	 * @param listCelphoneDetailPayrollId The id of the deleted ListCelphoneDetailPayroll.
	 * @return The deleted ListCelphoneDetailPayroll.
     *
	 * @throws EntityNotFoundException if no ListCelphoneDetailPayroll is found with the given id.
	 */
	ListCelphoneDetailPayroll delete(Integer listCelphoneDetailPayrollId) throws EntityNotFoundException;

	/**
	 * Finds all ListCelphoneDetailPayrolls.
	 *
	 * @return A list of ListCelphoneDetailPayrolls.
	 */
    @Deprecated
	Page<ListCelphoneDetailPayroll> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ListCelphoneDetailPayrolls.
	 * @return A list of ListCelphoneDetailPayrolls.
	 */
    Page<ListCelphoneDetailPayroll> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ListCelphoneDetailPayrolls in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ListCelphoneDetailPayroll.
	 */
	long count(String query);

    Page<ListCelphoneDetailPayroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


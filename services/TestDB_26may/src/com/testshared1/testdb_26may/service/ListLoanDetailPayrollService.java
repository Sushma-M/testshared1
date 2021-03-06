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

import com.testshared1.testdb_26may.ListLoanDetailPayroll;

/**
 * Service object for domain model class ListLoanDetailPayroll.
 *
 * @see {@link ListLoanDetailPayroll}
 */
public interface ListLoanDetailPayrollService {

    /**
     * Creates a new ListLoanDetailPayroll.
     *
     * @param listLoanDetailPayroll The information of the created CompositeTable.
     * @return The created ListLoanDetailPayroll.
     */
	ListLoanDetailPayroll create(ListLoanDetailPayroll listLoanDetailPayroll);


	/**
	 * Finds ListLoanDetailPayroll by id.
	 *
	 * @param listLoanDetailPayrollId The id of the wanted ListLoanDetailPayroll.
	 * @return The found ListLoanDetailPayroll. If no ListLoanDetailPayroll is found, this method returns null.
	 */
	ListLoanDetailPayroll getById(Integer listLoanDetailPayrollId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ListLoanDetailPayroll.
	 *
	 * @param listLoanDetailPayroll The information of the updated ListLoanDetailPayroll.
	 * @return The updated ListLoanDetailPayroll.
     *
	 * @throws EntityNotFoundException if no ListLoanDetailPayroll is found with given id.
	 */
	ListLoanDetailPayroll update(ListLoanDetailPayroll listLoanDetailPayroll) throws EntityNotFoundException;

    /**
	 * Deletes a ListLoanDetailPayroll.
	 *
	 * @param listLoanDetailPayrollId The id of the deleted ListLoanDetailPayroll.
	 * @return The deleted ListLoanDetailPayroll.
     *
	 * @throws EntityNotFoundException if no ListLoanDetailPayroll is found with the given id.
	 */
	ListLoanDetailPayroll delete(Integer listLoanDetailPayrollId) throws EntityNotFoundException;

	/**
	 * Finds all ListLoanDetailPayrolls.
	 *
	 * @return A list of ListLoanDetailPayrolls.
	 */
    @Deprecated
	Page<ListLoanDetailPayroll> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ListLoanDetailPayrolls.
	 * @return A list of ListLoanDetailPayrolls.
	 */
    Page<ListLoanDetailPayroll> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ListLoanDetailPayrolls in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ListLoanDetailPayroll.
	 */
	long count(String query);

    Page<ListLoanDetailPayroll> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


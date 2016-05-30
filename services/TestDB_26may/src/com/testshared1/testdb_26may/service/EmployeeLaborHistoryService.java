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

import com.testshared1.testdb_26may.EmployeeLaborHistory;

/**
 * Service object for domain model class EmployeeLaborHistory.
 *
 * @see {@link EmployeeLaborHistory}
 */
public interface EmployeeLaborHistoryService {

    /**
     * Creates a new EmployeeLaborHistory.
     *
     * @param employeeLaborHistory The information of the created CompositeTable.
     * @return The created EmployeeLaborHistory.
     */
	EmployeeLaborHistory create(EmployeeLaborHistory employeeLaborHistory);


	/**
	 * Finds EmployeeLaborHistory by id.
	 *
	 * @param employeeLaborHistoryId The id of the wanted EmployeeLaborHistory.
	 * @return The found EmployeeLaborHistory. If no EmployeeLaborHistory is found, this method returns null.
	 */
	EmployeeLaborHistory getById(Integer employeeLaborHistoryId) throws EntityNotFoundException;

	/**
	 * Updates the information of a EmployeeLaborHistory.
	 *
	 * @param employeeLaborHistory The information of the updated EmployeeLaborHistory.
	 * @return The updated EmployeeLaborHistory.
     *
	 * @throws EntityNotFoundException if no EmployeeLaborHistory is found with given id.
	 */
	EmployeeLaborHistory update(EmployeeLaborHistory employeeLaborHistory) throws EntityNotFoundException;

    /**
	 * Deletes a EmployeeLaborHistory.
	 *
	 * @param employeeLaborHistoryId The id of the deleted EmployeeLaborHistory.
	 * @return The deleted EmployeeLaborHistory.
     *
	 * @throws EntityNotFoundException if no EmployeeLaborHistory is found with the given id.
	 */
	EmployeeLaborHistory delete(Integer employeeLaborHistoryId) throws EntityNotFoundException;

	/**
	 * Finds all EmployeeLaborHistories.
	 *
	 * @return A list of EmployeeLaborHistories.
	 */
    @Deprecated
	Page<EmployeeLaborHistory> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all EmployeeLaborHistories.
	 * @return A list of EmployeeLaborHistories.
	 */
    Page<EmployeeLaborHistory> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the EmployeeLaborHistories in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the EmployeeLaborHistory.
	 */
	long count(String query);

    Page<EmployeeLaborHistory> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


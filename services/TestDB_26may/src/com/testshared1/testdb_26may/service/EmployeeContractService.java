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

import com.testshared1.testdb_26may.EmployeeContract;

/**
 * Service object for domain model class EmployeeContract.
 *
 * @see {@link EmployeeContract}
 */
public interface EmployeeContractService {

    /**
     * Creates a new EmployeeContract.
     *
     * @param employeeContract The information of the created CompositeTable.
     * @return The created EmployeeContract.
     */
	EmployeeContract create(EmployeeContract employeeContract);


	/**
	 * Finds EmployeeContract by id.
	 *
	 * @param employeeContractId The id of the wanted EmployeeContract.
	 * @return The found EmployeeContract. If no EmployeeContract is found, this method returns null.
	 */
	EmployeeContract getById(Integer employeeContractId) throws EntityNotFoundException;

	/**
	 * Updates the information of a EmployeeContract.
	 *
	 * @param employeeContract The information of the updated EmployeeContract.
	 * @return The updated EmployeeContract.
     *
	 * @throws EntityNotFoundException if no EmployeeContract is found with given id.
	 */
	EmployeeContract update(EmployeeContract employeeContract) throws EntityNotFoundException;

    /**
	 * Deletes a EmployeeContract.
	 *
	 * @param employeeContractId The id of the deleted EmployeeContract.
	 * @return The deleted EmployeeContract.
     *
	 * @throws EntityNotFoundException if no EmployeeContract is found with the given id.
	 */
	EmployeeContract delete(Integer employeeContractId) throws EntityNotFoundException;

	/**
	 * Finds all EmployeeContracts.
	 *
	 * @return A list of EmployeeContracts.
	 */
    @Deprecated
	Page<EmployeeContract> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all EmployeeContracts.
	 * @return A list of EmployeeContracts.
	 */
    Page<EmployeeContract> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the EmployeeContracts in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the EmployeeContract.
	 */
	long count(String query);

    Page<EmployeeContract> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


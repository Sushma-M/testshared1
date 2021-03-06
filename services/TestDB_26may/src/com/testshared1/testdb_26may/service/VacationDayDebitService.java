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

import com.testshared1.testdb_26may.VacationDayDebit;

/**
 * Service object for domain model class VacationDayDebit.
 *
 * @see {@link VacationDayDebit}
 */
public interface VacationDayDebitService {

    /**
     * Creates a new VacationDayDebit.
     *
     * @param vacationDayDebit The information of the created CompositeTable.
     * @return The created VacationDayDebit.
     */
	VacationDayDebit create(VacationDayDebit vacationDayDebit);


	/**
	 * Finds VacationDayDebit by id.
	 *
	 * @param vacationDayDebitId The id of the wanted VacationDayDebit.
	 * @return The found VacationDayDebit. If no VacationDayDebit is found, this method returns null.
	 */
	VacationDayDebit getById(Integer vacationDayDebitId) throws EntityNotFoundException;

	/**
	 * Updates the information of a VacationDayDebit.
	 *
	 * @param vacationDayDebit The information of the updated VacationDayDebit.
	 * @return The updated VacationDayDebit.
     *
	 * @throws EntityNotFoundException if no VacationDayDebit is found with given id.
	 */
	VacationDayDebit update(VacationDayDebit vacationDayDebit) throws EntityNotFoundException;

    /**
	 * Deletes a VacationDayDebit.
	 *
	 * @param vacationDayDebitId The id of the deleted VacationDayDebit.
	 * @return The deleted VacationDayDebit.
     *
	 * @throws EntityNotFoundException if no VacationDayDebit is found with the given id.
	 */
	VacationDayDebit delete(Integer vacationDayDebitId) throws EntityNotFoundException;

	/**
	 * Finds all VacationDayDebits.
	 *
	 * @return A list of VacationDayDebits.
	 */
    @Deprecated
	Page<VacationDayDebit> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all VacationDayDebits.
	 * @return A list of VacationDayDebits.
	 */
    Page<VacationDayDebit> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the VacationDayDebits in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the VacationDayDebit.
	 */
	long count(String query);

    Page<VacationDayDebit> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


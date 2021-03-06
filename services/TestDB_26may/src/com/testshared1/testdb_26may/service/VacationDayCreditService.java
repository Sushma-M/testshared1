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

import com.testshared1.testdb_26may.VacationDayCredit;

/**
 * Service object for domain model class VacationDayCredit.
 *
 * @see {@link VacationDayCredit}
 */
public interface VacationDayCreditService {

    /**
     * Creates a new VacationDayCredit.
     *
     * @param vacationDayCredit The information of the created CompositeTable.
     * @return The created VacationDayCredit.
     */
	VacationDayCredit create(VacationDayCredit vacationDayCredit);


	/**
	 * Finds VacationDayCredit by id.
	 *
	 * @param vacationDayCreditId The id of the wanted VacationDayCredit.
	 * @return The found VacationDayCredit. If no VacationDayCredit is found, this method returns null.
	 */
	VacationDayCredit getById(Integer vacationDayCreditId) throws EntityNotFoundException;

	/**
	 * Updates the information of a VacationDayCredit.
	 *
	 * @param vacationDayCredit The information of the updated VacationDayCredit.
	 * @return The updated VacationDayCredit.
     *
	 * @throws EntityNotFoundException if no VacationDayCredit is found with given id.
	 */
	VacationDayCredit update(VacationDayCredit vacationDayCredit) throws EntityNotFoundException;

    /**
	 * Deletes a VacationDayCredit.
	 *
	 * @param vacationDayCreditId The id of the deleted VacationDayCredit.
	 * @return The deleted VacationDayCredit.
     *
	 * @throws EntityNotFoundException if no VacationDayCredit is found with the given id.
	 */
	VacationDayCredit delete(Integer vacationDayCreditId) throws EntityNotFoundException;

	/**
	 * Finds all VacationDayCredits.
	 *
	 * @return A list of VacationDayCredits.
	 */
    @Deprecated
	Page<VacationDayCredit> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all VacationDayCredits.
	 * @return A list of VacationDayCredits.
	 */
    Page<VacationDayCredit> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the VacationDayCredits in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the VacationDayCredit.
	 */
	long count(String query);

    Page<VacationDayCredit> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


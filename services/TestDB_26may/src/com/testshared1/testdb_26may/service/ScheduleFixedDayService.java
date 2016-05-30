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

import com.testshared1.testdb_26may.ScheduleFixedDay;

/**
 * Service object for domain model class ScheduleFixedDay.
 *
 * @see {@link ScheduleFixedDay}
 */
public interface ScheduleFixedDayService {

    /**
     * Creates a new ScheduleFixedDay.
     *
     * @param scheduleFixedDay The information of the created CompositeTable.
     * @return The created ScheduleFixedDay.
     */
	ScheduleFixedDay create(ScheduleFixedDay scheduleFixedDay);


	/**
	 * Finds ScheduleFixedDay by id.
	 *
	 * @param scheduleFixedDayId The id of the wanted ScheduleFixedDay.
	 * @return The found ScheduleFixedDay. If no ScheduleFixedDay is found, this method returns null.
	 */
	ScheduleFixedDay getById(Integer scheduleFixedDayId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ScheduleFixedDay.
	 *
	 * @param scheduleFixedDay The information of the updated ScheduleFixedDay.
	 * @return The updated ScheduleFixedDay.
     *
	 * @throws EntityNotFoundException if no ScheduleFixedDay is found with given id.
	 */
	ScheduleFixedDay update(ScheduleFixedDay scheduleFixedDay) throws EntityNotFoundException;

    /**
	 * Deletes a ScheduleFixedDay.
	 *
	 * @param scheduleFixedDayId The id of the deleted ScheduleFixedDay.
	 * @return The deleted ScheduleFixedDay.
     *
	 * @throws EntityNotFoundException if no ScheduleFixedDay is found with the given id.
	 */
	ScheduleFixedDay delete(Integer scheduleFixedDayId) throws EntityNotFoundException;

	/**
	 * Finds all ScheduleFixedDays.
	 *
	 * @return A list of ScheduleFixedDays.
	 */
    @Deprecated
	Page<ScheduleFixedDay> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ScheduleFixedDays.
	 * @return A list of ScheduleFixedDays.
	 */
    Page<ScheduleFixedDay> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ScheduleFixedDays in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ScheduleFixedDay.
	 */
	long count(String query);

    Page<ScheduleFixedDay> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


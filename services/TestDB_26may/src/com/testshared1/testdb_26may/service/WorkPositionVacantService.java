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

import com.testshared1.testdb_26may.WorkPositionVacant;

/**
 * Service object for domain model class WorkPositionVacant.
 *
 * @see {@link WorkPositionVacant}
 */
public interface WorkPositionVacantService {

    /**
     * Creates a new WorkPositionVacant.
     *
     * @param workPositionVacant The information of the created CompositeTable.
     * @return The created WorkPositionVacant.
     */
	WorkPositionVacant create(WorkPositionVacant workPositionVacant);


	/**
	 * Finds WorkPositionVacant by id.
	 *
	 * @param workPositionVacantId The id of the wanted WorkPositionVacant.
	 * @return The found WorkPositionVacant. If no WorkPositionVacant is found, this method returns null.
	 */
	WorkPositionVacant getById(Integer workPositionVacantId) throws EntityNotFoundException;

	/**
	 * Updates the information of a WorkPositionVacant.
	 *
	 * @param workPositionVacant The information of the updated WorkPositionVacant.
	 * @return The updated WorkPositionVacant.
     *
	 * @throws EntityNotFoundException if no WorkPositionVacant is found with given id.
	 */
	WorkPositionVacant update(WorkPositionVacant workPositionVacant) throws EntityNotFoundException;

    /**
	 * Deletes a WorkPositionVacant.
	 *
	 * @param workPositionVacantId The id of the deleted WorkPositionVacant.
	 * @return The deleted WorkPositionVacant.
     *
	 * @throws EntityNotFoundException if no WorkPositionVacant is found with the given id.
	 */
	WorkPositionVacant delete(Integer workPositionVacantId) throws EntityNotFoundException;

	/**
	 * Finds all WorkPositionVacants.
	 *
	 * @return A list of WorkPositionVacants.
	 */
    @Deprecated
	Page<WorkPositionVacant> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all WorkPositionVacants.
	 * @return A list of WorkPositionVacants.
	 */
    Page<WorkPositionVacant> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the WorkPositionVacants in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the WorkPositionVacant.
	 */
	long count(String query);

    Page<WorkPositionVacant> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

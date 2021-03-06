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

import com.testshared1.testdb_26may.WorkPositionRequiement;

/**
 * Service object for domain model class WorkPositionRequiement.
 *
 * @see {@link WorkPositionRequiement}
 */
public interface WorkPositionRequiementService {

    /**
     * Creates a new WorkPositionRequiement.
     *
     * @param workPositionRequiement The information of the created CompositeTable.
     * @return The created WorkPositionRequiement.
     */
	WorkPositionRequiement create(WorkPositionRequiement workPositionRequiement);


	/**
	 * Finds WorkPositionRequiement by id.
	 *
	 * @param workPositionRequiementId The id of the wanted WorkPositionRequiement.
	 * @return The found WorkPositionRequiement. If no WorkPositionRequiement is found, this method returns null.
	 */
	WorkPositionRequiement getById(Integer workPositionRequiementId) throws EntityNotFoundException;

	/**
	 * Updates the information of a WorkPositionRequiement.
	 *
	 * @param workPositionRequiement The information of the updated WorkPositionRequiement.
	 * @return The updated WorkPositionRequiement.
     *
	 * @throws EntityNotFoundException if no WorkPositionRequiement is found with given id.
	 */
	WorkPositionRequiement update(WorkPositionRequiement workPositionRequiement) throws EntityNotFoundException;

    /**
	 * Deletes a WorkPositionRequiement.
	 *
	 * @param workPositionRequiementId The id of the deleted WorkPositionRequiement.
	 * @return The deleted WorkPositionRequiement.
     *
	 * @throws EntityNotFoundException if no WorkPositionRequiement is found with the given id.
	 */
	WorkPositionRequiement delete(Integer workPositionRequiementId) throws EntityNotFoundException;

	/**
	 * Finds all WorkPositionRequiements.
	 *
	 * @return A list of WorkPositionRequiements.
	 */
    @Deprecated
	Page<WorkPositionRequiement> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all WorkPositionRequiements.
	 * @return A list of WorkPositionRequiements.
	 */
    Page<WorkPositionRequiement> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the WorkPositionRequiements in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the WorkPositionRequiement.
	 */
	long count(String query);

    Page<WorkPositionRequiement> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


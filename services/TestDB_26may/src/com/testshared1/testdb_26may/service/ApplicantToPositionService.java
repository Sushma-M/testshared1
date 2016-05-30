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

import com.testshared1.testdb_26may.ApplicantToPosition;

/**
 * Service object for domain model class ApplicantToPosition.
 *
 * @see {@link ApplicantToPosition}
 */
public interface ApplicantToPositionService {

    /**
     * Creates a new ApplicantToPosition.
     *
     * @param applicantToPosition The information of the created CompositeTable.
     * @return The created ApplicantToPosition.
     */
	ApplicantToPosition create(ApplicantToPosition applicantToPosition);


	/**
	 * Finds ApplicantToPosition by id.
	 *
	 * @param applicantToPositionId The id of the wanted ApplicantToPosition.
	 * @return The found ApplicantToPosition. If no ApplicantToPosition is found, this method returns null.
	 */
	ApplicantToPosition getById(Integer applicantToPositionId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ApplicantToPosition.
	 *
	 * @param applicantToPosition The information of the updated ApplicantToPosition.
	 * @return The updated ApplicantToPosition.
     *
	 * @throws EntityNotFoundException if no ApplicantToPosition is found with given id.
	 */
	ApplicantToPosition update(ApplicantToPosition applicantToPosition) throws EntityNotFoundException;

    /**
	 * Deletes a ApplicantToPosition.
	 *
	 * @param applicantToPositionId The id of the deleted ApplicantToPosition.
	 * @return The deleted ApplicantToPosition.
     *
	 * @throws EntityNotFoundException if no ApplicantToPosition is found with the given id.
	 */
	ApplicantToPosition delete(Integer applicantToPositionId) throws EntityNotFoundException;

	/**
	 * Finds all ApplicantToPositions.
	 *
	 * @return A list of ApplicantToPositions.
	 */
    @Deprecated
	Page<ApplicantToPosition> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ApplicantToPositions.
	 * @return A list of ApplicantToPositions.
	 */
    Page<ApplicantToPosition> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ApplicantToPositions in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ApplicantToPosition.
	 */
	long count(String query);

    Page<ApplicantToPosition> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


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

import com.testshared1.testdb_26may.JustifiedAbsense;

/**
 * Service object for domain model class JustifiedAbsense.
 *
 * @see {@link JustifiedAbsense}
 */
public interface JustifiedAbsenseService {

    /**
     * Creates a new JustifiedAbsense.
     *
     * @param justifiedAbsense The information of the created CompositeTable.
     * @return The created JustifiedAbsense.
     */
	JustifiedAbsense create(JustifiedAbsense justifiedAbsense);


	/**
	 * Finds JustifiedAbsense by id.
	 *
	 * @param justifiedAbsenseId The id of the wanted JustifiedAbsense.
	 * @return The found JustifiedAbsense. If no JustifiedAbsense is found, this method returns null.
	 */
	JustifiedAbsense getById(Integer justifiedAbsenseId) throws EntityNotFoundException;

	/**
	 * Updates the information of a JustifiedAbsense.
	 *
	 * @param justifiedAbsense The information of the updated JustifiedAbsense.
	 * @return The updated JustifiedAbsense.
     *
	 * @throws EntityNotFoundException if no JustifiedAbsense is found with given id.
	 */
	JustifiedAbsense update(JustifiedAbsense justifiedAbsense) throws EntityNotFoundException;

    /**
	 * Deletes a JustifiedAbsense.
	 *
	 * @param justifiedAbsenseId The id of the deleted JustifiedAbsense.
	 * @return The deleted JustifiedAbsense.
     *
	 * @throws EntityNotFoundException if no JustifiedAbsense is found with the given id.
	 */
	JustifiedAbsense delete(Integer justifiedAbsenseId) throws EntityNotFoundException;

	/**
	 * Finds all JustifiedAbsenses.
	 *
	 * @return A list of JustifiedAbsenses.
	 */
    @Deprecated
	Page<JustifiedAbsense> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all JustifiedAbsenses.
	 * @return A list of JustifiedAbsenses.
	 */
    Page<JustifiedAbsense> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the JustifiedAbsenses in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the JustifiedAbsense.
	 */
	long count(String query);

    Page<JustifiedAbsense> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

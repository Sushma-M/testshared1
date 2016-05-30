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

import com.testshared1.testdb_26may.JustifiedLeaveFile;

/**
 * Service object for domain model class JustifiedLeaveFile.
 *
 * @see {@link JustifiedLeaveFile}
 */
public interface JustifiedLeaveFileService {

    /**
     * Creates a new JustifiedLeaveFile.
     *
     * @param justifiedLeaveFile The information of the created CompositeTable.
     * @return The created JustifiedLeaveFile.
     */
	JustifiedLeaveFile create(JustifiedLeaveFile justifiedLeaveFile);


	/**
	 * Finds JustifiedLeaveFile by id.
	 *
	 * @param justifiedLeaveFileId The id of the wanted JustifiedLeaveFile.
	 * @return The found JustifiedLeaveFile. If no JustifiedLeaveFile is found, this method returns null.
	 */
	JustifiedLeaveFile getById(Integer justifiedLeaveFileId) throws EntityNotFoundException;

	/**
	 * Updates the information of a JustifiedLeaveFile.
	 *
	 * @param justifiedLeaveFile The information of the updated JustifiedLeaveFile.
	 * @return The updated JustifiedLeaveFile.
     *
	 * @throws EntityNotFoundException if no JustifiedLeaveFile is found with given id.
	 */
	JustifiedLeaveFile update(JustifiedLeaveFile justifiedLeaveFile) throws EntityNotFoundException;

    /**
	 * Deletes a JustifiedLeaveFile.
	 *
	 * @param justifiedLeaveFileId The id of the deleted JustifiedLeaveFile.
	 * @return The deleted JustifiedLeaveFile.
     *
	 * @throws EntityNotFoundException if no JustifiedLeaveFile is found with the given id.
	 */
	JustifiedLeaveFile delete(Integer justifiedLeaveFileId) throws EntityNotFoundException;

	/**
	 * Finds all JustifiedLeaveFiles.
	 *
	 * @return A list of JustifiedLeaveFiles.
	 */
    @Deprecated
	Page<JustifiedLeaveFile> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all JustifiedLeaveFiles.
	 * @return A list of JustifiedLeaveFiles.
	 */
    Page<JustifiedLeaveFile> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the JustifiedLeaveFiles in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the JustifiedLeaveFile.
	 */
	long count(String query);

    Page<JustifiedLeaveFile> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

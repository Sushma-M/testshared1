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

import com.testshared1.testdb_26may.TypeAnnouncement;

/**
 * Service object for domain model class TypeAnnouncement.
 *
 * @see {@link TypeAnnouncement}
 */
public interface TypeAnnouncementService {

    /**
     * Creates a new TypeAnnouncement.
     *
     * @param typeAnnouncement The information of the created CompositeTable.
     * @return The created TypeAnnouncement.
     */
	TypeAnnouncement create(TypeAnnouncement typeAnnouncement);


	/**
	 * Finds TypeAnnouncement by id.
	 *
	 * @param typeAnnouncementId The id of the wanted TypeAnnouncement.
	 * @return The found TypeAnnouncement. If no TypeAnnouncement is found, this method returns null.
	 */
	TypeAnnouncement getById(Integer typeAnnouncementId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TypeAnnouncement.
	 *
	 * @param typeAnnouncement The information of the updated TypeAnnouncement.
	 * @return The updated TypeAnnouncement.
     *
	 * @throws EntityNotFoundException if no TypeAnnouncement is found with given id.
	 */
	TypeAnnouncement update(TypeAnnouncement typeAnnouncement) throws EntityNotFoundException;

    /**
	 * Deletes a TypeAnnouncement.
	 *
	 * @param typeAnnouncementId The id of the deleted TypeAnnouncement.
	 * @return The deleted TypeAnnouncement.
     *
	 * @throws EntityNotFoundException if no TypeAnnouncement is found with the given id.
	 */
	TypeAnnouncement delete(Integer typeAnnouncementId) throws EntityNotFoundException;

	/**
	 * Finds all TypeAnnouncements.
	 *
	 * @return A list of TypeAnnouncements.
	 */
    @Deprecated
	Page<TypeAnnouncement> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TypeAnnouncements.
	 * @return A list of TypeAnnouncements.
	 */
    Page<TypeAnnouncement> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TypeAnnouncements in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TypeAnnouncement.
	 */
	long count(String query);

    Page<TypeAnnouncement> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

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

import com.testshared1.testdb_26may.Announcement;

/**
 * Service object for domain model class Announcement.
 *
 * @see {@link Announcement}
 */
public interface AnnouncementService {

    /**
     * Creates a new Announcement.
     *
     * @param announcement The information of the created CompositeTable.
     * @return The created Announcement.
     */
	Announcement create(Announcement announcement);


	/**
	 * Finds Announcement by id.
	 *
	 * @param announcementId The id of the wanted Announcement.
	 * @return The found Announcement. If no Announcement is found, this method returns null.
	 */
	Announcement getById(Integer announcementId) throws EntityNotFoundException;

	/**
	 * Updates the information of a Announcement.
	 *
	 * @param announcement The information of the updated Announcement.
	 * @return The updated Announcement.
     *
	 * @throws EntityNotFoundException if no Announcement is found with given id.
	 */
	Announcement update(Announcement announcement) throws EntityNotFoundException;

    /**
	 * Deletes a Announcement.
	 *
	 * @param announcementId The id of the deleted Announcement.
	 * @return The deleted Announcement.
     *
	 * @throws EntityNotFoundException if no Announcement is found with the given id.
	 */
	Announcement delete(Integer announcementId) throws EntityNotFoundException;

	/**
	 * Finds all Announcements.
	 *
	 * @return A list of Announcements.
	 */
    @Deprecated
	Page<Announcement> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Announcements.
	 * @return A list of Announcements.
	 */
    Page<Announcement> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Announcements in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Announcement.
	 */
	long count(String query);

    Page<Announcement> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


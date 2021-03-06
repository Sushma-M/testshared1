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

import com.testshared1.testdb_26may.Location;

/**
 * Service object for domain model class Location.
 *
 * @see {@link Location}
 */
public interface LocationService {

    /**
     * Creates a new Location.
     *
     * @param location The information of the created CompositeTable.
     * @return The created Location.
     */
	Location create(Location location);


	/**
	 * Finds Location by id.
	 *
	 * @param locationId The id of the wanted Location.
	 * @return The found Location. If no Location is found, this method returns null.
	 */
	Location getById(Integer locationId) throws EntityNotFoundException;

	/**
	 * Updates the information of a Location.
	 *
	 * @param location The information of the updated Location.
	 * @return The updated Location.
     *
	 * @throws EntityNotFoundException if no Location is found with given id.
	 */
	Location update(Location location) throws EntityNotFoundException;

    /**
	 * Deletes a Location.
	 *
	 * @param locationId The id of the deleted Location.
	 * @return The deleted Location.
     *
	 * @throws EntityNotFoundException if no Location is found with the given id.
	 */
	Location delete(Integer locationId) throws EntityNotFoundException;

	/**
	 * Finds all Locations.
	 *
	 * @return A list of Locations.
	 */
    @Deprecated
	Page<Location> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Locations.
	 * @return A list of Locations.
	 */
    Page<Location> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Locations in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Location.
	 */
	long count(String query);

    Page<Location> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


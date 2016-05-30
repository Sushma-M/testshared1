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

import com.testshared1.testdb_26may.ListAssetUnloaded;

/**
 * Service object for domain model class ListAssetUnloaded.
 *
 * @see {@link ListAssetUnloaded}
 */
public interface ListAssetUnloadedService {

    /**
     * Creates a new ListAssetUnloaded.
     *
     * @param listAssetUnloaded The information of the created CompositeTable.
     * @return The created ListAssetUnloaded.
     */
	ListAssetUnloaded create(ListAssetUnloaded listAssetUnloaded);


	/**
	 * Finds ListAssetUnloaded by id.
	 *
	 * @param listAssetUnloadedId The id of the wanted ListAssetUnloaded.
	 * @return The found ListAssetUnloaded. If no ListAssetUnloaded is found, this method returns null.
	 */
	ListAssetUnloaded getById(Integer listAssetUnloadedId) throws EntityNotFoundException;

	/**
	 * Updates the information of a ListAssetUnloaded.
	 *
	 * @param listAssetUnloaded The information of the updated ListAssetUnloaded.
	 * @return The updated ListAssetUnloaded.
     *
	 * @throws EntityNotFoundException if no ListAssetUnloaded is found with given id.
	 */
	ListAssetUnloaded update(ListAssetUnloaded listAssetUnloaded) throws EntityNotFoundException;

    /**
	 * Deletes a ListAssetUnloaded.
	 *
	 * @param listAssetUnloadedId The id of the deleted ListAssetUnloaded.
	 * @return The deleted ListAssetUnloaded.
     *
	 * @throws EntityNotFoundException if no ListAssetUnloaded is found with the given id.
	 */
	ListAssetUnloaded delete(Integer listAssetUnloadedId) throws EntityNotFoundException;

	/**
	 * Finds all ListAssetUnloadeds.
	 *
	 * @return A list of ListAssetUnloadeds.
	 */
    @Deprecated
	Page<ListAssetUnloaded> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ListAssetUnloadeds.
	 * @return A list of ListAssetUnloadeds.
	 */
    Page<ListAssetUnloaded> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ListAssetUnloadeds in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ListAssetUnloaded.
	 */
	long count(String query);

    Page<ListAssetUnloaded> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


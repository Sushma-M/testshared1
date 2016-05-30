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

import com.testshared1.testdb_26may.TypeIncident;

/**
 * Service object for domain model class TypeIncident.
 *
 * @see {@link TypeIncident}
 */
public interface TypeIncidentService {

    /**
     * Creates a new TypeIncident.
     *
     * @param typeIncident The information of the created CompositeTable.
     * @return The created TypeIncident.
     */
	TypeIncident create(TypeIncident typeIncident);


	/**
	 * Finds TypeIncident by id.
	 *
	 * @param typeIncidentId The id of the wanted TypeIncident.
	 * @return The found TypeIncident. If no TypeIncident is found, this method returns null.
	 */
	TypeIncident getById(Integer typeIncidentId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TypeIncident.
	 *
	 * @param typeIncident The information of the updated TypeIncident.
	 * @return The updated TypeIncident.
     *
	 * @throws EntityNotFoundException if no TypeIncident is found with given id.
	 */
	TypeIncident update(TypeIncident typeIncident) throws EntityNotFoundException;

    /**
	 * Deletes a TypeIncident.
	 *
	 * @param typeIncidentId The id of the deleted TypeIncident.
	 * @return The deleted TypeIncident.
     *
	 * @throws EntityNotFoundException if no TypeIncident is found with the given id.
	 */
	TypeIncident delete(Integer typeIncidentId) throws EntityNotFoundException;

	/**
	 * Finds all TypeIncidents.
	 *
	 * @return A list of TypeIncidents.
	 */
    @Deprecated
	Page<TypeIncident> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TypeIncidents.
	 * @return A list of TypeIncidents.
	 */
    Page<TypeIncident> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TypeIncidents in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TypeIncident.
	 */
	long count(String query);

    Page<TypeIncident> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

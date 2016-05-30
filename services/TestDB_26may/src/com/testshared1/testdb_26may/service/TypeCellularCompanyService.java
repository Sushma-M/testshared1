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

import com.testshared1.testdb_26may.TypeCellularCompany;

/**
 * Service object for domain model class TypeCellularCompany.
 *
 * @see {@link TypeCellularCompany}
 */
public interface TypeCellularCompanyService {

    /**
     * Creates a new TypeCellularCompany.
     *
     * @param typeCellularCompany The information of the created CompositeTable.
     * @return The created TypeCellularCompany.
     */
	TypeCellularCompany create(TypeCellularCompany typeCellularCompany);


	/**
	 * Finds TypeCellularCompany by id.
	 *
	 * @param typeCellularCompanyId The id of the wanted TypeCellularCompany.
	 * @return The found TypeCellularCompany. If no TypeCellularCompany is found, this method returns null.
	 */
	TypeCellularCompany getById(Integer typeCellularCompanyId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TypeCellularCompany.
	 *
	 * @param typeCellularCompany The information of the updated TypeCellularCompany.
	 * @return The updated TypeCellularCompany.
     *
	 * @throws EntityNotFoundException if no TypeCellularCompany is found with given id.
	 */
	TypeCellularCompany update(TypeCellularCompany typeCellularCompany) throws EntityNotFoundException;

    /**
	 * Deletes a TypeCellularCompany.
	 *
	 * @param typeCellularCompanyId The id of the deleted TypeCellularCompany.
	 * @return The deleted TypeCellularCompany.
     *
	 * @throws EntityNotFoundException if no TypeCellularCompany is found with the given id.
	 */
	TypeCellularCompany delete(Integer typeCellularCompanyId) throws EntityNotFoundException;

	/**
	 * Finds all TypeCellularCompanies.
	 *
	 * @return A list of TypeCellularCompanies.
	 */
    @Deprecated
	Page<TypeCellularCompany> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TypeCellularCompanies.
	 * @return A list of TypeCellularCompanies.
	 */
    Page<TypeCellularCompany> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TypeCellularCompanies in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TypeCellularCompany.
	 */
	long count(String query);

    Page<TypeCellularCompany> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

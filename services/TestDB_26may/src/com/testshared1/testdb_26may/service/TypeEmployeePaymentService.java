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

import com.testshared1.testdb_26may.TypeEmployeePayment;

/**
 * Service object for domain model class TypeEmployeePayment.
 *
 * @see {@link TypeEmployeePayment}
 */
public interface TypeEmployeePaymentService {

    /**
     * Creates a new TypeEmployeePayment.
     *
     * @param typeEmployeePayment The information of the created CompositeTable.
     * @return The created TypeEmployeePayment.
     */
	TypeEmployeePayment create(TypeEmployeePayment typeEmployeePayment);


	/**
	 * Finds TypeEmployeePayment by id.
	 *
	 * @param typeEmployeePaymentId The id of the wanted TypeEmployeePayment.
	 * @return The found TypeEmployeePayment. If no TypeEmployeePayment is found, this method returns null.
	 */
	TypeEmployeePayment getById(Integer typeEmployeePaymentId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TypeEmployeePayment.
	 *
	 * @param typeEmployeePayment The information of the updated TypeEmployeePayment.
	 * @return The updated TypeEmployeePayment.
     *
	 * @throws EntityNotFoundException if no TypeEmployeePayment is found with given id.
	 */
	TypeEmployeePayment update(TypeEmployeePayment typeEmployeePayment) throws EntityNotFoundException;

    /**
	 * Deletes a TypeEmployeePayment.
	 *
	 * @param typeEmployeePaymentId The id of the deleted TypeEmployeePayment.
	 * @return The deleted TypeEmployeePayment.
     *
	 * @throws EntityNotFoundException if no TypeEmployeePayment is found with the given id.
	 */
	TypeEmployeePayment delete(Integer typeEmployeePaymentId) throws EntityNotFoundException;

	/**
	 * Finds all TypeEmployeePayments.
	 *
	 * @return A list of TypeEmployeePayments.
	 */
    @Deprecated
	Page<TypeEmployeePayment> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TypeEmployeePayments.
	 * @return A list of TypeEmployeePayments.
	 */
    Page<TypeEmployeePayment> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TypeEmployeePayments in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TypeEmployeePayment.
	 */
	long count(String query);

    Page<TypeEmployeePayment> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


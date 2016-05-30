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

import com.testshared1.testdb_26may.User;

/**
 * Service object for domain model class User.
 *
 * @see {@link User}
 */
public interface UserService {

    /**
     * Creates a new User.
     *
     * @param user The information of the created CompositeTable.
     * @return The created User.
     */
	User create(User user);


	/**
	 * Finds User by id.
	 *
	 * @param userId The id of the wanted User.
	 * @return The found User. If no User is found, this method returns null.
	 */
	User getById(Integer userId) throws EntityNotFoundException;

	/**
	 * Updates the information of a User.
	 *
	 * @param user The information of the updated User.
	 * @return The updated User.
     *
	 * @throws EntityNotFoundException if no User is found with given id.
	 */
	User update(User user) throws EntityNotFoundException;

    /**
	 * Deletes a User.
	 *
	 * @param userId The id of the deleted User.
	 * @return The deleted User.
     *
	 * @throws EntityNotFoundException if no User is found with the given id.
	 */
	User delete(Integer userId) throws EntityNotFoundException;

	/**
	 * Finds all Users.
	 *
	 * @return A list of Users.
	 */
    @Deprecated
	Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Users.
	 * @return A list of Users.
	 */
    Page<User> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Users in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the User.
	 */
	long count(String query);

    Page<User> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


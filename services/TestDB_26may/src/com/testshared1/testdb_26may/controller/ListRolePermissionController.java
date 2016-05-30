/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.testshared1.testdb_26may.ListRolePermission;
import com.testshared1.testdb_26may.service.ListRolePermissionService;


/**
 * Controller object for domain model class ListRolePermission.
 * @see ListRolePermission
 */
@RestController("TestDB_26may.ListRolePermissionController")
@Api(value = "/TestDB_26may/ListRolePermission", description = "Exposes APIs to work with ListRolePermission resource.")
@RequestMapping("/TestDB_26may/ListRolePermission")
public class ListRolePermissionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListRolePermissionController.class);

    @Autowired
	@Qualifier("TestDB_26may.ListRolePermissionService")
	private ListRolePermissionService listRolePermissionService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new ListRolePermission instance.")
	public ListRolePermission createListRolePermission(@RequestBody ListRolePermission listrolepermission) {
		LOGGER.debug("Create ListRolePermission with information: {}" , listrolepermission);

		listrolepermission = listRolePermissionService.create(listrolepermission);
		LOGGER.debug("Created ListRolePermission with information: {}" , listrolepermission);

	    return listrolepermission;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the ListRolePermission instance associated with the given id.")
    public ListRolePermission getListRolePermission(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ListRolePermission with id: {}" , id);

        ListRolePermission foundListRolePermission = listRolePermissionService.getById(id);
        LOGGER.debug("ListRolePermission details with id: {}" , foundListRolePermission);

        return foundListRolePermission;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the ListRolePermission instance associated with the given id.")
    public ListRolePermission editListRolePermission(@PathVariable("id") Integer id, @RequestBody ListRolePermission listrolepermission) throws EntityNotFoundException {
        LOGGER.debug("Editing ListRolePermission with id: {}" , listrolepermission.getIdListRolePermission());

        listrolepermission.setIdListRolePermission(id);
        listrolepermission = listRolePermissionService.update(listrolepermission);
        LOGGER.debug("ListRolePermission details with id: {}" , listrolepermission);

        return listrolepermission;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the ListRolePermission instance associated with the given id.")
    public boolean deleteListRolePermission(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListRolePermission with id: {}" , id);

        ListRolePermission deletedListRolePermission = listRolePermissionService.delete(id);

        return deletedListRolePermission != null;
    }
    /**
     * @deprecated Use {@link #findListRolePermissions(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of ListRolePermission instances matching the search criteria.")
	public Page<ListRolePermission> findListRolePermissions( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering ListRolePermissions list");
		return listRolePermissionService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ListRolePermission instances matching the search criteria.")
    public Page<ListRolePermission> findListRolePermissions(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ListRolePermissions list");
    	return listRolePermissionService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportListRolePermissions(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return listRolePermissionService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of ListRolePermission instances.")
	public Long countListRolePermissions(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ListRolePermissions");
		return listRolePermissionService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListRolePermissionService instance
	 */
	protected void setListRolePermissionService(ListRolePermissionService service) {
		this.listRolePermissionService = service;
	}

}


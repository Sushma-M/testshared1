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

import com.testshared1.testdb_26may.Table7;
import com.testshared1.testdb_26may.Table8;
import com.testshared1.testdb_26may.service.Table7Service;
import com.testshared1.testdb_26may.service.Table8Service;


/**
 * Controller object for domain model class Table8.
 * @see Table8
 */
@RestController("TestDB_26may.Table8Controller")
@Api(value = "/TestDB_26may/Table8", description = "Exposes APIs to work with Table8 resource.")
@RequestMapping("/TestDB_26may/Table8")
public class Table8Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table8Controller.class);

    @Autowired
	@Qualifier("TestDB_26may.Table8Service")
	private Table8Service table8Service;

    @Autowired
	@Qualifier("TestDB_26may.Table7Service")
	private Table7Service table7Service;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new Table8 instance.")
	public Table8 createTable8(@RequestBody Table8 table8) {
		LOGGER.debug("Create Table8 with information: {}" , table8);

		table8 = table8Service.create(table8);
		LOGGER.debug("Created Table8 with information: {}" , table8);

	    return table8;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Table8 instance associated with the given id.")
    public Table8 getTable8(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table8 with id: {}" , id);

        Table8 foundTable8 = table8Service.getById(id);
        LOGGER.debug("Table8 details with id: {}" , foundTable8);

        return foundTable8;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Table8 instance associated with the given id.")
    public Table8 editTable8(@PathVariable("id") String id, @RequestBody Table8 table8) throws EntityNotFoundException {
        LOGGER.debug("Editing Table8 with id: {}" , table8.getId());

        table8.setId(id);
        table8 = table8Service.update(table8);
        LOGGER.debug("Table8 details with id: {}" , table8);

        return table8;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Table8 instance associated with the given id.")
    public boolean deleteTable8(@PathVariable("id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table8 with id: {}" , id);

        Table8 deletedTable8 = table8Service.delete(id);

        return deletedTable8 != null;
    }
    /**
     * @deprecated Use {@link #findTable8s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of Table8 instances matching the search criteria.")
	public Page<Table8> findTable8s( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering Table8s list");
		return table8Service.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table8 instances matching the search criteria.")
    public Page<Table8> findTable8s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table8s list");
    	return table8Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable8s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table8Service.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of Table8 instances.")
	public Long countTable8s(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table8s");
		return table8Service.count(query);
	}

    @RequestMapping(value="/{id:.+}/table7s", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the table7s instance associated with the given id.")
     public Page<Table7>
        findAssociatedTable7s(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated table7s");
        return table7Service.findAssociatedValues(id, "Table7", "id", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table8Service instance
	 */
	protected void setTable8Service(Table8Service service) {
		this.table8Service = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table7Service instance
	 */
	protected void setTable7Service(Table7Service service) {
        this.table7Service = service;
    }
}

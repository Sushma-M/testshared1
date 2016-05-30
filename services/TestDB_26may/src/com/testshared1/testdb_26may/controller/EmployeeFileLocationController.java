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

import com.testshared1.testdb_26may.EmployeeFileLocation;
import com.testshared1.testdb_26may.service.EmployeeFileLocationService;


/**
 * Controller object for domain model class EmployeeFileLocation.
 * @see EmployeeFileLocation
 */
@RestController("TestDB_26may.EmployeeFileLocationController")
@Api(value = "/TestDB_26may/EmployeeFileLocation", description = "Exposes APIs to work with EmployeeFileLocation resource.")
@RequestMapping("/TestDB_26may/EmployeeFileLocation")
public class EmployeeFileLocationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFileLocationController.class);

    @Autowired
	@Qualifier("TestDB_26may.EmployeeFileLocationService")
	private EmployeeFileLocationService employeeFileLocationService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new EmployeeFileLocation instance.")
	public EmployeeFileLocation createEmployeeFileLocation(@RequestBody EmployeeFileLocation employeefilelocation) {
		LOGGER.debug("Create EmployeeFileLocation with information: {}" , employeefilelocation);

		employeefilelocation = employeeFileLocationService.create(employeefilelocation);
		LOGGER.debug("Created EmployeeFileLocation with information: {}" , employeefilelocation);

	    return employeefilelocation;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the EmployeeFileLocation instance associated with the given id.")
    public EmployeeFileLocation getEmployeeFileLocation(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeFileLocation with id: {}" , id);

        EmployeeFileLocation foundEmployeeFileLocation = employeeFileLocationService.getById(id);
        LOGGER.debug("EmployeeFileLocation details with id: {}" , foundEmployeeFileLocation);

        return foundEmployeeFileLocation;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the EmployeeFileLocation instance associated with the given id.")
    public EmployeeFileLocation editEmployeeFileLocation(@PathVariable("id") Integer id, @RequestBody EmployeeFileLocation employeefilelocation) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeFileLocation with id: {}" , employeefilelocation.getIdEmployeeFileLocation());

        employeefilelocation.setIdEmployeeFileLocation(id);
        employeefilelocation = employeeFileLocationService.update(employeefilelocation);
        LOGGER.debug("EmployeeFileLocation details with id: {}" , employeefilelocation);

        return employeefilelocation;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the EmployeeFileLocation instance associated with the given id.")
    public boolean deleteEmployeeFileLocation(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeFileLocation with id: {}" , id);

        EmployeeFileLocation deletedEmployeeFileLocation = employeeFileLocationService.delete(id);

        return deletedEmployeeFileLocation != null;
    }
    /**
     * @deprecated Use {@link #findEmployeeFileLocations(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of EmployeeFileLocation instances matching the search criteria.")
	public Page<EmployeeFileLocation> findEmployeeFileLocations( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering EmployeeFileLocations list");
		return employeeFileLocationService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of EmployeeFileLocation instances matching the search criteria.")
    public Page<EmployeeFileLocation> findEmployeeFileLocations(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeFileLocations list");
    	return employeeFileLocationService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportEmployeeFileLocations(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return employeeFileLocationService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of EmployeeFileLocation instances.")
	public Long countEmployeeFileLocations(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting EmployeeFileLocations");
		return employeeFileLocationService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeFileLocationService instance
	 */
	protected void setEmployeeFileLocationService(EmployeeFileLocationService service) {
		this.employeeFileLocationService = service;
	}

}

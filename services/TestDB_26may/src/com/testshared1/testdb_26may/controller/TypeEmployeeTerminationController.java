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

import com.testshared1.testdb_26may.EmployeeTermination;
import com.testshared1.testdb_26may.TypeEmployeeTermination;
import com.testshared1.testdb_26may.service.EmployeeTerminationService;
import com.testshared1.testdb_26may.service.TypeEmployeeTerminationService;


/**
 * Controller object for domain model class TypeEmployeeTermination.
 * @see TypeEmployeeTermination
 */
@RestController("TestDB_26may.TypeEmployeeTerminationController")
@Api(value = "/TestDB_26may/TypeEmployeeTermination", description = "Exposes APIs to work with TypeEmployeeTermination resource.")
@RequestMapping("/TestDB_26may/TypeEmployeeTermination")
public class TypeEmployeeTerminationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeEmployeeTerminationController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeEmployeeTerminationService")
	private TypeEmployeeTerminationService typeEmployeeTerminationService;

    @Autowired
	@Qualifier("TestDB_26may.EmployeeTerminationService")
	private EmployeeTerminationService employeeTerminationService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeEmployeeTermination instance.")
	public TypeEmployeeTermination createTypeEmployeeTermination(@RequestBody TypeEmployeeTermination typeemployeetermination) {
		LOGGER.debug("Create TypeEmployeeTermination with information: {}" , typeemployeetermination);

		typeemployeetermination = typeEmployeeTerminationService.create(typeemployeetermination);
		LOGGER.debug("Created TypeEmployeeTermination with information: {}" , typeemployeetermination);

	    return typeemployeetermination;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeEmployeeTermination instance associated with the given id.")
    public TypeEmployeeTermination getTypeEmployeeTermination(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeEmployeeTermination with id: {}" , id);

        TypeEmployeeTermination foundTypeEmployeeTermination = typeEmployeeTerminationService.getById(id);
        LOGGER.debug("TypeEmployeeTermination details with id: {}" , foundTypeEmployeeTermination);

        return foundTypeEmployeeTermination;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeEmployeeTermination instance associated with the given id.")
    public TypeEmployeeTermination editTypeEmployeeTermination(@PathVariable("id") Integer id, @RequestBody TypeEmployeeTermination typeemployeetermination) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeEmployeeTermination with id: {}" , typeemployeetermination.getIdEmployeeTermination());

        typeemployeetermination.setIdEmployeeTermination(id);
        typeemployeetermination = typeEmployeeTerminationService.update(typeemployeetermination);
        LOGGER.debug("TypeEmployeeTermination details with id: {}" , typeemployeetermination);

        return typeemployeetermination;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeEmployeeTermination instance associated with the given id.")
    public boolean deleteTypeEmployeeTermination(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeEmployeeTermination with id: {}" , id);

        TypeEmployeeTermination deletedTypeEmployeeTermination = typeEmployeeTerminationService.delete(id);

        return deletedTypeEmployeeTermination != null;
    }
    /**
     * @deprecated Use {@link #findTypeEmployeeTerminations(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeEmployeeTermination instances matching the search criteria.")
	public Page<TypeEmployeeTermination> findTypeEmployeeTerminations( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeEmployeeTerminations list");
		return typeEmployeeTerminationService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeEmployeeTermination instances matching the search criteria.")
    public Page<TypeEmployeeTermination> findTypeEmployeeTerminations(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeEmployeeTerminations list");
    	return typeEmployeeTerminationService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeEmployeeTerminations(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeEmployeeTerminationService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeEmployeeTermination instances.")
	public Long countTypeEmployeeTerminations(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeEmployeeTerminations");
		return typeEmployeeTerminationService.count(query);
	}

    @RequestMapping(value="/{id:.+}/employeeTerminations", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the employeeTerminations instance associated with the given id.")
     public Page<EmployeeTermination>
        findAssociatedEmployeeTerminations(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated employeeTerminations");
        return employeeTerminationService.findAssociatedValues(id, "EmployeeTermination", "idEmployeeTermination", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeEmployeeTerminationService instance
	 */
	protected void setTypeEmployeeTerminationService(TypeEmployeeTerminationService service) {
		this.typeEmployeeTerminationService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeTerminationService instance
	 */
	protected void setEmployeeTerminationService(EmployeeTerminationService service) {
        this.employeeTerminationService = service;
    }
}


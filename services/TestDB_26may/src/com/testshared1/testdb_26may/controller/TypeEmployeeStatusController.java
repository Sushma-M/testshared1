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

import com.testshared1.testdb_26may.Employee;
import com.testshared1.testdb_26may.TypeEmployeeStatus;
import com.testshared1.testdb_26may.service.EmployeeService;
import com.testshared1.testdb_26may.service.TypeEmployeeStatusService;


/**
 * Controller object for domain model class TypeEmployeeStatus.
 * @see TypeEmployeeStatus
 */
@RestController("TestDB_26may.TypeEmployeeStatusController")
@Api(value = "/TestDB_26may/TypeEmployeeStatus", description = "Exposes APIs to work with TypeEmployeeStatus resource.")
@RequestMapping("/TestDB_26may/TypeEmployeeStatus")
public class TypeEmployeeStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeEmployeeStatusController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeEmployeeStatusService")
	private TypeEmployeeStatusService typeEmployeeStatusService;

    @Autowired
	@Qualifier("TestDB_26may.EmployeeService")
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeEmployeeStatus instance.")
	public TypeEmployeeStatus createTypeEmployeeStatus(@RequestBody TypeEmployeeStatus typeemployeestatus) {
		LOGGER.debug("Create TypeEmployeeStatus with information: {}" , typeemployeestatus);

		typeemployeestatus = typeEmployeeStatusService.create(typeemployeestatus);
		LOGGER.debug("Created TypeEmployeeStatus with information: {}" , typeemployeestatus);

	    return typeemployeestatus;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeEmployeeStatus instance associated with the given id.")
    public TypeEmployeeStatus getTypeEmployeeStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeEmployeeStatus with id: {}" , id);

        TypeEmployeeStatus foundTypeEmployeeStatus = typeEmployeeStatusService.getById(id);
        LOGGER.debug("TypeEmployeeStatus details with id: {}" , foundTypeEmployeeStatus);

        return foundTypeEmployeeStatus;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeEmployeeStatus instance associated with the given id.")
    public TypeEmployeeStatus editTypeEmployeeStatus(@PathVariable("id") Integer id, @RequestBody TypeEmployeeStatus typeemployeestatus) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeEmployeeStatus with id: {}" , typeemployeestatus.getIdTypeApplicantStatus());

        typeemployeestatus.setIdTypeApplicantStatus(id);
        typeemployeestatus = typeEmployeeStatusService.update(typeemployeestatus);
        LOGGER.debug("TypeEmployeeStatus details with id: {}" , typeemployeestatus);

        return typeemployeestatus;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeEmployeeStatus instance associated with the given id.")
    public boolean deleteTypeEmployeeStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeEmployeeStatus with id: {}" , id);

        TypeEmployeeStatus deletedTypeEmployeeStatus = typeEmployeeStatusService.delete(id);

        return deletedTypeEmployeeStatus != null;
    }
    /**
     * @deprecated Use {@link #findTypeEmployeeStatuses(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeEmployeeStatus instances matching the search criteria.")
	public Page<TypeEmployeeStatus> findTypeEmployeeStatuses( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeEmployeeStatuses list");
		return typeEmployeeStatusService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeEmployeeStatus instances matching the search criteria.")
    public Page<TypeEmployeeStatus> findTypeEmployeeStatuses(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeEmployeeStatuses list");
    	return typeEmployeeStatusService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeEmployeeStatuses(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeEmployeeStatusService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeEmployeeStatus instances.")
	public Long countTypeEmployeeStatuses(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeEmployeeStatuses");
		return typeEmployeeStatusService.count(query);
	}

    @RequestMapping(value="/{id:.+}/employees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the employees instance associated with the given id.")
     public Page<Employee>
        findAssociatedEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated employees");
        return employeeService.findAssociatedValues(id, "Employee", "idTypeApplicantStatus", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeEmployeeStatusService instance
	 */
	protected void setTypeEmployeeStatusService(TypeEmployeeStatusService service) {
		this.typeEmployeeStatusService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeService instance
	 */
	protected void setEmployeeService(EmployeeService service) {
        this.employeeService = service;
    }
}

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

import com.testshared1.testdb_26may.EmployeeMessage;
import com.testshared1.testdb_26may.service.EmployeeMessageService;


/**
 * Controller object for domain model class EmployeeMessage.
 * @see EmployeeMessage
 */
@RestController("TestDB_26may.EmployeeMessageController")
@Api(value = "/TestDB_26may/EmployeeMessage", description = "Exposes APIs to work with EmployeeMessage resource.")
@RequestMapping("/TestDB_26may/EmployeeMessage")
public class EmployeeMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeMessageController.class);

    @Autowired
	@Qualifier("TestDB_26may.EmployeeMessageService")
	private EmployeeMessageService employeeMessageService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new EmployeeMessage instance.")
	public EmployeeMessage createEmployeeMessage(@RequestBody EmployeeMessage employeemessage) {
		LOGGER.debug("Create EmployeeMessage with information: {}" , employeemessage);

		employeemessage = employeeMessageService.create(employeemessage);
		LOGGER.debug("Created EmployeeMessage with information: {}" , employeemessage);

	    return employeemessage;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the EmployeeMessage instance associated with the given id.")
    public EmployeeMessage getEmployeeMessage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeMessage with id: {}" , id);

        EmployeeMessage foundEmployeeMessage = employeeMessageService.getById(id);
        LOGGER.debug("EmployeeMessage details with id: {}" , foundEmployeeMessage);

        return foundEmployeeMessage;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the EmployeeMessage instance associated with the given id.")
    public EmployeeMessage editEmployeeMessage(@PathVariable("id") Integer id, @RequestBody EmployeeMessage employeemessage) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeMessage with id: {}" , employeemessage.getIdEmployeeMessage());

        employeemessage.setIdEmployeeMessage(id);
        employeemessage = employeeMessageService.update(employeemessage);
        LOGGER.debug("EmployeeMessage details with id: {}" , employeemessage);

        return employeemessage;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the EmployeeMessage instance associated with the given id.")
    public boolean deleteEmployeeMessage(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeMessage with id: {}" , id);

        EmployeeMessage deletedEmployeeMessage = employeeMessageService.delete(id);

        return deletedEmployeeMessage != null;
    }
    /**
     * @deprecated Use {@link #findEmployeeMessages(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of EmployeeMessage instances matching the search criteria.")
	public Page<EmployeeMessage> findEmployeeMessages( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering EmployeeMessages list");
		return employeeMessageService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of EmployeeMessage instances matching the search criteria.")
    public Page<EmployeeMessage> findEmployeeMessages(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeMessages list");
    	return employeeMessageService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportEmployeeMessages(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return employeeMessageService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of EmployeeMessage instances.")
	public Long countEmployeeMessages(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting EmployeeMessages");
		return employeeMessageService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeMessageService instance
	 */
	protected void setEmployeeMessageService(EmployeeMessageService service) {
		this.employeeMessageService = service;
	}

}


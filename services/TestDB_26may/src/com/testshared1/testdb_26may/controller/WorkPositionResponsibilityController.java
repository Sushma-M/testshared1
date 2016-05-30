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

import com.testshared1.testdb_26may.WorkPositionResponsibility;
import com.testshared1.testdb_26may.service.WorkPositionResponsibilityService;


/**
 * Controller object for domain model class WorkPositionResponsibility.
 * @see WorkPositionResponsibility
 */
@RestController("TestDB_26may.WorkPositionResponsibilityController")
@Api(value = "/TestDB_26may/WorkPositionResponsibility", description = "Exposes APIs to work with WorkPositionResponsibility resource.")
@RequestMapping("/TestDB_26may/WorkPositionResponsibility")
public class WorkPositionResponsibilityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionResponsibilityController.class);

    @Autowired
	@Qualifier("TestDB_26may.WorkPositionResponsibilityService")
	private WorkPositionResponsibilityService workPositionResponsibilityService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new WorkPositionResponsibility instance.")
	public WorkPositionResponsibility createWorkPositionResponsibility(@RequestBody WorkPositionResponsibility workpositionresponsibility) {
		LOGGER.debug("Create WorkPositionResponsibility with information: {}" , workpositionresponsibility);

		workpositionresponsibility = workPositionResponsibilityService.create(workpositionresponsibility);
		LOGGER.debug("Created WorkPositionResponsibility with information: {}" , workpositionresponsibility);

	    return workpositionresponsibility;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the WorkPositionResponsibility instance associated with the given id.")
    public WorkPositionResponsibility getWorkPositionResponsibility(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting WorkPositionResponsibility with id: {}" , id);

        WorkPositionResponsibility foundWorkPositionResponsibility = workPositionResponsibilityService.getById(id);
        LOGGER.debug("WorkPositionResponsibility details with id: {}" , foundWorkPositionResponsibility);

        return foundWorkPositionResponsibility;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the WorkPositionResponsibility instance associated with the given id.")
    public WorkPositionResponsibility editWorkPositionResponsibility(@PathVariable("id") Integer id, @RequestBody WorkPositionResponsibility workpositionresponsibility) throws EntityNotFoundException {
        LOGGER.debug("Editing WorkPositionResponsibility with id: {}" , workpositionresponsibility.getIdWorkPositionResponsibility());

        workpositionresponsibility.setIdWorkPositionResponsibility(id);
        workpositionresponsibility = workPositionResponsibilityService.update(workpositionresponsibility);
        LOGGER.debug("WorkPositionResponsibility details with id: {}" , workpositionresponsibility);

        return workpositionresponsibility;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the WorkPositionResponsibility instance associated with the given id.")
    public boolean deleteWorkPositionResponsibility(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting WorkPositionResponsibility with id: {}" , id);

        WorkPositionResponsibility deletedWorkPositionResponsibility = workPositionResponsibilityService.delete(id);

        return deletedWorkPositionResponsibility != null;
    }
    /**
     * @deprecated Use {@link #findWorkPositionResponsibilities(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of WorkPositionResponsibility instances matching the search criteria.")
	public Page<WorkPositionResponsibility> findWorkPositionResponsibilities( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering WorkPositionResponsibilities list");
		return workPositionResponsibilityService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of WorkPositionResponsibility instances matching the search criteria.")
    public Page<WorkPositionResponsibility> findWorkPositionResponsibilities(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering WorkPositionResponsibilities list");
    	return workPositionResponsibilityService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportWorkPositionResponsibilities(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return workPositionResponsibilityService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of WorkPositionResponsibility instances.")
	public Long countWorkPositionResponsibilities(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting WorkPositionResponsibilities");
		return workPositionResponsibilityService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service WorkPositionResponsibilityService instance
	 */
	protected void setWorkPositionResponsibilityService(WorkPositionResponsibilityService service) {
		this.workPositionResponsibilityService = service;
	}

}


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

import com.testshared1.testdb_26may.EmployeeTraining;
import com.testshared1.testdb_26may.service.EmployeeTrainingService;


/**
 * Controller object for domain model class EmployeeTraining.
 * @see EmployeeTraining
 */
@RestController("TestDB_26may.EmployeeTrainingController")
@Api(value = "/TestDB_26may/EmployeeTraining", description = "Exposes APIs to work with EmployeeTraining resource.")
@RequestMapping("/TestDB_26may/EmployeeTraining")
public class EmployeeTrainingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeTrainingController.class);

    @Autowired
	@Qualifier("TestDB_26may.EmployeeTrainingService")
	private EmployeeTrainingService employeeTrainingService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new EmployeeTraining instance.")
	public EmployeeTraining createEmployeeTraining(@RequestBody EmployeeTraining employeetraining) {
		LOGGER.debug("Create EmployeeTraining with information: {}" , employeetraining);

		employeetraining = employeeTrainingService.create(employeetraining);
		LOGGER.debug("Created EmployeeTraining with information: {}" , employeetraining);

	    return employeetraining;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the EmployeeTraining instance associated with the given id.")
    public EmployeeTraining getEmployeeTraining(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeTraining with id: {}" , id);

        EmployeeTraining foundEmployeeTraining = employeeTrainingService.getById(id);
        LOGGER.debug("EmployeeTraining details with id: {}" , foundEmployeeTraining);

        return foundEmployeeTraining;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the EmployeeTraining instance associated with the given id.")
    public EmployeeTraining editEmployeeTraining(@PathVariable("id") Integer id, @RequestBody EmployeeTraining employeetraining) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeTraining with id: {}" , employeetraining.getIdEmployeeTraining());

        employeetraining.setIdEmployeeTraining(id);
        employeetraining = employeeTrainingService.update(employeetraining);
        LOGGER.debug("EmployeeTraining details with id: {}" , employeetraining);

        return employeetraining;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the EmployeeTraining instance associated with the given id.")
    public boolean deleteEmployeeTraining(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeTraining with id: {}" , id);

        EmployeeTraining deletedEmployeeTraining = employeeTrainingService.delete(id);

        return deletedEmployeeTraining != null;
    }
    /**
     * @deprecated Use {@link #findEmployeeTrainings(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of EmployeeTraining instances matching the search criteria.")
	public Page<EmployeeTraining> findEmployeeTrainings( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering EmployeeTrainings list");
		return employeeTrainingService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of EmployeeTraining instances matching the search criteria.")
    public Page<EmployeeTraining> findEmployeeTrainings(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeTrainings list");
    	return employeeTrainingService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportEmployeeTrainings(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return employeeTrainingService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of EmployeeTraining instances.")
	public Long countEmployeeTrainings(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting EmployeeTrainings");
		return employeeTrainingService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeTrainingService instance
	 */
	protected void setEmployeeTrainingService(EmployeeTrainingService service) {
		this.employeeTrainingService = service;
	}

}

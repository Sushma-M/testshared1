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

import com.testshared1.testdb_26may.DeductionPeriodic;
import com.testshared1.testdb_26may.ListPeriodicDeductionEmployee;
import com.testshared1.testdb_26may.ListPeriodicDeductionPayroll;
import com.testshared1.testdb_26may.service.DeductionPeriodicService;
import com.testshared1.testdb_26may.service.ListPeriodicDeductionEmployeeService;
import com.testshared1.testdb_26may.service.ListPeriodicDeductionPayrollService;


/**
 * Controller object for domain model class DeductionPeriodic.
 * @see DeductionPeriodic
 */
@RestController("TestDB_26may.DeductionPeriodicController")
@Api(value = "/TestDB_26may/DeductionPeriodic", description = "Exposes APIs to work with DeductionPeriodic resource.")
@RequestMapping("/TestDB_26may/DeductionPeriodic")
public class DeductionPeriodicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeductionPeriodicController.class);

    @Autowired
	@Qualifier("TestDB_26may.DeductionPeriodicService")
	private DeductionPeriodicService deductionPeriodicService;

    @Autowired
	@Qualifier("TestDB_26may.ListPeriodicDeductionEmployeeService")
	private ListPeriodicDeductionEmployeeService listPeriodicDeductionEmployeeService;

    @Autowired
	@Qualifier("TestDB_26may.ListPeriodicDeductionPayrollService")
	private ListPeriodicDeductionPayrollService listPeriodicDeductionPayrollService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new DeductionPeriodic instance.")
	public DeductionPeriodic createDeductionPeriodic(@RequestBody DeductionPeriodic deductionperiodic) {
		LOGGER.debug("Create DeductionPeriodic with information: {}" , deductionperiodic);

		deductionperiodic = deductionPeriodicService.create(deductionperiodic);
		LOGGER.debug("Created DeductionPeriodic with information: {}" , deductionperiodic);

	    return deductionperiodic;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the DeductionPeriodic instance associated with the given id.")
    public DeductionPeriodic getDeductionPeriodic(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting DeductionPeriodic with id: {}" , id);

        DeductionPeriodic foundDeductionPeriodic = deductionPeriodicService.getById(id);
        LOGGER.debug("DeductionPeriodic details with id: {}" , foundDeductionPeriodic);

        return foundDeductionPeriodic;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the DeductionPeriodic instance associated with the given id.")
    public DeductionPeriodic editDeductionPeriodic(@PathVariable("id") Integer id, @RequestBody DeductionPeriodic deductionperiodic) throws EntityNotFoundException {
        LOGGER.debug("Editing DeductionPeriodic with id: {}" , deductionperiodic.getIdDeductionPeriodic());

        deductionperiodic.setIdDeductionPeriodic(id);
        deductionperiodic = deductionPeriodicService.update(deductionperiodic);
        LOGGER.debug("DeductionPeriodic details with id: {}" , deductionperiodic);

        return deductionperiodic;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the DeductionPeriodic instance associated with the given id.")
    public boolean deleteDeductionPeriodic(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting DeductionPeriodic with id: {}" , id);

        DeductionPeriodic deletedDeductionPeriodic = deductionPeriodicService.delete(id);

        return deletedDeductionPeriodic != null;
    }
    /**
     * @deprecated Use {@link #findDeductionPeriodics(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of DeductionPeriodic instances matching the search criteria.")
	public Page<DeductionPeriodic> findDeductionPeriodics( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering DeductionPeriodics list");
		return deductionPeriodicService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of DeductionPeriodic instances matching the search criteria.")
    public Page<DeductionPeriodic> findDeductionPeriodics(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DeductionPeriodics list");
    	return deductionPeriodicService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportDeductionPeriodics(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return deductionPeriodicService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of DeductionPeriodic instances.")
	public Long countDeductionPeriodics(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DeductionPeriodics");
		return deductionPeriodicService.count(query);
	}

    @RequestMapping(value="/{id:.+}/listPeriodicDeductionPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionPayrolls instance associated with the given id.")
     public Page<ListPeriodicDeductionPayroll>
        findAssociatedListPeriodicDeductionPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicDeductionPayrolls");
        return listPeriodicDeductionPayrollService.findAssociatedValues(id, "ListPeriodicDeductionPayroll", "idDeductionPeriodic", pageable);
   }

    @RequestMapping(value="/{id:.+}/listPeriodicDeductionEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionEmployees instance associated with the given id.")
     public Page<ListPeriodicDeductionEmployee>
        findAssociatedListPeriodicDeductionEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicDeductionEmployees");
        return listPeriodicDeductionEmployeeService.findAssociatedValues(id, "ListPeriodicDeductionEmployee", "idDeductionPeriodic", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DeductionPeriodicService instance
	 */
	protected void setDeductionPeriodicService(DeductionPeriodicService service) {
		this.deductionPeriodicService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicDeductionEmployeeService instance
	 */
	protected void setListPeriodicDeductionEmployeeService(ListPeriodicDeductionEmployeeService service) {
        this.listPeriodicDeductionEmployeeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicDeductionPayrollService instance
	 */
	protected void setListPeriodicDeductionPayrollService(ListPeriodicDeductionPayrollService service) {
        this.listPeriodicDeductionPayrollService = service;
    }
}


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

import com.testshared1.testdb_26may.BonusPeriodic;
import com.testshared1.testdb_26may.ListPeriodicBonusEmployee;
import com.testshared1.testdb_26may.ListPeriodicBonusPayroll;
import com.testshared1.testdb_26may.service.BonusPeriodicService;
import com.testshared1.testdb_26may.service.ListPeriodicBonusEmployeeService;
import com.testshared1.testdb_26may.service.ListPeriodicBonusPayrollService;


/**
 * Controller object for domain model class BonusPeriodic.
 * @see BonusPeriodic
 */
@RestController("TestDB_26may.BonusPeriodicController")
@Api(value = "/TestDB_26may/BonusPeriodic", description = "Exposes APIs to work with BonusPeriodic resource.")
@RequestMapping("/TestDB_26may/BonusPeriodic")
public class BonusPeriodicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BonusPeriodicController.class);

    @Autowired
	@Qualifier("TestDB_26may.BonusPeriodicService")
	private BonusPeriodicService bonusPeriodicService;

    @Autowired
	@Qualifier("TestDB_26may.ListPeriodicBonusPayrollService")
	private ListPeriodicBonusPayrollService listPeriodicBonusPayrollService;

    @Autowired
	@Qualifier("TestDB_26may.ListPeriodicBonusEmployeeService")
	private ListPeriodicBonusEmployeeService listPeriodicBonusEmployeeService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new BonusPeriodic instance.")
	public BonusPeriodic createBonusPeriodic(@RequestBody BonusPeriodic bonusperiodic) {
		LOGGER.debug("Create BonusPeriodic with information: {}" , bonusperiodic);

		bonusperiodic = bonusPeriodicService.create(bonusperiodic);
		LOGGER.debug("Created BonusPeriodic with information: {}" , bonusperiodic);

	    return bonusperiodic;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the BonusPeriodic instance associated with the given id.")
    public BonusPeriodic getBonusPeriodic(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting BonusPeriodic with id: {}" , id);

        BonusPeriodic foundBonusPeriodic = bonusPeriodicService.getById(id);
        LOGGER.debug("BonusPeriodic details with id: {}" , foundBonusPeriodic);

        return foundBonusPeriodic;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the BonusPeriodic instance associated with the given id.")
    public BonusPeriodic editBonusPeriodic(@PathVariable("id") Integer id, @RequestBody BonusPeriodic bonusperiodic) throws EntityNotFoundException {
        LOGGER.debug("Editing BonusPeriodic with id: {}" , bonusperiodic.getIdBonusPeriodic());

        bonusperiodic.setIdBonusPeriodic(id);
        bonusperiodic = bonusPeriodicService.update(bonusperiodic);
        LOGGER.debug("BonusPeriodic details with id: {}" , bonusperiodic);

        return bonusperiodic;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the BonusPeriodic instance associated with the given id.")
    public boolean deleteBonusPeriodic(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting BonusPeriodic with id: {}" , id);

        BonusPeriodic deletedBonusPeriodic = bonusPeriodicService.delete(id);

        return deletedBonusPeriodic != null;
    }
    /**
     * @deprecated Use {@link #findBonusPeriodics(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of BonusPeriodic instances matching the search criteria.")
	public Page<BonusPeriodic> findBonusPeriodics( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering BonusPeriodics list");
		return bonusPeriodicService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of BonusPeriodic instances matching the search criteria.")
    public Page<BonusPeriodic> findBonusPeriodics(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BonusPeriodics list");
    	return bonusPeriodicService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportBonusPeriodics(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return bonusPeriodicService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of BonusPeriodic instances.")
	public Long countBonusPeriodics(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting BonusPeriodics");
		return bonusPeriodicService.count(query);
	}

    @RequestMapping(value="/{id:.+}/listPeriodicBonusEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusEmployees instance associated with the given id.")
     public Page<ListPeriodicBonusEmployee>
        findAssociatedListPeriodicBonusEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicBonusEmployees");
        return listPeriodicBonusEmployeeService.findAssociatedValues(id, "ListPeriodicBonusEmployee", "idBonusPeriodic", pageable);
   }

    @RequestMapping(value="/{id:.+}/listPeriodicBonusPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusPayrolls instance associated with the given id.")
     public Page<ListPeriodicBonusPayroll>
        findAssociatedListPeriodicBonusPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicBonusPayrolls");
        return listPeriodicBonusPayrollService.findAssociatedValues(id, "ListPeriodicBonusPayroll", "idBonusPeriodic", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BonusPeriodicService instance
	 */
	protected void setBonusPeriodicService(BonusPeriodicService service) {
		this.bonusPeriodicService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicBonusPayrollService instance
	 */
	protected void setListPeriodicBonusPayrollService(ListPeriodicBonusPayrollService service) {
        this.listPeriodicBonusPayrollService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicBonusEmployeeService instance
	 */
	protected void setListPeriodicBonusEmployeeService(ListPeriodicBonusEmployeeService service) {
        this.listPeriodicBonusEmployeeService = service;
    }
}


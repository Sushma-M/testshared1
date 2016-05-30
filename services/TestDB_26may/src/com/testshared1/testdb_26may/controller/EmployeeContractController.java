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

import com.testshared1.testdb_26may.EmployeeContract;
import com.testshared1.testdb_26may.service.EmployeeContractService;


/**
 * Controller object for domain model class EmployeeContract.
 * @see EmployeeContract
 */
@RestController("TestDB_26may.EmployeeContractController")
@Api(value = "/TestDB_26may/EmployeeContract", description = "Exposes APIs to work with EmployeeContract resource.")
@RequestMapping("/TestDB_26may/EmployeeContract")
public class EmployeeContractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeContractController.class);

    @Autowired
	@Qualifier("TestDB_26may.EmployeeContractService")
	private EmployeeContractService employeeContractService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new EmployeeContract instance.")
	public EmployeeContract createEmployeeContract(@RequestBody EmployeeContract employeecontract) {
		LOGGER.debug("Create EmployeeContract with information: {}" , employeecontract);

		employeecontract = employeeContractService.create(employeecontract);
		LOGGER.debug("Created EmployeeContract with information: {}" , employeecontract);

	    return employeecontract;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the EmployeeContract instance associated with the given id.")
    public EmployeeContract getEmployeeContract(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeContract with id: {}" , id);

        EmployeeContract foundEmployeeContract = employeeContractService.getById(id);
        LOGGER.debug("EmployeeContract details with id: {}" , foundEmployeeContract);

        return foundEmployeeContract;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the EmployeeContract instance associated with the given id.")
    public EmployeeContract editEmployeeContract(@PathVariable("id") Integer id, @RequestBody EmployeeContract employeecontract) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeContract with id: {}" , employeecontract.getIdEmployeeContract());

        employeecontract.setIdEmployeeContract(id);
        employeecontract = employeeContractService.update(employeecontract);
        LOGGER.debug("EmployeeContract details with id: {}" , employeecontract);

        return employeecontract;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the EmployeeContract instance associated with the given id.")
    public boolean deleteEmployeeContract(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeContract with id: {}" , id);

        EmployeeContract deletedEmployeeContract = employeeContractService.delete(id);

        return deletedEmployeeContract != null;
    }
    /**
     * @deprecated Use {@link #findEmployeeContracts(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of EmployeeContract instances matching the search criteria.")
	public Page<EmployeeContract> findEmployeeContracts( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering EmployeeContracts list");
		return employeeContractService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of EmployeeContract instances matching the search criteria.")
    public Page<EmployeeContract> findEmployeeContracts(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeContracts list");
    	return employeeContractService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportEmployeeContracts(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return employeeContractService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of EmployeeContract instances.")
	public Long countEmployeeContracts(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting EmployeeContracts");
		return employeeContractService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeContractService instance
	 */
	protected void setEmployeeContractService(EmployeeContractService service) {
		this.employeeContractService = service;
	}

}

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

import com.testshared1.testdb_26may.ListCelphoneDetailPayroll;
import com.testshared1.testdb_26may.ListEmployeePhone;
import com.testshared1.testdb_26may.MobileNumber;
import com.testshared1.testdb_26may.service.ListCelphoneDetailPayrollService;
import com.testshared1.testdb_26may.service.ListEmployeePhoneService;
import com.testshared1.testdb_26may.service.MobileNumberService;


/**
 * Controller object for domain model class MobileNumber.
 * @see MobileNumber
 */
@RestController("TestDB_26may.MobileNumberController")
@Api(value = "/TestDB_26may/MobileNumber", description = "Exposes APIs to work with MobileNumber resource.")
@RequestMapping("/TestDB_26may/MobileNumber")
public class MobileNumberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileNumberController.class);

    @Autowired
	@Qualifier("TestDB_26may.MobileNumberService")
	private MobileNumberService mobileNumberService;

    @Autowired
	@Qualifier("TestDB_26may.ListEmployeePhoneService")
	private ListEmployeePhoneService listEmployeePhoneService;

    @Autowired
	@Qualifier("TestDB_26may.ListCelphoneDetailPayrollService")
	private ListCelphoneDetailPayrollService listCelphoneDetailPayrollService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new MobileNumber instance.")
	public MobileNumber createMobileNumber(@RequestBody MobileNumber mobilenumber) {
		LOGGER.debug("Create MobileNumber with information: {}" , mobilenumber);

		mobilenumber = mobileNumberService.create(mobilenumber);
		LOGGER.debug("Created MobileNumber with information: {}" , mobilenumber);

	    return mobilenumber;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the MobileNumber instance associated with the given id.")
    public MobileNumber getMobileNumber(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting MobileNumber with id: {}" , id);

        MobileNumber foundMobileNumber = mobileNumberService.getById(id);
        LOGGER.debug("MobileNumber details with id: {}" , foundMobileNumber);

        return foundMobileNumber;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the MobileNumber instance associated with the given id.")
    public MobileNumber editMobileNumber(@PathVariable("id") Integer id, @RequestBody MobileNumber mobilenumber) throws EntityNotFoundException {
        LOGGER.debug("Editing MobileNumber with id: {}" , mobilenumber.getIdCellphone());

        mobilenumber.setIdCellphone(id);
        mobilenumber = mobileNumberService.update(mobilenumber);
        LOGGER.debug("MobileNumber details with id: {}" , mobilenumber);

        return mobilenumber;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the MobileNumber instance associated with the given id.")
    public boolean deleteMobileNumber(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting MobileNumber with id: {}" , id);

        MobileNumber deletedMobileNumber = mobileNumberService.delete(id);

        return deletedMobileNumber != null;
    }
    /**
     * @deprecated Use {@link #findMobileNumbers(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of MobileNumber instances matching the search criteria.")
	public Page<MobileNumber> findMobileNumbers( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering MobileNumbers list");
		return mobileNumberService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of MobileNumber instances matching the search criteria.")
    public Page<MobileNumber> findMobileNumbers(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering MobileNumbers list");
    	return mobileNumberService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportMobileNumbers(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return mobileNumberService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of MobileNumber instances.")
	public Long countMobileNumbers(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting MobileNumbers");
		return mobileNumberService.count(query);
	}

    @RequestMapping(value="/{id:.+}/listCelphoneDetailPayrolls", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listCelphoneDetailPayrolls instance associated with the given id.")
     public Page<ListCelphoneDetailPayroll>
        findAssociatedListCelphoneDetailPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listCelphoneDetailPayrolls");
        return listCelphoneDetailPayrollService.findAssociatedValues(id, "ListCelphoneDetailPayroll", "idCellphone", pageable);
   }

    @RequestMapping(value="/{id:.+}/listEmployeePhones", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the listEmployeePhones instance associated with the given id.")
     public Page<ListEmployeePhone>
        findAssociatedListEmployeePhones(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listEmployeePhones");
        return listEmployeePhoneService.findAssociatedValues(id, "ListEmployeePhone", "idCellphone", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service MobileNumberService instance
	 */
	protected void setMobileNumberService(MobileNumberService service) {
		this.mobileNumberService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListEmployeePhoneService instance
	 */
	protected void setListEmployeePhoneService(ListEmployeePhoneService service) {
        this.listEmployeePhoneService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListCelphoneDetailPayrollService instance
	 */
	protected void setListCelphoneDetailPayrollService(ListCelphoneDetailPayrollService service) {
        this.listCelphoneDetailPayrollService = service;
    }
}

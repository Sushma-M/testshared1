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

import com.testshared1.testdb_26may.Alert;
import com.testshared1.testdb_26may.TypeAlert;
import com.testshared1.testdb_26may.service.AlertService;
import com.testshared1.testdb_26may.service.TypeAlertService;


/**
 * Controller object for domain model class TypeAlert.
 * @see TypeAlert
 */
@RestController("TestDB_26may.TypeAlertController")
@Api(value = "/TestDB_26may/TypeAlert", description = "Exposes APIs to work with TypeAlert resource.")
@RequestMapping("/TestDB_26may/TypeAlert")
public class TypeAlertController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeAlertController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeAlertService")
	private TypeAlertService typeAlertService;

    @Autowired
	@Qualifier("TestDB_26may.AlertService")
	private AlertService alertService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeAlert instance.")
	public TypeAlert createTypeAlert(@RequestBody TypeAlert typealert) {
		LOGGER.debug("Create TypeAlert with information: {}" , typealert);

		typealert = typeAlertService.create(typealert);
		LOGGER.debug("Created TypeAlert with information: {}" , typealert);

	    return typealert;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeAlert instance associated with the given id.")
    public TypeAlert getTypeAlert(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeAlert with id: {}" , id);

        TypeAlert foundTypeAlert = typeAlertService.getById(id);
        LOGGER.debug("TypeAlert details with id: {}" , foundTypeAlert);

        return foundTypeAlert;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeAlert instance associated with the given id.")
    public TypeAlert editTypeAlert(@PathVariable("id") Integer id, @RequestBody TypeAlert typealert) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeAlert with id: {}" , typealert.getIdTypeAlert());

        typealert.setIdTypeAlert(id);
        typealert = typeAlertService.update(typealert);
        LOGGER.debug("TypeAlert details with id: {}" , typealert);

        return typealert;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeAlert instance associated with the given id.")
    public boolean deleteTypeAlert(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeAlert with id: {}" , id);

        TypeAlert deletedTypeAlert = typeAlertService.delete(id);

        return deletedTypeAlert != null;
    }
    /**
     * @deprecated Use {@link #findTypeAlerts(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeAlert instances matching the search criteria.")
	public Page<TypeAlert> findTypeAlerts( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeAlerts list");
		return typeAlertService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeAlert instances matching the search criteria.")
    public Page<TypeAlert> findTypeAlerts(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeAlerts list");
    	return typeAlertService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeAlerts(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeAlertService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeAlert instances.")
	public Long countTypeAlerts(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeAlerts");
		return typeAlertService.count(query);
	}

    @RequestMapping(value="/{id:.+}/alerts", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the alerts instance associated with the given id.")
     public Page<Alert>
        findAssociatedAlerts(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated alerts");
        return alertService.findAssociatedValues(id, "Alert", "idTypeAlert", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeAlertService instance
	 */
	protected void setTypeAlertService(TypeAlertService service) {
		this.typeAlertService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AlertService instance
	 */
	protected void setAlertService(AlertService service) {
        this.alertService = service;
    }
}


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

import com.testshared1.testdb_26may.IncidenceEmployee;
import com.testshared1.testdb_26may.TypeIncident;
import com.testshared1.testdb_26may.service.IncidenceEmployeeService;
import com.testshared1.testdb_26may.service.TypeIncidentService;


/**
 * Controller object for domain model class TypeIncident.
 * @see TypeIncident
 */
@RestController("TestDB_26may.TypeIncidentController")
@Api(value = "/TestDB_26may/TypeIncident", description = "Exposes APIs to work with TypeIncident resource.")
@RequestMapping("/TestDB_26may/TypeIncident")
public class TypeIncidentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeIncidentController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeIncidentService")
	private TypeIncidentService typeIncidentService;

    @Autowired
	@Qualifier("TestDB_26may.IncidenceEmployeeService")
	private IncidenceEmployeeService incidenceEmployeeService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeIncident instance.")
	public TypeIncident createTypeIncident(@RequestBody TypeIncident typeincident) {
		LOGGER.debug("Create TypeIncident with information: {}" , typeincident);

		typeincident = typeIncidentService.create(typeincident);
		LOGGER.debug("Created TypeIncident with information: {}" , typeincident);

	    return typeincident;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeIncident instance associated with the given id.")
    public TypeIncident getTypeIncident(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeIncident with id: {}" , id);

        TypeIncident foundTypeIncident = typeIncidentService.getById(id);
        LOGGER.debug("TypeIncident details with id: {}" , foundTypeIncident);

        return foundTypeIncident;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeIncident instance associated with the given id.")
    public TypeIncident editTypeIncident(@PathVariable("id") Integer id, @RequestBody TypeIncident typeincident) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeIncident with id: {}" , typeincident.getIdTypeIncident());

        typeincident.setIdTypeIncident(id);
        typeincident = typeIncidentService.update(typeincident);
        LOGGER.debug("TypeIncident details with id: {}" , typeincident);

        return typeincident;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeIncident instance associated with the given id.")
    public boolean deleteTypeIncident(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeIncident with id: {}" , id);

        TypeIncident deletedTypeIncident = typeIncidentService.delete(id);

        return deletedTypeIncident != null;
    }
    /**
     * @deprecated Use {@link #findTypeIncidents(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeIncident instances matching the search criteria.")
	public Page<TypeIncident> findTypeIncidents( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeIncidents list");
		return typeIncidentService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeIncident instances matching the search criteria.")
    public Page<TypeIncident> findTypeIncidents(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeIncidents list");
    	return typeIncidentService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeIncidents(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeIncidentService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeIncident instances.")
	public Long countTypeIncidents(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeIncidents");
		return typeIncidentService.count(query);
	}

    @RequestMapping(value="/{id:.+}/incidenceEmployees", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the incidenceEmployees instance associated with the given id.")
     public Page<IncidenceEmployee>
        findAssociatedIncidenceEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated incidenceEmployees");
        return incidenceEmployeeService.findAssociatedValues(id, "IncidenceEmployee", "idTypeIncident", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeIncidentService instance
	 */
	protected void setTypeIncidentService(TypeIncidentService service) {
		this.typeIncidentService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service IncidenceEmployeeService instance
	 */
	protected void setIncidenceEmployeeService(IncidenceEmployeeService service) {
        this.incidenceEmployeeService = service;
    }
}

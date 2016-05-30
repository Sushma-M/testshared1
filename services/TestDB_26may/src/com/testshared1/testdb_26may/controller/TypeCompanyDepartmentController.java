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

import com.testshared1.testdb_26may.CompanyDepartment;
import com.testshared1.testdb_26may.TypeCompanyDepartment;
import com.testshared1.testdb_26may.service.CompanyDepartmentService;
import com.testshared1.testdb_26may.service.TypeCompanyDepartmentService;


/**
 * Controller object for domain model class TypeCompanyDepartment.
 * @see TypeCompanyDepartment
 */
@RestController("TestDB_26may.TypeCompanyDepartmentController")
@Api(value = "/TestDB_26may/TypeCompanyDepartment", description = "Exposes APIs to work with TypeCompanyDepartment resource.")
@RequestMapping("/TestDB_26may/TypeCompanyDepartment")
public class TypeCompanyDepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeCompanyDepartmentController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeCompanyDepartmentService")
	private TypeCompanyDepartmentService typeCompanyDepartmentService;

    @Autowired
	@Qualifier("TestDB_26may.CompanyDepartmentService")
	private CompanyDepartmentService companyDepartmentService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeCompanyDepartment instance.")
	public TypeCompanyDepartment createTypeCompanyDepartment(@RequestBody TypeCompanyDepartment typecompanydepartment) {
		LOGGER.debug("Create TypeCompanyDepartment with information: {}" , typecompanydepartment);

		typecompanydepartment = typeCompanyDepartmentService.create(typecompanydepartment);
		LOGGER.debug("Created TypeCompanyDepartment with information: {}" , typecompanydepartment);

	    return typecompanydepartment;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeCompanyDepartment instance associated with the given id.")
    public TypeCompanyDepartment getTypeCompanyDepartment(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeCompanyDepartment with id: {}" , id);

        TypeCompanyDepartment foundTypeCompanyDepartment = typeCompanyDepartmentService.getById(id);
        LOGGER.debug("TypeCompanyDepartment details with id: {}" , foundTypeCompanyDepartment);

        return foundTypeCompanyDepartment;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeCompanyDepartment instance associated with the given id.")
    public TypeCompanyDepartment editTypeCompanyDepartment(@PathVariable("id") Integer id, @RequestBody TypeCompanyDepartment typecompanydepartment) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeCompanyDepartment with id: {}" , typecompanydepartment.getIdTypeCompanyDepartment());

        typecompanydepartment.setIdTypeCompanyDepartment(id);
        typecompanydepartment = typeCompanyDepartmentService.update(typecompanydepartment);
        LOGGER.debug("TypeCompanyDepartment details with id: {}" , typecompanydepartment);

        return typecompanydepartment;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeCompanyDepartment instance associated with the given id.")
    public boolean deleteTypeCompanyDepartment(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeCompanyDepartment with id: {}" , id);

        TypeCompanyDepartment deletedTypeCompanyDepartment = typeCompanyDepartmentService.delete(id);

        return deletedTypeCompanyDepartment != null;
    }
    /**
     * @deprecated Use {@link #findTypeCompanyDepartments(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeCompanyDepartment instances matching the search criteria.")
	public Page<TypeCompanyDepartment> findTypeCompanyDepartments( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeCompanyDepartments list");
		return typeCompanyDepartmentService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeCompanyDepartment instances matching the search criteria.")
    public Page<TypeCompanyDepartment> findTypeCompanyDepartments(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeCompanyDepartments list");
    	return typeCompanyDepartmentService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeCompanyDepartments(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeCompanyDepartmentService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeCompanyDepartment instances.")
	public Long countTypeCompanyDepartments(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeCompanyDepartments");
		return typeCompanyDepartmentService.count(query);
	}

    @RequestMapping(value="/{id:.+}/companyDepartments", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the companyDepartments instance associated with the given id.")
     public Page<CompanyDepartment>
        findAssociatedCompanyDepartments(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated companyDepartments");
        return companyDepartmentService.findAssociatedValues(id, "CompanyDepartment", "idTypeCompanyDepartment", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeCompanyDepartmentService instance
	 */
	protected void setTypeCompanyDepartmentService(TypeCompanyDepartmentService service) {
		this.typeCompanyDepartmentService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompanyDepartmentService instance
	 */
	protected void setCompanyDepartmentService(CompanyDepartmentService service) {
        this.companyDepartmentService = service;
    }
}


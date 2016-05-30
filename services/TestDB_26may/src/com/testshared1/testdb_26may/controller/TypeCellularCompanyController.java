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

import com.testshared1.testdb_26may.MobileNumber;
import com.testshared1.testdb_26may.TypeCellularCompany;
import com.testshared1.testdb_26may.service.MobileNumberService;
import com.testshared1.testdb_26may.service.TypeCellularCompanyService;


/**
 * Controller object for domain model class TypeCellularCompany.
 * @see TypeCellularCompany
 */
@RestController("TestDB_26may.TypeCellularCompanyController")
@Api(value = "/TestDB_26may/TypeCellularCompany", description = "Exposes APIs to work with TypeCellularCompany resource.")
@RequestMapping("/TestDB_26may/TypeCellularCompany")
public class TypeCellularCompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeCellularCompanyController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeCellularCompanyService")
	private TypeCellularCompanyService typeCellularCompanyService;

    @Autowired
	@Qualifier("TestDB_26may.MobileNumberService")
	private MobileNumberService mobileNumberService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeCellularCompany instance.")
	public TypeCellularCompany createTypeCellularCompany(@RequestBody TypeCellularCompany typecellularcompany) {
		LOGGER.debug("Create TypeCellularCompany with information: {}" , typecellularcompany);

		typecellularcompany = typeCellularCompanyService.create(typecellularcompany);
		LOGGER.debug("Created TypeCellularCompany with information: {}" , typecellularcompany);

	    return typecellularcompany;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeCellularCompany instance associated with the given id.")
    public TypeCellularCompany getTypeCellularCompany(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeCellularCompany with id: {}" , id);

        TypeCellularCompany foundTypeCellularCompany = typeCellularCompanyService.getById(id);
        LOGGER.debug("TypeCellularCompany details with id: {}" , foundTypeCellularCompany);

        return foundTypeCellularCompany;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeCellularCompany instance associated with the given id.")
    public TypeCellularCompany editTypeCellularCompany(@PathVariable("id") Integer id, @RequestBody TypeCellularCompany typecellularcompany) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeCellularCompany with id: {}" , typecellularcompany.getIdTypeCellularCompany());

        typecellularcompany.setIdTypeCellularCompany(id);
        typecellularcompany = typeCellularCompanyService.update(typecellularcompany);
        LOGGER.debug("TypeCellularCompany details with id: {}" , typecellularcompany);

        return typecellularcompany;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeCellularCompany instance associated with the given id.")
    public boolean deleteTypeCellularCompany(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeCellularCompany with id: {}" , id);

        TypeCellularCompany deletedTypeCellularCompany = typeCellularCompanyService.delete(id);

        return deletedTypeCellularCompany != null;
    }
    /**
     * @deprecated Use {@link #findTypeCellularCompanies(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeCellularCompany instances matching the search criteria.")
	public Page<TypeCellularCompany> findTypeCellularCompanies( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeCellularCompanies list");
		return typeCellularCompanyService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeCellularCompany instances matching the search criteria.")
    public Page<TypeCellularCompany> findTypeCellularCompanies(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeCellularCompanies list");
    	return typeCellularCompanyService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeCellularCompanies(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeCellularCompanyService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeCellularCompany instances.")
	public Long countTypeCellularCompanies(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeCellularCompanies");
		return typeCellularCompanyService.count(query);
	}

    @RequestMapping(value="/{id:.+}/mobileNumbers", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the mobileNumbers instance associated with the given id.")
     public Page<MobileNumber>
        findAssociatedMobileNumbers(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated mobileNumbers");
        return mobileNumberService.findAssociatedValues(id, "MobileNumber", "idTypeCellularCompany", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeCellularCompanyService instance
	 */
	protected void setTypeCellularCompanyService(TypeCellularCompanyService service) {
		this.typeCellularCompanyService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service MobileNumberService instance
	 */
	protected void setMobileNumberService(MobileNumberService service) {
        this.mobileNumberService = service;
    }
}

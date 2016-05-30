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

import com.testshared1.testdb_26may.ApplicantToPosition;
import com.testshared1.testdb_26may.TypeApplicantStatus;
import com.testshared1.testdb_26may.service.ApplicantToPositionService;
import com.testshared1.testdb_26may.service.TypeApplicantStatusService;


/**
 * Controller object for domain model class TypeApplicantStatus.
 * @see TypeApplicantStatus
 */
@RestController("TestDB_26may.TypeApplicantStatusController")
@Api(value = "/TestDB_26may/TypeApplicantStatus", description = "Exposes APIs to work with TypeApplicantStatus resource.")
@RequestMapping("/TestDB_26may/TypeApplicantStatus")
public class TypeApplicantStatusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeApplicantStatusController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeApplicantStatusService")
	private TypeApplicantStatusService typeApplicantStatusService;

    @Autowired
	@Qualifier("TestDB_26may.ApplicantToPositionService")
	private ApplicantToPositionService applicantToPositionService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeApplicantStatus instance.")
	public TypeApplicantStatus createTypeApplicantStatus(@RequestBody TypeApplicantStatus typeapplicantstatus) {
		LOGGER.debug("Create TypeApplicantStatus with information: {}" , typeapplicantstatus);

		typeapplicantstatus = typeApplicantStatusService.create(typeapplicantstatus);
		LOGGER.debug("Created TypeApplicantStatus with information: {}" , typeapplicantstatus);

	    return typeapplicantstatus;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeApplicantStatus instance associated with the given id.")
    public TypeApplicantStatus getTypeApplicantStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeApplicantStatus with id: {}" , id);

        TypeApplicantStatus foundTypeApplicantStatus = typeApplicantStatusService.getById(id);
        LOGGER.debug("TypeApplicantStatus details with id: {}" , foundTypeApplicantStatus);

        return foundTypeApplicantStatus;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeApplicantStatus instance associated with the given id.")
    public TypeApplicantStatus editTypeApplicantStatus(@PathVariable("id") Integer id, @RequestBody TypeApplicantStatus typeapplicantstatus) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeApplicantStatus with id: {}" , typeapplicantstatus.getIdTypeMaritalStatus());

        typeapplicantstatus.setIdTypeMaritalStatus(id);
        typeapplicantstatus = typeApplicantStatusService.update(typeapplicantstatus);
        LOGGER.debug("TypeApplicantStatus details with id: {}" , typeapplicantstatus);

        return typeapplicantstatus;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeApplicantStatus instance associated with the given id.")
    public boolean deleteTypeApplicantStatus(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeApplicantStatus with id: {}" , id);

        TypeApplicantStatus deletedTypeApplicantStatus = typeApplicantStatusService.delete(id);

        return deletedTypeApplicantStatus != null;
    }
    /**
     * @deprecated Use {@link #findTypeApplicantStatuses(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeApplicantStatus instances matching the search criteria.")
	public Page<TypeApplicantStatus> findTypeApplicantStatuses( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeApplicantStatuses list");
		return typeApplicantStatusService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeApplicantStatus instances matching the search criteria.")
    public Page<TypeApplicantStatus> findTypeApplicantStatuses(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeApplicantStatuses list");
    	return typeApplicantStatusService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeApplicantStatuses(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeApplicantStatusService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeApplicantStatus instances.")
	public Long countTypeApplicantStatuses(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeApplicantStatuses");
		return typeApplicantStatusService.count(query);
	}

    @RequestMapping(value="/{id:.+}/applicantToPositions", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the applicantToPositions instance associated with the given id.")
     public Page<ApplicantToPosition>
        findAssociatedApplicantToPositions(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated applicantToPositions");
        return applicantToPositionService.findAssociatedValues(id, "ApplicantToPosition", "idTypeMaritalStatus", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeApplicantStatusService instance
	 */
	protected void setTypeApplicantStatusService(TypeApplicantStatusService service) {
		this.typeApplicantStatusService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ApplicantToPositionService instance
	 */
	protected void setApplicantToPositionService(ApplicantToPositionService service) {
        this.applicantToPositionService = service;
    }
}

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
import com.testshared1.testdb_26may.WorkPositionVacant;
import com.testshared1.testdb_26may.service.ApplicantToPositionService;
import com.testshared1.testdb_26may.service.WorkPositionVacantService;


/**
 * Controller object for domain model class WorkPositionVacant.
 * @see WorkPositionVacant
 */
@RestController("TestDB_26may.WorkPositionVacantController")
@Api(value = "/TestDB_26may/WorkPositionVacant", description = "Exposes APIs to work with WorkPositionVacant resource.")
@RequestMapping("/TestDB_26may/WorkPositionVacant")
public class WorkPositionVacantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionVacantController.class);

    @Autowired
	@Qualifier("TestDB_26may.WorkPositionVacantService")
	private WorkPositionVacantService workPositionVacantService;

    @Autowired
	@Qualifier("TestDB_26may.ApplicantToPositionService")
	private ApplicantToPositionService applicantToPositionService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new WorkPositionVacant instance.")
	public WorkPositionVacant createWorkPositionVacant(@RequestBody WorkPositionVacant workpositionvacant) {
		LOGGER.debug("Create WorkPositionVacant with information: {}" , workpositionvacant);

		workpositionvacant = workPositionVacantService.create(workpositionvacant);
		LOGGER.debug("Created WorkPositionVacant with information: {}" , workpositionvacant);

	    return workpositionvacant;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the WorkPositionVacant instance associated with the given id.")
    public WorkPositionVacant getWorkPositionVacant(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting WorkPositionVacant with id: {}" , id);

        WorkPositionVacant foundWorkPositionVacant = workPositionVacantService.getById(id);
        LOGGER.debug("WorkPositionVacant details with id: {}" , foundWorkPositionVacant);

        return foundWorkPositionVacant;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the WorkPositionVacant instance associated with the given id.")
    public WorkPositionVacant editWorkPositionVacant(@PathVariable("id") Integer id, @RequestBody WorkPositionVacant workpositionvacant) throws EntityNotFoundException {
        LOGGER.debug("Editing WorkPositionVacant with id: {}" , workpositionvacant.getIdWorkPositionVacant());

        workpositionvacant.setIdWorkPositionVacant(id);
        workpositionvacant = workPositionVacantService.update(workpositionvacant);
        LOGGER.debug("WorkPositionVacant details with id: {}" , workpositionvacant);

        return workpositionvacant;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the WorkPositionVacant instance associated with the given id.")
    public boolean deleteWorkPositionVacant(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting WorkPositionVacant with id: {}" , id);

        WorkPositionVacant deletedWorkPositionVacant = workPositionVacantService.delete(id);

        return deletedWorkPositionVacant != null;
    }
    /**
     * @deprecated Use {@link #findWorkPositionVacants(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of WorkPositionVacant instances matching the search criteria.")
	public Page<WorkPositionVacant> findWorkPositionVacants( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering WorkPositionVacants list");
		return workPositionVacantService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of WorkPositionVacant instances matching the search criteria.")
    public Page<WorkPositionVacant> findWorkPositionVacants(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering WorkPositionVacants list");
    	return workPositionVacantService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportWorkPositionVacants(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return workPositionVacantService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of WorkPositionVacant instances.")
	public Long countWorkPositionVacants(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting WorkPositionVacants");
		return workPositionVacantService.count(query);
	}

    @RequestMapping(value="/{id:.+}/applicantToPositionsForFkWorkPositionVacant", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the applicantToPositionsForFkWorkPositionVacant instance associated with the given id.")
     public Page<ApplicantToPosition>
        findAssociatedApplicantToPositionsForFkWorkPositionVacant(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated applicantToPositionsForFkWorkPositionVacant");
        return applicantToPositionService.findAssociatedValues(id, "ApplicantToPosition", "idWorkPositionVacant", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service WorkPositionVacantService instance
	 */
	protected void setWorkPositionVacantService(WorkPositionVacantService service) {
		this.workPositionVacantService = service;
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

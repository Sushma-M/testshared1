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
import com.testshared1.testdb_26may.ApplicantNote;
import com.testshared1.testdb_26may.service.ApplicantNoteService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ApplicantNote.
 * @see ApplicantNote
 */
@RestController("TestDB_26may.ApplicantNoteController")
@RequestMapping("/TestDB_26may/ApplicantNote")
@Api(description = "Exposes APIs to work with ApplicantNote resource.", value = "ApplicantNoteController")
public class ApplicantNoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantNoteController.class);

    @Autowired
    @Qualifier("TestDB_26may.ApplicantNoteService")
    private ApplicantNoteService applicantNoteService;

    /**
     * @deprecated Use {@link #findApplicantNotes(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ApplicantNote instances matching the search criteria.")
    public Page<ApplicantNote> findApplicantNotes(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ApplicantNotes list");
        return applicantNoteService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ApplicantNote instances matching the search criteria.")
    public Page<ApplicantNote> findApplicantNotes(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ApplicantNotes list");
        return applicantNoteService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportApplicantNotes(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return applicantNoteService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ApplicantNoteService instance
	 */
    protected void setApplicantNoteService(ApplicantNoteService service) {
        this.applicantNoteService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new ApplicantNote instance.")
    public ApplicantNote createApplicantNote(@RequestBody ApplicantNote applicantnote) {
        LOGGER.debug("Create ApplicantNote with information: {}", applicantnote);
        applicantnote = applicantNoteService.create(applicantnote);
        LOGGER.debug("Created ApplicantNote with information: {}", applicantnote);
        return applicantnote;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ApplicantNote instances.")
    public Long countApplicantNotes(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ApplicantNotes");
        return applicantNoteService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the ApplicantNote instance associated with the given id.")
    public ApplicantNote getApplicantNote(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ApplicantNote with id: {}", id);
        ApplicantNote foundApplicantNote = applicantNoteService.getById(id);
        LOGGER.debug("ApplicantNote details with id: {}", foundApplicantNote);
        return foundApplicantNote;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the ApplicantNote instance associated with the given id.")
    public ApplicantNote editApplicantNote(@PathVariable(value = "id") Integer id, @RequestBody ApplicantNote applicantnote) throws EntityNotFoundException {
        LOGGER.debug("Editing ApplicantNote with id: {}", applicantnote.getIdApplicantNote());
        applicantnote.setIdApplicantNote(id);
        applicantnote = applicantNoteService.update(applicantnote);
        LOGGER.debug("ApplicantNote details with id: {}", applicantnote);
        return applicantnote;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the ApplicantNote instance associated with the given id.")
    public boolean deleteApplicantNote(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ApplicantNote with id: {}", id);
        ApplicantNote deletedApplicantNote = applicantNoteService.delete(id);
        return deletedApplicantNote != null;
    }
}

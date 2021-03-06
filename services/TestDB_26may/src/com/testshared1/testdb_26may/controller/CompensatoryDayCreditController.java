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
import com.testshared1.testdb_26may.CompensatoryDayCredit;
import com.testshared1.testdb_26may.service.CompensatoryDayCreditService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class CompensatoryDayCredit.
 * @see CompensatoryDayCredit
 */
@RestController("TestDB_26may.CompensatoryDayCreditController")
@RequestMapping("/TestDB_26may/CompensatoryDayCredit")
@Api(description = "Exposes APIs to work with CompensatoryDayCredit resource.", value = "CompensatoryDayCreditController")
public class CompensatoryDayCreditController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompensatoryDayCreditController.class);

    @Autowired
    @Qualifier("TestDB_26may.CompensatoryDayCreditService")
    private CompensatoryDayCreditService compensatoryDayCreditService;

    /**
     * @deprecated Use {@link #findCompensatoryDayCredits(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of CompensatoryDayCredit instances matching the search criteria.")
    public Page<CompensatoryDayCredit> findCompensatoryDayCredits(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering CompensatoryDayCredits list");
        return compensatoryDayCreditService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of CompensatoryDayCredit instances matching the search criteria.")
    public Page<CompensatoryDayCredit> findCompensatoryDayCredits(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering CompensatoryDayCredits list");
        return compensatoryDayCreditService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportCompensatoryDayCredits(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return compensatoryDayCreditService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CompensatoryDayCreditService instance
	 */
    protected void setCompensatoryDayCreditService(CompensatoryDayCreditService service) {
        this.compensatoryDayCreditService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new CompensatoryDayCredit instance.")
    public CompensatoryDayCredit createCompensatoryDayCredit(@RequestBody CompensatoryDayCredit compensatorydaycredit) {
        LOGGER.debug("Create CompensatoryDayCredit with information: {}", compensatorydaycredit);
        compensatorydaycredit = compensatoryDayCreditService.create(compensatorydaycredit);
        LOGGER.debug("Created CompensatoryDayCredit with information: {}", compensatorydaycredit);
        return compensatorydaycredit;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of CompensatoryDayCredit instances.")
    public Long countCompensatoryDayCredits(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting CompensatoryDayCredits");
        return compensatoryDayCreditService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the CompensatoryDayCredit instance associated with the given id.")
    public CompensatoryDayCredit getCompensatoryDayCredit(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting CompensatoryDayCredit with id: {}", id);
        CompensatoryDayCredit foundCompensatoryDayCredit = compensatoryDayCreditService.getById(id);
        LOGGER.debug("CompensatoryDayCredit details with id: {}", foundCompensatoryDayCredit);
        return foundCompensatoryDayCredit;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the CompensatoryDayCredit instance associated with the given id.")
    public CompensatoryDayCredit editCompensatoryDayCredit(@PathVariable(value = "id") Integer id, @RequestBody CompensatoryDayCredit compensatorydaycredit) throws EntityNotFoundException {
        LOGGER.debug("Editing CompensatoryDayCredit with id: {}", compensatorydaycredit.getIdCompensatoryDayCredit());
        compensatorydaycredit.setIdCompensatoryDayCredit(id);
        compensatorydaycredit = compensatoryDayCreditService.update(compensatorydaycredit);
        LOGGER.debug("CompensatoryDayCredit details with id: {}", compensatorydaycredit);
        return compensatorydaycredit;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the CompensatoryDayCredit instance associated with the given id.")
    public boolean deleteCompensatoryDayCredit(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting CompensatoryDayCredit with id: {}", id);
        CompensatoryDayCredit deletedCompensatoryDayCredit = compensatoryDayCreditService.delete(id);
        return deletedCompensatoryDayCredit != null;
    }
}

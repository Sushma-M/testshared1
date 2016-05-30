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
import com.testshared1.testdb_26may.WorkPositionScope;
import com.testshared1.testdb_26may.service.WorkPositionScopeService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class WorkPositionScope.
 * @see WorkPositionScope
 */
@RestController("TestDB_26may.WorkPositionScopeController")
@RequestMapping("/TestDB_26may/WorkPositionScope")
@Api(description = "Exposes APIs to work with WorkPositionScope resource.", value = "WorkPositionScopeController")
public class WorkPositionScopeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkPositionScopeController.class);

    @Autowired
    @Qualifier("TestDB_26may.WorkPositionScopeService")
    private WorkPositionScopeService workPositionScopeService;

    /**
     * @deprecated Use {@link #findWorkPositionScopes(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of WorkPositionScope instances matching the search criteria.")
    public Page<WorkPositionScope> findWorkPositionScopes(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering WorkPositionScopes list");
        return workPositionScopeService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of WorkPositionScope instances matching the search criteria.")
    public Page<WorkPositionScope> findWorkPositionScopes(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering WorkPositionScopes list");
        return workPositionScopeService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportWorkPositionScopes(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return workPositionScopeService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service WorkPositionScopeService instance
	 */
    protected void setWorkPositionScopeService(WorkPositionScopeService service) {
        this.workPositionScopeService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new WorkPositionScope instance.")
    public WorkPositionScope createWorkPositionScope(@RequestBody WorkPositionScope workpositionscope) {
        LOGGER.debug("Create WorkPositionScope with information: {}", workpositionscope);
        workpositionscope = workPositionScopeService.create(workpositionscope);
        LOGGER.debug("Created WorkPositionScope with information: {}", workpositionscope);
        return workpositionscope;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of WorkPositionScope instances.")
    public Long countWorkPositionScopes(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting WorkPositionScopes");
        return workPositionScopeService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the WorkPositionScope instance associated with the given id.")
    public WorkPositionScope getWorkPositionScope(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting WorkPositionScope with id: {}", id);
        WorkPositionScope foundWorkPositionScope = workPositionScopeService.getById(id);
        LOGGER.debug("WorkPositionScope details with id: {}", foundWorkPositionScope);
        return foundWorkPositionScope;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the WorkPositionScope instance associated with the given id.")
    public WorkPositionScope editWorkPositionScope(@PathVariable(value = "id") Integer id, @RequestBody WorkPositionScope workpositionscope) throws EntityNotFoundException {
        LOGGER.debug("Editing WorkPositionScope with id: {}", workpositionscope.getIdWorkPositionScope());
        workpositionscope.setIdWorkPositionScope(id);
        workpositionscope = workPositionScopeService.update(workpositionscope);
        LOGGER.debug("WorkPositionScope details with id: {}", workpositionscope);
        return workpositionscope;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the WorkPositionScope instance associated with the given id.")
    public boolean deleteWorkPositionScope(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting WorkPositionScope with id: {}", id);
        WorkPositionScope deletedWorkPositionScope = workPositionScopeService.delete(id);
        return deletedWorkPositionScope != null;
    }
}

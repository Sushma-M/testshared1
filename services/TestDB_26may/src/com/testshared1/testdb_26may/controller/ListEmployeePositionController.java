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
import com.testshared1.testdb_26may.ListEmployeePosition;
import com.testshared1.testdb_26may.service.ListEmployeePositionService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ListEmployeePosition.
 * @see ListEmployeePosition
 */
@RestController("TestDB_26may.ListEmployeePositionController")
@RequestMapping("/TestDB_26may/ListEmployeePosition")
@Api(description = "Exposes APIs to work with ListEmployeePosition resource.", value = "ListEmployeePositionController")
public class ListEmployeePositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListEmployeePositionController.class);

    @Autowired
    @Qualifier("TestDB_26may.ListEmployeePositionService")
    private ListEmployeePositionService listEmployeePositionService;

    /**
     * @deprecated Use {@link #findListEmployeePositions(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ListEmployeePosition instances matching the search criteria.")
    public Page<ListEmployeePosition> findListEmployeePositions(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ListEmployeePositions list");
        return listEmployeePositionService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ListEmployeePosition instances matching the search criteria.")
    public Page<ListEmployeePosition> findListEmployeePositions(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ListEmployeePositions list");
        return listEmployeePositionService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportListEmployeePositions(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return listEmployeePositionService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListEmployeePositionService instance
	 */
    protected void setListEmployeePositionService(ListEmployeePositionService service) {
        this.listEmployeePositionService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new ListEmployeePosition instance.")
    public ListEmployeePosition createListEmployeePosition(@RequestBody ListEmployeePosition listemployeeposition) {
        LOGGER.debug("Create ListEmployeePosition with information: {}", listemployeeposition);
        listemployeeposition = listEmployeePositionService.create(listemployeeposition);
        LOGGER.debug("Created ListEmployeePosition with information: {}", listemployeeposition);
        return listemployeeposition;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ListEmployeePosition instances.")
    public Long countListEmployeePositions(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ListEmployeePositions");
        return listEmployeePositionService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the ListEmployeePosition instance associated with the given id.")
    public ListEmployeePosition getListEmployeePosition(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ListEmployeePosition with id: {}", id);
        ListEmployeePosition foundListEmployeePosition = listEmployeePositionService.getById(id);
        LOGGER.debug("ListEmployeePosition details with id: {}", foundListEmployeePosition);
        return foundListEmployeePosition;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the ListEmployeePosition instance associated with the given id.")
    public ListEmployeePosition editListEmployeePosition(@PathVariable(value = "id") Integer id, @RequestBody ListEmployeePosition listemployeeposition) throws EntityNotFoundException {
        LOGGER.debug("Editing ListEmployeePosition with id: {}", listemployeeposition.getIdListEmployeePosition());
        listemployeeposition.setIdListEmployeePosition(id);
        listemployeeposition = listEmployeePositionService.update(listemployeeposition);
        LOGGER.debug("ListEmployeePosition details with id: {}", listemployeeposition);
        return listemployeeposition;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the ListEmployeePosition instance associated with the given id.")
    public boolean deleteListEmployeePosition(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListEmployeePosition with id: {}", id);
        ListEmployeePosition deletedListEmployeePosition = listEmployeePositionService.delete(id);
        return deletedListEmployeePosition != null;
    }
}

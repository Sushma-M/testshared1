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
import com.testshared1.testdb_26may.ListAssetUnloaded;
import com.testshared1.testdb_26may.service.ListAssetUnloadedService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ListAssetUnloaded.
 * @see ListAssetUnloaded
 */
@RestController("TestDB_26may.ListAssetUnloadedController")
@RequestMapping("/TestDB_26may/ListAssetUnloaded")
@Api(description = "Exposes APIs to work with ListAssetUnloaded resource.", value = "ListAssetUnloadedController")
public class ListAssetUnloadedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListAssetUnloadedController.class);

    @Autowired
    @Qualifier("TestDB_26may.ListAssetUnloadedService")
    private ListAssetUnloadedService listAssetUnloadedService;

    /**
     * @deprecated Use {@link #findListAssetUnloadeds(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ListAssetUnloaded instances matching the search criteria.")
    public Page<ListAssetUnloaded> findListAssetUnloadeds(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ListAssetUnloadeds list");
        return listAssetUnloadedService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ListAssetUnloaded instances matching the search criteria.")
    public Page<ListAssetUnloaded> findListAssetUnloadeds(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ListAssetUnloadeds list");
        return listAssetUnloadedService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportListAssetUnloadeds(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return listAssetUnloadedService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListAssetUnloadedService instance
	 */
    protected void setListAssetUnloadedService(ListAssetUnloadedService service) {
        this.listAssetUnloadedService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new ListAssetUnloaded instance.")
    public ListAssetUnloaded createListAssetUnloaded(@RequestBody ListAssetUnloaded listassetunloaded) {
        LOGGER.debug("Create ListAssetUnloaded with information: {}", listassetunloaded);
        listassetunloaded = listAssetUnloadedService.create(listassetunloaded);
        LOGGER.debug("Created ListAssetUnloaded with information: {}", listassetunloaded);
        return listassetunloaded;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ListAssetUnloaded instances.")
    public Long countListAssetUnloadeds(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ListAssetUnloadeds");
        return listAssetUnloadedService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the ListAssetUnloaded instance associated with the given id.")
    public ListAssetUnloaded getListAssetUnloaded(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ListAssetUnloaded with id: {}", id);
        ListAssetUnloaded foundListAssetUnloaded = listAssetUnloadedService.getById(id);
        LOGGER.debug("ListAssetUnloaded details with id: {}", foundListAssetUnloaded);
        return foundListAssetUnloaded;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the ListAssetUnloaded instance associated with the given id.")
    public ListAssetUnloaded editListAssetUnloaded(@PathVariable(value = "id") Integer id, @RequestBody ListAssetUnloaded listassetunloaded) throws EntityNotFoundException {
        LOGGER.debug("Editing ListAssetUnloaded with id: {}", listassetunloaded.getIdListAssetUnloaded());
        listassetunloaded.setIdListAssetUnloaded(id);
        listassetunloaded = listAssetUnloadedService.update(listassetunloaded);
        LOGGER.debug("ListAssetUnloaded details with id: {}", listassetunloaded);
        return listassetunloaded;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the ListAssetUnloaded instance associated with the given id.")
    public boolean deleteListAssetUnloaded(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListAssetUnloaded with id: {}", id);
        ListAssetUnloaded deletedListAssetUnloaded = listAssetUnloadedService.delete(id);
        return deletedListAssetUnloaded != null;
    }
}

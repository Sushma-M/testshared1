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
import com.testshared1.testdb_26may.ListAssetReintegrated;
import com.testshared1.testdb_26may.service.ListAssetReintegratedService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ListAssetReintegrated.
 * @see ListAssetReintegrated
 */
@RestController("TestDB_26may.ListAssetReintegratedController")
@RequestMapping("/TestDB_26may/ListAssetReintegrated")
@Api(description = "Exposes APIs to work with ListAssetReintegrated resource.", value = "ListAssetReintegratedController")
public class ListAssetReintegratedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListAssetReintegratedController.class);

    @Autowired
    @Qualifier("TestDB_26may.ListAssetReintegratedService")
    private ListAssetReintegratedService listAssetReintegratedService;

    /**
     * @deprecated Use {@link #findListAssetReintegrateds(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ListAssetReintegrated instances matching the search criteria.")
    public Page<ListAssetReintegrated> findListAssetReintegrateds(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ListAssetReintegrateds list");
        return listAssetReintegratedService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ListAssetReintegrated instances matching the search criteria.")
    public Page<ListAssetReintegrated> findListAssetReintegrateds(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ListAssetReintegrateds list");
        return listAssetReintegratedService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportListAssetReintegrateds(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return listAssetReintegratedService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListAssetReintegratedService instance
	 */
    protected void setListAssetReintegratedService(ListAssetReintegratedService service) {
        this.listAssetReintegratedService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new ListAssetReintegrated instance.")
    public ListAssetReintegrated createListAssetReintegrated(@RequestBody ListAssetReintegrated listassetreintegrated) {
        LOGGER.debug("Create ListAssetReintegrated with information: {}", listassetreintegrated);
        listassetreintegrated = listAssetReintegratedService.create(listassetreintegrated);
        LOGGER.debug("Created ListAssetReintegrated with information: {}", listassetreintegrated);
        return listassetreintegrated;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ListAssetReintegrated instances.")
    public Long countListAssetReintegrateds(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ListAssetReintegrateds");
        return listAssetReintegratedService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the ListAssetReintegrated instance associated with the given id.")
    public ListAssetReintegrated getListAssetReintegrated(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ListAssetReintegrated with id: {}", id);
        ListAssetReintegrated foundListAssetReintegrated = listAssetReintegratedService.getById(id);
        LOGGER.debug("ListAssetReintegrated details with id: {}", foundListAssetReintegrated);
        return foundListAssetReintegrated;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the ListAssetReintegrated instance associated with the given id.")
    public ListAssetReintegrated editListAssetReintegrated(@PathVariable(value = "id") Integer id, @RequestBody ListAssetReintegrated listassetreintegrated) throws EntityNotFoundException {
        LOGGER.debug("Editing ListAssetReintegrated with id: {}", listassetreintegrated.getIdListAssetReintegrated());
        listassetreintegrated.setIdListAssetReintegrated(id);
        listassetreintegrated = listAssetReintegratedService.update(listassetreintegrated);
        LOGGER.debug("ListAssetReintegrated details with id: {}", listassetreintegrated);
        return listassetreintegrated;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the ListAssetReintegrated instance associated with the given id.")
    public boolean deleteListAssetReintegrated(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListAssetReintegrated with id: {}", id);
        ListAssetReintegrated deletedListAssetReintegrated = listAssetReintegratedService.delete(id);
        return deletedListAssetReintegrated != null;
    }
}

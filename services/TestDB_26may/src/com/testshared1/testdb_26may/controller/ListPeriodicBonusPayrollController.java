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
import com.testshared1.testdb_26may.ListPeriodicBonusPayroll;
import com.testshared1.testdb_26may.service.ListPeriodicBonusPayrollService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ListPeriodicBonusPayroll.
 * @see ListPeriodicBonusPayroll
 */
@RestController("TestDB_26may.ListPeriodicBonusPayrollController")
@RequestMapping("/TestDB_26may/ListPeriodicBonusPayroll")
@Api(description = "Exposes APIs to work with ListPeriodicBonusPayroll resource.", value = "ListPeriodicBonusPayrollController")
public class ListPeriodicBonusPayrollController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListPeriodicBonusPayrollController.class);

    @Autowired
    @Qualifier("TestDB_26may.ListPeriodicBonusPayrollService")
    private ListPeriodicBonusPayrollService listPeriodicBonusPayrollService;

    /**
     * @deprecated Use {@link #findListPeriodicBonusPayrolls(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ListPeriodicBonusPayroll instances matching the search criteria.")
    public Page<ListPeriodicBonusPayroll> findListPeriodicBonusPayrolls(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ListPeriodicBonusPayrolls list");
        return listPeriodicBonusPayrollService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ListPeriodicBonusPayroll instances matching the search criteria.")
    public Page<ListPeriodicBonusPayroll> findListPeriodicBonusPayrolls(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ListPeriodicBonusPayrolls list");
        return listPeriodicBonusPayrollService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportListPeriodicBonusPayrolls(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return listPeriodicBonusPayrollService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicBonusPayrollService instance
	 */
    protected void setListPeriodicBonusPayrollService(ListPeriodicBonusPayrollService service) {
        this.listPeriodicBonusPayrollService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new ListPeriodicBonusPayroll instance.")
    public ListPeriodicBonusPayroll createListPeriodicBonusPayroll(@RequestBody ListPeriodicBonusPayroll listperiodicbonuspayroll) {
        LOGGER.debug("Create ListPeriodicBonusPayroll with information: {}", listperiodicbonuspayroll);
        listperiodicbonuspayroll = listPeriodicBonusPayrollService.create(listperiodicbonuspayroll);
        LOGGER.debug("Created ListPeriodicBonusPayroll with information: {}", listperiodicbonuspayroll);
        return listperiodicbonuspayroll;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ListPeriodicBonusPayroll instances.")
    public Long countListPeriodicBonusPayrolls(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ListPeriodicBonusPayrolls");
        return listPeriodicBonusPayrollService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the ListPeriodicBonusPayroll instance associated with the given id.")
    public ListPeriodicBonusPayroll getListPeriodicBonusPayroll(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting ListPeriodicBonusPayroll with id: {}", id);
        ListPeriodicBonusPayroll foundListPeriodicBonusPayroll = listPeriodicBonusPayrollService.getById(id);
        LOGGER.debug("ListPeriodicBonusPayroll details with id: {}", foundListPeriodicBonusPayroll);
        return foundListPeriodicBonusPayroll;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the ListPeriodicBonusPayroll instance associated with the given id.")
    public ListPeriodicBonusPayroll editListPeriodicBonusPayroll(@PathVariable(value = "id") Integer id, @RequestBody ListPeriodicBonusPayroll listperiodicbonuspayroll) throws EntityNotFoundException {
        LOGGER.debug("Editing ListPeriodicBonusPayroll with id: {}", listperiodicbonuspayroll.getIdListPeriodicBonusPayroll());
        listperiodicbonuspayroll.setIdListPeriodicBonusPayroll(id);
        listperiodicbonuspayroll = listPeriodicBonusPayrollService.update(listperiodicbonuspayroll);
        LOGGER.debug("ListPeriodicBonusPayroll details with id: {}", listperiodicbonuspayroll);
        return listperiodicbonuspayroll;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the ListPeriodicBonusPayroll instance associated with the given id.")
    public boolean deleteListPeriodicBonusPayroll(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ListPeriodicBonusPayroll with id: {}", id);
        ListPeriodicBonusPayroll deletedListPeriodicBonusPayroll = listPeriodicBonusPayrollService.delete(id);
        return deletedListPeriodicBonusPayroll != null;
    }
}

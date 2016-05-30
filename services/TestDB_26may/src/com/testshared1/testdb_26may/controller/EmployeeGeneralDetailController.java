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
import com.testshared1.testdb_26may.EmployeeGeneralDetail;
import com.testshared1.testdb_26may.service.EmployeeGeneralDetailService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class EmployeeGeneralDetail.
 * @see EmployeeGeneralDetail
 */
@RestController("TestDB_26may.EmployeeGeneralDetailController")
@RequestMapping("/TestDB_26may/EmployeeGeneralDetail")
@Api(description = "Exposes APIs to work with EmployeeGeneralDetail resource.", value = "EmployeeGeneralDetailController")
public class EmployeeGeneralDetailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeGeneralDetailController.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeeGeneralDetailService")
    private EmployeeGeneralDetailService employeeGeneralDetailService;

    /**
     * @deprecated Use {@link #findEmployeeGeneralDetails(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of EmployeeGeneralDetail instances matching the search criteria.")
    public Page<EmployeeGeneralDetail> findEmployeeGeneralDetails(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering EmployeeGeneralDetails list");
        return employeeGeneralDetailService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of EmployeeGeneralDetail instances matching the search criteria.")
    public Page<EmployeeGeneralDetail> findEmployeeGeneralDetails(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeeGeneralDetails list");
        return employeeGeneralDetailService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportEmployeeGeneralDetails(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return employeeGeneralDetailService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeGeneralDetailService instance
	 */
    protected void setEmployeeGeneralDetailService(EmployeeGeneralDetailService service) {
        this.employeeGeneralDetailService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new EmployeeGeneralDetail instance.")
    public EmployeeGeneralDetail createEmployeeGeneralDetail(@RequestBody EmployeeGeneralDetail employeegeneraldetail) {
        LOGGER.debug("Create EmployeeGeneralDetail with information: {}", employeegeneraldetail);
        employeegeneraldetail = employeeGeneralDetailService.create(employeegeneraldetail);
        LOGGER.debug("Created EmployeeGeneralDetail with information: {}", employeegeneraldetail);
        return employeegeneraldetail;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of EmployeeGeneralDetail instances.")
    public Long countEmployeeGeneralDetails(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting EmployeeGeneralDetails");
        return employeeGeneralDetailService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the EmployeeGeneralDetail instance associated with the given id.")
    public EmployeeGeneralDetail getEmployeeGeneralDetail(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeeGeneralDetail with id: {}", id);
        EmployeeGeneralDetail foundEmployeeGeneralDetail = employeeGeneralDetailService.getById(id);
        LOGGER.debug("EmployeeGeneralDetail details with id: {}", foundEmployeeGeneralDetail);
        return foundEmployeeGeneralDetail;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the EmployeeGeneralDetail instance associated with the given id.")
    public EmployeeGeneralDetail editEmployeeGeneralDetail(@PathVariable(value = "id") Integer id, @RequestBody EmployeeGeneralDetail employeegeneraldetail) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeeGeneralDetail with id: {}", employeegeneraldetail.getIdEmployeeGeneralDetail());
        employeegeneraldetail.setIdEmployeeGeneralDetail(id);
        employeegeneraldetail = employeeGeneralDetailService.update(employeegeneraldetail);
        LOGGER.debug("EmployeeGeneralDetail details with id: {}", employeegeneraldetail);
        return employeegeneraldetail;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the EmployeeGeneralDetail instance associated with the given id.")
    public boolean deleteEmployeeGeneralDetail(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeeGeneralDetail with id: {}", id);
        EmployeeGeneralDetail deletedEmployeeGeneralDetail = employeeGeneralDetailService.delete(id);
        return deletedEmployeeGeneralDetail != null;
    }
}

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
import com.testshared1.testdb_26may.Commission;
import com.testshared1.testdb_26may.ListCommissionEmployee;
import com.testshared1.testdb_26may.ListCommissionPayroll;
import com.testshared1.testdb_26may.service.CommissionService;
import com.testshared1.testdb_26may.service.ListCommissionEmployeeService;
import com.testshared1.testdb_26may.service.ListCommissionPayrollService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Commission.
 * @see Commission
 */
@RestController("TestDB_26may.CommissionController")
@RequestMapping("/TestDB_26may/Commission")
@Api(description = "Exposes APIs to work with Commission resource.", value = "CommissionController")
public class CommissionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommissionController.class);

    @Autowired
    @Qualifier("TestDB_26may.CommissionService")
    private CommissionService commissionService;

    @Autowired
    @Qualifier("TestDB_26may.ListCommissionEmployeeService")
    private ListCommissionEmployeeService listCommissionEmployeeService;

    @Autowired
    @Qualifier("TestDB_26may.ListCommissionPayrollService")
    private ListCommissionPayrollService listCommissionPayrollService;

    /**
     * @deprecated Use {@link #findCommissions(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Commission instances matching the search criteria.")
    public Page<Commission> findCommissions(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Commissions list");
        return commissionService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Commission instances matching the search criteria.")
    public Page<Commission> findCommissions(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Commissions list");
        return commissionService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportCommissions(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return commissionService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/listCommissionPayrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listCommissionPayrolls instance associated with the given id.")
    public Page<ListCommissionPayroll> findAssociatedListCommissionPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listCommissionPayrolls");
        return listCommissionPayrollService.findAssociatedValues(id, "ListCommissionPayroll", "idCommission", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listCommissionEmployees", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listCommissionEmployees instance associated with the given id.")
    public Page<ListCommissionEmployee> findAssociatedListCommissionEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listCommissionEmployees");
        return listCommissionEmployeeService.findAssociatedValues(id, "ListCommissionEmployee", "idCommission", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CommissionService instance
	 */
    protected void setCommissionService(CommissionService service) {
        this.commissionService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListCommissionEmployeeService instance
	 */
    protected void setListCommissionEmployeeService(ListCommissionEmployeeService service) {
        this.listCommissionEmployeeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListCommissionPayrollService instance
	 */
    protected void setListCommissionPayrollService(ListCommissionPayrollService service) {
        this.listCommissionPayrollService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Commission instance.")
    public Commission createCommission(@RequestBody Commission commission) {
        LOGGER.debug("Create Commission with information: {}", commission);
        commission = commissionService.create(commission);
        LOGGER.debug("Created Commission with information: {}", commission);
        return commission;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Commission instances.")
    public Long countCommissions(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Commissions");
        return commissionService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Commission instance associated with the given id.")
    public Commission getCommission(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Commission with id: {}", id);
        Commission foundCommission = commissionService.getById(id);
        LOGGER.debug("Commission details with id: {}", foundCommission);
        return foundCommission;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Commission instance associated with the given id.")
    public Commission editCommission(@PathVariable(value = "id") Integer id, @RequestBody Commission commission) throws EntityNotFoundException {
        LOGGER.debug("Editing Commission with id: {}", commission.getIdCommission());
        commission.setIdCommission(id);
        commission = commissionService.update(commission);
        LOGGER.debug("Commission details with id: {}", commission);
        return commission;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Commission instance associated with the given id.")
    public boolean deleteCommission(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Commission with id: {}", id);
        Commission deletedCommission = commissionService.delete(id);
        return deletedCommission != null;
    }
}

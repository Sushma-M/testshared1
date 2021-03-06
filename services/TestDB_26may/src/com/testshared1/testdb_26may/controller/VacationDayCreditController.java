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
import com.testshared1.testdb_26may.VacationDayCredit;
import com.testshared1.testdb_26may.service.VacationDayCreditService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class VacationDayCredit.
 * @see VacationDayCredit
 */
@RestController("TestDB_26may.VacationDayCreditController")
@RequestMapping("/TestDB_26may/VacationDayCredit")
@Api(description = "Exposes APIs to work with VacationDayCredit resource.", value = "VacationDayCreditController")
public class VacationDayCreditController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VacationDayCreditController.class);

    @Autowired
    @Qualifier("TestDB_26may.VacationDayCreditService")
    private VacationDayCreditService vacationDayCreditService;

    /**
     * @deprecated Use {@link #findVacationDayCredits(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of VacationDayCredit instances matching the search criteria.")
    public Page<VacationDayCredit> findVacationDayCredits(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VacationDayCredits list");
        return vacationDayCreditService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of VacationDayCredit instances matching the search criteria.")
    public Page<VacationDayCredit> findVacationDayCredits(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VacationDayCredits list");
        return vacationDayCreditService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportVacationDayCredits(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return vacationDayCreditService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VacationDayCreditService instance
	 */
    protected void setVacationDayCreditService(VacationDayCreditService service) {
        this.vacationDayCreditService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new VacationDayCredit instance.")
    public VacationDayCredit createVacationDayCredit(@RequestBody VacationDayCredit vacationdaycredit) {
        LOGGER.debug("Create VacationDayCredit with information: {}", vacationdaycredit);
        vacationdaycredit = vacationDayCreditService.create(vacationdaycredit);
        LOGGER.debug("Created VacationDayCredit with information: {}", vacationdaycredit);
        return vacationdaycredit;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of VacationDayCredit instances.")
    public Long countVacationDayCredits(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting VacationDayCredits");
        return vacationDayCreditService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the VacationDayCredit instance associated with the given id.")
    public VacationDayCredit getVacationDayCredit(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting VacationDayCredit with id: {}", id);
        VacationDayCredit foundVacationDayCredit = vacationDayCreditService.getById(id);
        LOGGER.debug("VacationDayCredit details with id: {}", foundVacationDayCredit);
        return foundVacationDayCredit;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the VacationDayCredit instance associated with the given id.")
    public VacationDayCredit editVacationDayCredit(@PathVariable(value = "id") Integer id, @RequestBody VacationDayCredit vacationdaycredit) throws EntityNotFoundException {
        LOGGER.debug("Editing VacationDayCredit with id: {}", vacationdaycredit.getIdVacationDayCredit());
        vacationdaycredit.setIdVacationDayCredit(id);
        vacationdaycredit = vacationDayCreditService.update(vacationdaycredit);
        LOGGER.debug("VacationDayCredit details with id: {}", vacationdaycredit);
        return vacationdaycredit;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the VacationDayCredit instance associated with the given id.")
    public boolean deleteVacationDayCredit(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting VacationDayCredit with id: {}", id);
        VacationDayCredit deletedVacationDayCredit = vacationDayCreditService.delete(id);
        return deletedVacationDayCredit != null;
    }
}

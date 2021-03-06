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
import com.testshared1.testdb_26may.JustifiedAbsense;
import com.testshared1.testdb_26may.TypeAbsenceJustification;
import com.testshared1.testdb_26may.service.JustifiedAbsenseService;
import com.testshared1.testdb_26may.service.TypeAbsenceJustificationService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class TypeAbsenceJustification.
 * @see TypeAbsenceJustification
 */
@RestController("TestDB_26may.TypeAbsenceJustificationController")
@RequestMapping("/TestDB_26may/TypeAbsenceJustification")
@Api(description = "Exposes APIs to work with TypeAbsenceJustification resource.", value = "TypeAbsenceJustificationController")
public class TypeAbsenceJustificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeAbsenceJustificationController.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeAbsenceJustificationService")
    private TypeAbsenceJustificationService typeAbsenceJustificationService;

    @Autowired
    @Qualifier("TestDB_26may.JustifiedAbsenseService")
    private JustifiedAbsenseService justifiedAbsenseService;

    /**
     * @deprecated Use {@link #findTypeAbsenceJustifications(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of TypeAbsenceJustification instances matching the search criteria.")
    public Page<TypeAbsenceJustification> findTypeAbsenceJustifications(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TypeAbsenceJustifications list");
        return typeAbsenceJustificationService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeAbsenceJustification instances matching the search criteria.")
    public Page<TypeAbsenceJustification> findTypeAbsenceJustifications(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeAbsenceJustifications list");
        return typeAbsenceJustificationService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeAbsenceJustifications(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return typeAbsenceJustificationService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/justifiedAbsenses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the justifiedAbsenses instance associated with the given id.")
    public Page<JustifiedAbsense> findAssociatedJustifiedAbsenses(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated justifiedAbsenses");
        return justifiedAbsenseService.findAssociatedValues(id, "JustifiedAbsense", "idTypeAbsenceJustification", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeAbsenceJustificationService instance
	 */
    protected void setTypeAbsenceJustificationService(TypeAbsenceJustificationService service) {
        this.typeAbsenceJustificationService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service JustifiedAbsenseService instance
	 */
    protected void setJustifiedAbsenseService(JustifiedAbsenseService service) {
        this.justifiedAbsenseService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new TypeAbsenceJustification instance.")
    public TypeAbsenceJustification createTypeAbsenceJustification(@RequestBody TypeAbsenceJustification typeabsencejustification) {
        LOGGER.debug("Create TypeAbsenceJustification with information: {}", typeabsencejustification);
        typeabsencejustification = typeAbsenceJustificationService.create(typeabsencejustification);
        LOGGER.debug("Created TypeAbsenceJustification with information: {}", typeabsencejustification);
        return typeabsencejustification;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of TypeAbsenceJustification instances.")
    public Long countTypeAbsenceJustifications(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TypeAbsenceJustifications");
        return typeAbsenceJustificationService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the TypeAbsenceJustification instance associated with the given id.")
    public TypeAbsenceJustification getTypeAbsenceJustification(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeAbsenceJustification with id: {}", id);
        TypeAbsenceJustification foundTypeAbsenceJustification = typeAbsenceJustificationService.getById(id);
        LOGGER.debug("TypeAbsenceJustification details with id: {}", foundTypeAbsenceJustification);
        return foundTypeAbsenceJustification;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the TypeAbsenceJustification instance associated with the given id.")
    public TypeAbsenceJustification editTypeAbsenceJustification(@PathVariable(value = "id") Integer id, @RequestBody TypeAbsenceJustification typeabsencejustification) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeAbsenceJustification with id: {}", typeabsencejustification.getIdTypeAbsenceJustification());
        typeabsencejustification.setIdTypeAbsenceJustification(id);
        typeabsencejustification = typeAbsenceJustificationService.update(typeabsencejustification);
        LOGGER.debug("TypeAbsenceJustification details with id: {}", typeabsencejustification);
        return typeabsencejustification;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the TypeAbsenceJustification instance associated with the given id.")
    public boolean deleteTypeAbsenceJustification(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeAbsenceJustification with id: {}", id);
        TypeAbsenceJustification deletedTypeAbsenceJustification = typeAbsenceJustificationService.delete(id);
        return deletedTypeAbsenceJustification != null;
    }
}

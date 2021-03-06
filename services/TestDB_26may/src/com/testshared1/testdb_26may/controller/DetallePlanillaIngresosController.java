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
import com.testshared1.testdb_26may.DetallePlanillaIngresos;
import com.testshared1.testdb_26may.DetallePlanillaIngresosId;
import com.testshared1.testdb_26may.service.DetallePlanillaIngresosService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class DetallePlanillaIngresos.
 * @see DetallePlanillaIngresos
 */
@RestController("TestDB_26may.DetallePlanillaIngresosController")
@RequestMapping("/TestDB_26may/DetallePlanillaIngresos")
@Api(description = "Exposes APIs to work with DetallePlanillaIngresos resource.", value = "DetallePlanillaIngresosController")
public class DetallePlanillaIngresosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DetallePlanillaIngresosController.class);

    @Autowired
    @Qualifier("TestDB_26may.DetallePlanillaIngresosService")
    private DetallePlanillaIngresosService detallePlanillaIngresosService;

    /**
     * @deprecated Use {@link #findDetallePlanillaIngresos(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of DetallePlanillaIngresos instances matching the search criteria.")
    public Page<DetallePlanillaIngresos> findDetallePlanillaIngresos(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DetallePlanillaIngresos list");
        return detallePlanillaIngresosService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of DetallePlanillaIngresos instances matching the search criteria.")
    public Page<DetallePlanillaIngresos> findDetallePlanillaIngresos(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DetallePlanillaIngresos list");
        return detallePlanillaIngresosService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportDetallePlanillaIngresos(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return detallePlanillaIngresosService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DetallePlanillaIngresosService instance
	 */
    protected void setDetallePlanillaIngresosService(DetallePlanillaIngresosService service) {
        this.detallePlanillaIngresosService = service;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the DetallePlanillaIngresos instance associated with the given composite-id.")
    public DetallePlanillaIngresos getDetallePlanillaIngresos(@RequestParam(value = "idPayrollDetail", required = true) Integer idPayrollDetail, @RequestParam(value = "type_", required = true) String type_, @RequestParam(value = "code", required = true) String code, @RequestParam(value = "description_", required = true) String description_, @RequestParam(value = "currency", required = true) String currency, @RequestParam(value = "value_", required = true) Double value_) throws EntityNotFoundException {
        DetallePlanillaIngresosId detalleplanillaingresosId = new DetallePlanillaIngresosId();
        detalleplanillaingresosId.setIdPayrollDetail(idPayrollDetail);
        detalleplanillaingresosId.setType_(type_);
        detalleplanillaingresosId.setCode(code);
        detalleplanillaingresosId.setDescription_(description_);
        detalleplanillaingresosId.setCurrency(currency);
        detalleplanillaingresosId.setValue_(value_);
        LOGGER.debug("Getting DetallePlanillaIngresos with id: {}", detalleplanillaingresosId);
        DetallePlanillaIngresos detalleplanillaingresos = detallePlanillaIngresosService.getById(detalleplanillaingresosId);
        LOGGER.debug("DetallePlanillaIngresos details with id: {}", detalleplanillaingresos);
        return detalleplanillaingresos;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of DetallePlanillaIngresos instances.")
    public Long countDetallePlanillaIngresos(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting DetallePlanillaIngresos");
        return detallePlanillaIngresosService.count(query);
    }
}

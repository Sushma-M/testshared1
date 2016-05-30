/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.testshared1.testdb_26may.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.TypeMismatchException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testshared1.testdb_26may.EmployeePhotoFile;
import com.testshared1.testdb_26may.service.EmployeePhotoFileService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class EmployeePhotoFile.
 * @see EmployeePhotoFile
 */
@RestController("TestDB_26may.EmployeePhotoFileController")
@RequestMapping("/TestDB_26may/EmployeePhotoFile")
@Api(description = "Exposes APIs to work with EmployeePhotoFile resource.", value = "EmployeePhotoFileController")
public class EmployeePhotoFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePhotoFileController.class);

    @Autowired
    @Qualifier("TestDB_26may.EmployeePhotoFileService")
    private EmployeePhotoFileService employeePhotoFileService;

    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Retrieves content for the given BLOB field in EmployeePhotoFile instance")
    public DownloadResponse getEmployeePhotoFileBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value = "download", defaultValue = "false") boolean download) {
        LOGGER.debug("Retrieves content for the given BLOB field {} in EmployeePhotoFile instance", fieldName);
        if (!WMRuntimeUtils.isLob(EmployeePhotoFile.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        EmployeePhotoFile employeephotofile = employeePhotoFileService.getById(id);
        return WMMultipartUtils.buildDownloadResponseForBlob(employeephotofile, fieldName, httpServletRequest, download);
    }

    /**
     * @deprecated Use {@link #findEmployeePhotoFiles(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of EmployeePhotoFile instances matching the search criteria.")
    public Page<EmployeePhotoFile> findEmployeePhotoFiles(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering EmployeePhotoFiles list");
        return employeePhotoFileService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of EmployeePhotoFile instances matching the search criteria.")
    public Page<EmployeePhotoFile> findEmployeePhotoFiles(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeePhotoFiles list");
        return employeePhotoFileService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportEmployeePhotoFiles(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return employeePhotoFileService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeePhotoFileService instance
	 */
    protected void setEmployeePhotoFileService(EmployeePhotoFileService service) {
        this.employeePhotoFileService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new EmployeePhotoFile instance.")
    public EmployeePhotoFile createEmployeePhotoFile(@RequestBody EmployeePhotoFile employeephotofile) {
        LOGGER.debug("Create EmployeePhotoFile with information: {}", employeephotofile);
        employeephotofile = employeePhotoFileService.create(employeephotofile);
        LOGGER.debug("Created EmployeePhotoFile with information: {}", employeephotofile);
        return employeephotofile;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new EmployeePhotoFile instance.This API should be used when the EmployeePhotoFile instance has fields that requires multipart data.")
    public EmployeePhotoFile createEmployeePhotoFile(MultipartHttpServletRequest multipartHttpServletRequest) {
        EmployeePhotoFile employeephotofile = WMMultipartUtils.toObject(multipartHttpServletRequest, EmployeePhotoFile.class, "TestDB_26may");
        LOGGER.debug("Creating a new EmployeePhotoFile with information: {}", employeephotofile);
        return employeePhotoFileService.create(employeephotofile);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of EmployeePhotoFile instances.")
    public Long countEmployeePhotoFiles(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting EmployeePhotoFiles");
        return employeePhotoFileService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the EmployeePhotoFile instance associated with the given id.")
    public EmployeePhotoFile getEmployeePhotoFile(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting EmployeePhotoFile with id: {}", id);
        EmployeePhotoFile foundEmployeePhotoFile = employeePhotoFileService.getById(id);
        LOGGER.debug("EmployeePhotoFile details with id: {}", foundEmployeePhotoFile);
        return foundEmployeePhotoFile;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the EmployeePhotoFile instance associated with the given id.")
    public EmployeePhotoFile editEmployeePhotoFile(@PathVariable(value = "id") Integer id, @RequestBody EmployeePhotoFile employeephotofile) throws EntityNotFoundException {
        LOGGER.debug("Editing EmployeePhotoFile with id: {}", employeephotofile.getIdEmployeePhotoFile());
        employeephotofile.setIdEmployeePhotoFile(id);
        employeephotofile = employeePhotoFileService.update(employeephotofile);
        LOGGER.debug("EmployeePhotoFile details with id: {}", employeephotofile);
        return employeephotofile;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the EmployeePhotoFile instance associated with the given id.This API should be used when EmployeePhotoFile instance fields that require multipart data.")
    public EmployeePhotoFile editEmployeePhotoFile(@PathVariable(value = "id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        EmployeePhotoFile newEmployeePhotoFile = WMMultipartUtils.toObject(multipartHttpServletRequest, EmployeePhotoFile.class, "TestDB_26may");
        newEmployeePhotoFile.setIdEmployeePhotoFile(id);
        EmployeePhotoFile oldEmployeePhotoFile = employeePhotoFileService.getById(id);
        WMMultipartUtils.updateLobsContent(oldEmployeePhotoFile, newEmployeePhotoFile);
        LOGGER.debug("Updating EmployeePhotoFile with information: {}", newEmployeePhotoFile);
        return employeePhotoFileService.update(newEmployeePhotoFile);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the EmployeePhotoFile instance associated with the given id.")
    public boolean deleteEmployeePhotoFile(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting EmployeePhotoFile with id: {}", id);
        EmployeePhotoFile deletedEmployeePhotoFile = employeePhotoFileService.delete(id);
        return deletedEmployeePhotoFile != null;
    }
}

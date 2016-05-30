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

import com.testshared1.testdb_26may.AssetFile;
import com.testshared1.testdb_26may.service.AssetFileService;


/**
 * Controller object for domain model class AssetFile.
 * @see AssetFile
 */
@RestController("TestDB_26may.AssetFileController")
@Api(value = "/TestDB_26may/AssetFile", description = "Exposes APIs to work with AssetFile resource.")
@RequestMapping("/TestDB_26may/AssetFile")
public class AssetFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetFileController.class);

    @Autowired
	@Qualifier("TestDB_26may.AssetFileService")
	private AssetFileService assetFileService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new AssetFile instance.")
	public AssetFile createAssetFile(@RequestBody AssetFile assetfile) {
		LOGGER.debug("Create AssetFile with information: {}" , assetfile);

		assetfile = assetFileService.create(assetfile);
		LOGGER.debug("Created AssetFile with information: {}" , assetfile);

	    return assetfile;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the AssetFile instance associated with the given id.")
    public AssetFile getAssetFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AssetFile with id: {}" , id);

        AssetFile foundAssetFile = assetFileService.getById(id);
        LOGGER.debug("AssetFile details with id: {}" , foundAssetFile);

        return foundAssetFile;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the AssetFile instance associated with the given id.")
    public AssetFile editAssetFile(@PathVariable("id") Integer id, @RequestBody AssetFile assetfile) throws EntityNotFoundException {
        LOGGER.debug("Editing AssetFile with id: {}" , assetfile.getIdAssetFile());

        assetfile.setIdAssetFile(id);
        assetfile = assetFileService.update(assetfile);
        LOGGER.debug("AssetFile details with id: {}" , assetfile);

        return assetfile;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the AssetFile instance associated with the given id.")
    public boolean deleteAssetFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AssetFile with id: {}" , id);

        AssetFile deletedAssetFile = assetFileService.delete(id);

        return deletedAssetFile != null;
    }
    /**
     * @deprecated Use {@link #findAssetFiles(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of AssetFile instances matching the search criteria.")
	public Page<AssetFile> findAssetFiles( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering AssetFiles list");
		return assetFileService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of AssetFile instances matching the search criteria.")
    public Page<AssetFile> findAssetFiles(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AssetFiles list");
    	return assetFileService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportAssetFiles(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return assetFileService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of AssetFile instances.")
	public Long countAssetFiles(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AssetFiles");
		return assetFileService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AssetFileService instance
	 */
	protected void setAssetFileService(AssetFileService service) {
		this.assetFileService = service;
	}

}


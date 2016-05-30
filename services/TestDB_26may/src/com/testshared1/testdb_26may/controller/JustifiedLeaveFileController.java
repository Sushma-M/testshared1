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

import com.testshared1.testdb_26may.JustifiedLeaveFile;
import com.testshared1.testdb_26may.service.JustifiedLeaveFileService;


/**
 * Controller object for domain model class JustifiedLeaveFile.
 * @see JustifiedLeaveFile
 */
@RestController("TestDB_26may.JustifiedLeaveFileController")
@Api(value = "/TestDB_26may/JustifiedLeaveFile", description = "Exposes APIs to work with JustifiedLeaveFile resource.")
@RequestMapping("/TestDB_26may/JustifiedLeaveFile")
public class JustifiedLeaveFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JustifiedLeaveFileController.class);

    @Autowired
	@Qualifier("TestDB_26may.JustifiedLeaveFileService")
	private JustifiedLeaveFileService justifiedLeaveFileService;


	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new JustifiedLeaveFile instance.")
	public JustifiedLeaveFile createJustifiedLeaveFile(@RequestBody JustifiedLeaveFile justifiedleavefile) {
		LOGGER.debug("Create JustifiedLeaveFile with information: {}" , justifiedleavefile);

		justifiedleavefile = justifiedLeaveFileService.create(justifiedleavefile);
		LOGGER.debug("Created JustifiedLeaveFile with information: {}" , justifiedleavefile);

	    return justifiedleavefile;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the JustifiedLeaveFile instance associated with the given id.")
    public JustifiedLeaveFile getJustifiedLeaveFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting JustifiedLeaveFile with id: {}" , id);

        JustifiedLeaveFile foundJustifiedLeaveFile = justifiedLeaveFileService.getById(id);
        LOGGER.debug("JustifiedLeaveFile details with id: {}" , foundJustifiedLeaveFile);

        return foundJustifiedLeaveFile;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the JustifiedLeaveFile instance associated with the given id.")
    public JustifiedLeaveFile editJustifiedLeaveFile(@PathVariable("id") Integer id, @RequestBody JustifiedLeaveFile justifiedleavefile) throws EntityNotFoundException {
        LOGGER.debug("Editing JustifiedLeaveFile with id: {}" , justifiedleavefile.getIdJustifiedLeaveFile());

        justifiedleavefile.setIdJustifiedLeaveFile(id);
        justifiedleavefile = justifiedLeaveFileService.update(justifiedleavefile);
        LOGGER.debug("JustifiedLeaveFile details with id: {}" , justifiedleavefile);

        return justifiedleavefile;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the JustifiedLeaveFile instance associated with the given id.")
    public boolean deleteJustifiedLeaveFile(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting JustifiedLeaveFile with id: {}" , id);

        JustifiedLeaveFile deletedJustifiedLeaveFile = justifiedLeaveFileService.delete(id);

        return deletedJustifiedLeaveFile != null;
    }
    /**
     * @deprecated Use {@link #findJustifiedLeaveFiles(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of JustifiedLeaveFile instances matching the search criteria.")
	public Page<JustifiedLeaveFile> findJustifiedLeaveFiles( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering JustifiedLeaveFiles list");
		return justifiedLeaveFileService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of JustifiedLeaveFile instances matching the search criteria.")
    public Page<JustifiedLeaveFile> findJustifiedLeaveFiles(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering JustifiedLeaveFiles list");
    	return justifiedLeaveFileService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportJustifiedLeaveFiles(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return justifiedLeaveFileService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of JustifiedLeaveFile instances.")
	public Long countJustifiedLeaveFiles(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting JustifiedLeaveFiles");
		return justifiedLeaveFileService.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service JustifiedLeaveFileService instance
	 */
	protected void setJustifiedLeaveFileService(JustifiedLeaveFileService service) {
		this.justifiedLeaveFileService = service;
	}

}

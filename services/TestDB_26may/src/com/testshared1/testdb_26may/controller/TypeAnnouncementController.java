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

import com.testshared1.testdb_26may.Announcement;
import com.testshared1.testdb_26may.TypeAnnouncement;
import com.testshared1.testdb_26may.service.AnnouncementService;
import com.testshared1.testdb_26may.service.TypeAnnouncementService;


/**
 * Controller object for domain model class TypeAnnouncement.
 * @see TypeAnnouncement
 */
@RestController("TestDB_26may.TypeAnnouncementController")
@Api(value = "/TestDB_26may/TypeAnnouncement", description = "Exposes APIs to work with TypeAnnouncement resource.")
@RequestMapping("/TestDB_26may/TypeAnnouncement")
public class TypeAnnouncementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeAnnouncementController.class);

    @Autowired
	@Qualifier("TestDB_26may.TypeAnnouncementService")
	private TypeAnnouncementService typeAnnouncementService;

    @Autowired
	@Qualifier("TestDB_26may.AnnouncementService")
	private AnnouncementService announcementService;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Creates a new TypeAnnouncement instance.")
	public TypeAnnouncement createTypeAnnouncement(@RequestBody TypeAnnouncement typeannouncement) {
		LOGGER.debug("Create TypeAnnouncement with information: {}" , typeannouncement);

		typeannouncement = typeAnnouncementService.create(typeannouncement);
		LOGGER.debug("Created TypeAnnouncement with information: {}" , typeannouncement);

	    return typeannouncement;
	}


    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the TypeAnnouncement instance associated with the given id.")
    public TypeAnnouncement getTypeAnnouncement(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeAnnouncement with id: {}" , id);

        TypeAnnouncement foundTypeAnnouncement = typeAnnouncementService.getById(id);
        LOGGER.debug("TypeAnnouncement details with id: {}" , foundTypeAnnouncement);

        return foundTypeAnnouncement;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the TypeAnnouncement instance associated with the given id.")
    public TypeAnnouncement editTypeAnnouncement(@PathVariable("id") Integer id, @RequestBody TypeAnnouncement typeannouncement) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeAnnouncement with id: {}" , typeannouncement.getIdTypeAnnouncement());

        typeannouncement.setIdTypeAnnouncement(id);
        typeannouncement = typeAnnouncementService.update(typeannouncement);
        LOGGER.debug("TypeAnnouncement details with id: {}" , typeannouncement);

        return typeannouncement;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the TypeAnnouncement instance associated with the given id.")
    public boolean deleteTypeAnnouncement(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeAnnouncement with id: {}" , id);

        TypeAnnouncement deletedTypeAnnouncement = typeAnnouncementService.delete(id);

        return deletedTypeAnnouncement != null;
    }
    /**
     * @deprecated Use {@link #findTypeAnnouncements(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the list of TypeAnnouncement instances matching the search criteria.")
	public Page<TypeAnnouncement> findTypeAnnouncements( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
		LOGGER.debug("Rendering TypeAnnouncements list");
		return typeAnnouncementService.findAll(queryFilters, pageable);
	}

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeAnnouncement instances matching the search criteria.")
    public Page<TypeAnnouncement> findTypeAnnouncements(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeAnnouncements list");
    	return typeAnnouncementService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeAnnouncements(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return typeAnnouncementService.export(exportType, query, pageable);
    }

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ApiOperation(value = "Returns the total count of TypeAnnouncement instances.")
	public Long countTypeAnnouncements(@RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TypeAnnouncements");
		return typeAnnouncementService.count(query);
	}

    @RequestMapping(value="/{id:.+}/announcements", method=RequestMethod.GET)
    @ApiOperation(value = "Gets the announcements instance associated with the given id.")
     public Page<Announcement>
        findAssociatedAnnouncements(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated announcements");
        return announcementService.findAssociatedValues(id, "Announcement", "idTypeAnnouncement", pageable);
   }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeAnnouncementService instance
	 */
	protected void setTypeAnnouncementService(TypeAnnouncementService service) {
		this.typeAnnouncementService = service;
	}

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AnnouncementService instance
	 */
	protected void setAnnouncementService(AnnouncementService service) {
        this.announcementService = service;
    }
}

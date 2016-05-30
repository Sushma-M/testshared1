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
import com.testshared1.testdb_26may.Asset;
import com.testshared1.testdb_26may.AssetFile;
import com.testshared1.testdb_26may.AssetPhotoFile;
import com.testshared1.testdb_26may.ListAssetDiscarded;
import com.testshared1.testdb_26may.ListAssetLoaded;
import com.testshared1.testdb_26may.ListAssetReintegrated;
import com.testshared1.testdb_26may.ListAssetUnloaded;
import com.testshared1.testdb_26may.service.AssetFileService;
import com.testshared1.testdb_26may.service.AssetPhotoFileService;
import com.testshared1.testdb_26may.service.AssetService;
import com.testshared1.testdb_26may.service.ListAssetDiscardedService;
import com.testshared1.testdb_26may.service.ListAssetLoadedService;
import com.testshared1.testdb_26may.service.ListAssetReintegratedService;
import com.testshared1.testdb_26may.service.ListAssetUnloadedService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Asset.
 * @see Asset
 */
@RestController("TestDB_26may.AssetController")
@RequestMapping("/TestDB_26may/Asset")
@Api(description = "Exposes APIs to work with Asset resource.", value = "AssetController")
public class AssetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetController.class);

    @Autowired
    @Qualifier("TestDB_26may.AssetService")
    private AssetService assetService;

    @Autowired
    @Qualifier("TestDB_26may.ListAssetReintegratedService")
    private ListAssetReintegratedService listAssetReintegratedService;

    @Autowired
    @Qualifier("TestDB_26may.AssetFileService")
    private AssetFileService assetFileService;

    @Autowired
    @Qualifier("TestDB_26may.ListAssetDiscardedService")
    private ListAssetDiscardedService listAssetDiscardedService;

    @Autowired
    @Qualifier("TestDB_26may.ListAssetLoadedService")
    private ListAssetLoadedService listAssetLoadedService;

    @Autowired
    @Qualifier("TestDB_26may.AssetPhotoFileService")
    private AssetPhotoFileService assetPhotoFileService;

    @Autowired
    @Qualifier("TestDB_26may.ListAssetUnloadedService")
    private ListAssetUnloadedService listAssetUnloadedService;

    /**
     * @deprecated Use {@link #findAssets(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Asset instances matching the search criteria.")
    public Page<Asset> findAssets(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Assets list");
        return assetService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Asset instances matching the search criteria.")
    public Page<Asset> findAssets(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Assets list");
        return assetService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportAssets(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return assetService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/listAssetDiscardeds", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listAssetDiscardeds instance associated with the given id.")
    public Page<ListAssetDiscarded> findAssociatedListAssetDiscardeds(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listAssetDiscardeds");
        return listAssetDiscardedService.findAssociatedValues(id, "ListAssetDiscarded", "idAsset", pageable);
    }

    @RequestMapping(value = "/{id:.+}/assetFiles", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the assetFiles instance associated with the given id.")
    public Page<AssetFile> findAssociatedAssetFiles(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated assetFiles");
        return assetFileService.findAssociatedValues(id, "AssetFile", "idAsset", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listAssetLoadeds", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listAssetLoadeds instance associated with the given id.")
    public Page<ListAssetLoaded> findAssociatedListAssetLoadeds(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listAssetLoadeds");
        return listAssetLoadedService.findAssociatedValues(id, "ListAssetLoaded", "idAsset", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listAssetReintegrateds", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listAssetReintegrateds instance associated with the given id.")
    public Page<ListAssetReintegrated> findAssociatedListAssetReintegrateds(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listAssetReintegrateds");
        return listAssetReintegratedService.findAssociatedValues(id, "ListAssetReintegrated", "idAsset", pageable);
    }

    @RequestMapping(value = "/{id:.+}/assetPhotoFiles", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the assetPhotoFiles instance associated with the given id.")
    public Page<AssetPhotoFile> findAssociatedAssetPhotoFiles(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated assetPhotoFiles");
        return assetPhotoFileService.findAssociatedValues(id, "AssetPhotoFile", "idAsset", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listAssetUnloadeds", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listAssetUnloadeds instance associated with the given id.")
    public Page<ListAssetUnloaded> findAssociatedListAssetUnloadeds(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listAssetUnloadeds");
        return listAssetUnloadedService.findAssociatedValues(id, "ListAssetUnloaded", "idAsset", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AssetService instance
	 */
    protected void setAssetService(AssetService service) {
        this.assetService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListAssetReintegratedService instance
	 */
    protected void setListAssetReintegratedService(ListAssetReintegratedService service) {
        this.listAssetReintegratedService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AssetFileService instance
	 */
    protected void setAssetFileService(AssetFileService service) {
        this.assetFileService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListAssetDiscardedService instance
	 */
    protected void setListAssetDiscardedService(ListAssetDiscardedService service) {
        this.listAssetDiscardedService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListAssetLoadedService instance
	 */
    protected void setListAssetLoadedService(ListAssetLoadedService service) {
        this.listAssetLoadedService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AssetPhotoFileService instance
	 */
    protected void setAssetPhotoFileService(AssetPhotoFileService service) {
        this.assetPhotoFileService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListAssetUnloadedService instance
	 */
    protected void setListAssetUnloadedService(ListAssetUnloadedService service) {
        this.listAssetUnloadedService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Asset instance.")
    public Asset createAsset(@RequestBody Asset asset) {
        LOGGER.debug("Create Asset with information: {}", asset);
        asset = assetService.create(asset);
        LOGGER.debug("Created Asset with information: {}", asset);
        return asset;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Asset instances.")
    public Long countAssets(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Assets");
        return assetService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Asset instance associated with the given id.")
    public Asset getAsset(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Asset with id: {}", id);
        Asset foundAsset = assetService.getById(id);
        LOGGER.debug("Asset details with id: {}", foundAsset);
        return foundAsset;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Asset instance associated with the given id.")
    public Asset editAsset(@PathVariable(value = "id") Integer id, @RequestBody Asset asset) throws EntityNotFoundException {
        LOGGER.debug("Editing Asset with id: {}", asset.getIdAsset());
        asset.setIdAsset(id);
        asset = assetService.update(asset);
        LOGGER.debug("Asset details with id: {}", asset);
        return asset;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Asset instance associated with the given id.")
    public boolean deleteAsset(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Asset with id: {}", id);
        Asset deletedAsset = assetService.delete(id);
        return deletedAsset != null;
    }
}

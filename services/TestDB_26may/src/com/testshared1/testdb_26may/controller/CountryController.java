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
import com.testshared1.testdb_26may.ApplicantToPosition;
import com.testshared1.testdb_26may.Country;
import com.testshared1.testdb_26may.Employee;
import com.testshared1.testdb_26may.EmployeeGeneralDetail;
import com.testshared1.testdb_26may.Location;
import com.testshared1.testdb_26may.User;
import com.testshared1.testdb_26may.service.ApplicantToPositionService;
import com.testshared1.testdb_26may.service.CountryService;
import com.testshared1.testdb_26may.service.EmployeeGeneralDetailService;
import com.testshared1.testdb_26may.service.EmployeeService;
import com.testshared1.testdb_26may.service.LocationService;
import com.testshared1.testdb_26may.service.UserService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Country.
 * @see Country
 */
@RestController("TestDB_26may.CountryController")
@RequestMapping("/TestDB_26may/Country")
@Api(description = "Exposes APIs to work with Country resource.", value = "CountryController")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    @Qualifier("TestDB_26may.CountryService")
    private CountryService countryService;

    @Autowired
    @Qualifier("TestDB_26may.LocationService")
    private LocationService locationService;

    @Autowired
    @Qualifier("TestDB_26may.EmployeeService")
    private EmployeeService employeeService;

    @Autowired
    @Qualifier("TestDB_26may.EmployeeGeneralDetailService")
    private EmployeeGeneralDetailService employeeGeneralDetailService;

    @Autowired
    @Qualifier("TestDB_26may.UserService")
    private UserService userService;

    @Autowired
    @Qualifier("TestDB_26may.ApplicantToPositionService")
    private ApplicantToPositionService applicantToPositionService;

    /**
     * @deprecated Use {@link #findCountries(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Country instances matching the search criteria.")
    public Page<Country> findCountries(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Countries list");
        return countryService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Country instances matching the search criteria.")
    public Page<Country> findCountries(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Countries list");
        return countryService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportCountries(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return countryService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/users", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the users instance associated with the given id.")
    public Page<User> findAssociatedUsers(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated users");
        return userService.findAssociatedValues(id, "User", "idCountry", pageable);
    }

    @RequestMapping(value = "/{id:.+}/locations", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the locations instance associated with the given id.")
    public Page<Location> findAssociatedLocations(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated locations");
        return locationService.findAssociatedValues(id, "Location", "idCountry", pageable);
    }

    @RequestMapping(value = "/{id:.+}/employeeGeneralDetails", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the employeeGeneralDetails instance associated with the given id.")
    public Page<EmployeeGeneralDetail> findAssociatedEmployeeGeneralDetails(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated employeeGeneralDetails");
        return employeeGeneralDetailService.findAssociatedValues(id, "EmployeeGeneralDetail", "idCountry", pageable);
    }

    @RequestMapping(value = "/{id:.+}/applicantToPositions", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the applicantToPositions instance associated with the given id.")
    public Page<ApplicantToPosition> findAssociatedApplicantToPositions(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated applicantToPositions");
        return applicantToPositionService.findAssociatedValues(id, "ApplicantToPosition", "idCountry", pageable);
    }

    @RequestMapping(value = "/{id:.+}/employees", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the employees instance associated with the given id.")
    public Page<Employee> findAssociatedEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated employees");
        return employeeService.findAssociatedValues(id, "Employee", "idCountry", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service CountryService instance
	 */
    protected void setCountryService(CountryService service) {
        this.countryService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service LocationService instance
	 */
    protected void setLocationService(LocationService service) {
        this.locationService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeService instance
	 */
    protected void setEmployeeService(EmployeeService service) {
        this.employeeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeGeneralDetailService instance
	 */
    protected void setEmployeeGeneralDetailService(EmployeeGeneralDetailService service) {
        this.employeeGeneralDetailService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UserService instance
	 */
    protected void setUserService(UserService service) {
        this.userService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ApplicantToPositionService instance
	 */
    protected void setApplicantToPositionService(ApplicantToPositionService service) {
        this.applicantToPositionService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Country instance.")
    public Country createCountry(@RequestBody Country country) {
        LOGGER.debug("Create Country with information: {}", country);
        country = countryService.create(country);
        LOGGER.debug("Created Country with information: {}", country);
        return country;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Country instances.")
    public Long countCountries(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Countries");
        return countryService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Country instance associated with the given id.")
    public Country getCountry(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Country with id: {}", id);
        Country foundCountry = countryService.getById(id);
        LOGGER.debug("Country details with id: {}", foundCountry);
        return foundCountry;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Country instance associated with the given id.")
    public Country editCountry(@PathVariable(value = "id") Integer id, @RequestBody Country country) throws EntityNotFoundException {
        LOGGER.debug("Editing Country with id: {}", country.getIdCountry());
        country.setIdCountry(id);
        country = countryService.update(country);
        LOGGER.debug("Country details with id: {}", country);
        return country;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Country instance associated with the given id.")
    public boolean deleteCountry(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Country with id: {}", id);
        Country deletedCountry = countryService.delete(id);
        return deletedCountry != null;
    }
}

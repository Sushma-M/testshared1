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
import com.testshared1.testdb_26may.EmployeeSalary;
import com.testshared1.testdb_26may.ListPeriodicBonusEmployee;
import com.testshared1.testdb_26may.ListPeriodicDeductionEmployee;
import com.testshared1.testdb_26may.Payroll;
import com.testshared1.testdb_26may.PayrollDetail;
import com.testshared1.testdb_26may.TypeGenerationForm;
import com.testshared1.testdb_26may.TypeRecruitment;
import com.testshared1.testdb_26may.service.EmployeeSalaryService;
import com.testshared1.testdb_26may.service.ListPeriodicBonusEmployeeService;
import com.testshared1.testdb_26may.service.ListPeriodicDeductionEmployeeService;
import com.testshared1.testdb_26may.service.PayrollDetailService;
import com.testshared1.testdb_26may.service.PayrollService;
import com.testshared1.testdb_26may.service.TypeGenerationFormService;
import com.testshared1.testdb_26may.service.TypeRecruitmentService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class TypeGenerationForm.
 * @see TypeGenerationForm
 */
@RestController("TestDB_26may.TypeGenerationFormController")
@RequestMapping("/TestDB_26may/TypeGenerationForm")
@Api(description = "Exposes APIs to work with TypeGenerationForm resource.", value = "TypeGenerationFormController")
public class TypeGenerationFormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeGenerationFormController.class);

    @Autowired
    @Qualifier("TestDB_26may.TypeGenerationFormService")
    private TypeGenerationFormService typeGenerationFormService;

    @Autowired
    @Qualifier("TestDB_26may.EmployeeSalaryService")
    private EmployeeSalaryService employeeSalaryService;

    @Autowired
    @Qualifier("TestDB_26may.TypeRecruitmentService")
    private TypeRecruitmentService typeRecruitmentService;

    @Autowired
    @Qualifier("TestDB_26may.ListPeriodicDeductionEmployeeService")
    private ListPeriodicDeductionEmployeeService listPeriodicDeductionEmployeeService;

    @Autowired
    @Qualifier("TestDB_26may.ListPeriodicBonusEmployeeService")
    private ListPeriodicBonusEmployeeService listPeriodicBonusEmployeeService;

    @Autowired
    @Qualifier("TestDB_26may.PayrollDetailService")
    private PayrollDetailService payrollDetailService;

    @Autowired
    @Qualifier("TestDB_26may.PayrollService")
    private PayrollService payrollService;

    /**
     * @deprecated Use {@link #findTypeGenerationForms(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of TypeGenerationForm instances matching the search criteria.")
    public Page<TypeGenerationForm> findTypeGenerationForms(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TypeGenerationForms list");
        return typeGenerationFormService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypeGenerationForm instances matching the search criteria.")
    public Page<TypeGenerationForm> findTypeGenerationForms(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypeGenerationForms list");
        return typeGenerationFormService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypeGenerationForms(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return typeGenerationFormService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/listPeriodicBonusEmployees", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusEmployees instance associated with the given id.")
    public Page<ListPeriodicBonusEmployee> findAssociatedListPeriodicBonusEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicBonusEmployees");
        return listPeriodicBonusEmployeeService.findAssociatedValues(id, "ListPeriodicBonusEmployee", "idTypeEmployeePaymentMethod", pageable);
    }

    @RequestMapping(value = "/{id:.+}/employeeSalaries", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the employeeSalaries instance associated with the given id.")
    public Page<EmployeeSalary> findAssociatedEmployeeSalaries(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated employeeSalaries");
        return employeeSalaryService.findAssociatedValues(id, "EmployeeSalary", "idTypeEmployeePaymentMethod", pageable);
    }

    @RequestMapping(value = "/{id:.+}/payrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the payrolls instance associated with the given id.")
    public Page<Payroll> findAssociatedPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated payrolls");
        return payrollService.findAssociatedValues(id, "Payroll", "idTypeEmployeePaymentMethod", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listPeriodicDeductionEmployees", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionEmployees instance associated with the given id.")
    public Page<ListPeriodicDeductionEmployee> findAssociatedListPeriodicDeductionEmployees(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicDeductionEmployees");
        return listPeriodicDeductionEmployeeService.findAssociatedValues(id, "ListPeriodicDeductionEmployee", "idTypeEmployeePaymentMethod", pageable);
    }

    @RequestMapping(value = "/{id:.+}/typeRecruitments", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the typeRecruitments instance associated with the given id.")
    public Page<TypeRecruitment> findAssociatedTypeRecruitments(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated typeRecruitments");
        return typeRecruitmentService.findAssociatedValues(id, "TypeRecruitment", "idTypeEmployeePaymentMethod", pageable);
    }

    @RequestMapping(value = "/{id:.+}/payrollDetails", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the payrollDetails instance associated with the given id.")
    public Page<PayrollDetail> findAssociatedPayrollDetails(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated payrollDetails");
        return payrollDetailService.findAssociatedValues(id, "PayrollDetail", "idTypeEmployeePaymentMethod", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeGenerationFormService instance
	 */
    protected void setTypeGenerationFormService(TypeGenerationFormService service) {
        this.typeGenerationFormService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeSalaryService instance
	 */
    protected void setEmployeeSalaryService(EmployeeSalaryService service) {
        this.employeeSalaryService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypeRecruitmentService instance
	 */
    protected void setTypeRecruitmentService(TypeRecruitmentService service) {
        this.typeRecruitmentService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicDeductionEmployeeService instance
	 */
    protected void setListPeriodicDeductionEmployeeService(ListPeriodicDeductionEmployeeService service) {
        this.listPeriodicDeductionEmployeeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicBonusEmployeeService instance
	 */
    protected void setListPeriodicBonusEmployeeService(ListPeriodicBonusEmployeeService service) {
        this.listPeriodicBonusEmployeeService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PayrollDetailService instance
	 */
    protected void setPayrollDetailService(PayrollDetailService service) {
        this.payrollDetailService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PayrollService instance
	 */
    protected void setPayrollService(PayrollService service) {
        this.payrollService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new TypeGenerationForm instance.")
    public TypeGenerationForm createTypeGenerationForm(@RequestBody TypeGenerationForm typegenerationform) {
        LOGGER.debug("Create TypeGenerationForm with information: {}", typegenerationform);
        typegenerationform = typeGenerationFormService.create(typegenerationform);
        LOGGER.debug("Created TypeGenerationForm with information: {}", typegenerationform);
        return typegenerationform;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of TypeGenerationForm instances.")
    public Long countTypeGenerationForms(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TypeGenerationForms");
        return typeGenerationFormService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the TypeGenerationForm instance associated with the given id.")
    public TypeGenerationForm getTypeGenerationForm(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypeGenerationForm with id: {}", id);
        TypeGenerationForm foundTypeGenerationForm = typeGenerationFormService.getById(id);
        LOGGER.debug("TypeGenerationForm details with id: {}", foundTypeGenerationForm);
        return foundTypeGenerationForm;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the TypeGenerationForm instance associated with the given id.")
    public TypeGenerationForm editTypeGenerationForm(@PathVariable(value = "id") Integer id, @RequestBody TypeGenerationForm typegenerationform) throws EntityNotFoundException {
        LOGGER.debug("Editing TypeGenerationForm with id: {}", typegenerationform.getIdTypeEmployeePaymentMethod());
        typegenerationform.setIdTypeEmployeePaymentMethod(id);
        typegenerationform = typeGenerationFormService.update(typegenerationform);
        LOGGER.debug("TypeGenerationForm details with id: {}", typegenerationform);
        return typegenerationform;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the TypeGenerationForm instance associated with the given id.")
    public boolean deleteTypeGenerationForm(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypeGenerationForm with id: {}", id);
        TypeGenerationForm deletedTypeGenerationForm = typeGenerationFormService.delete(id);
        return deletedTypeGenerationForm != null;
    }
}

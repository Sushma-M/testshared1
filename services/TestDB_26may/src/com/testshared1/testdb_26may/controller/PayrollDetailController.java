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
import com.testshared1.testdb_26may.BonusEventual;
import com.testshared1.testdb_26may.DeductionEventual;
import com.testshared1.testdb_26may.ListCommissionPayroll;
import com.testshared1.testdb_26may.ListLoanDetailPayroll;
import com.testshared1.testdb_26may.ListOvertimePayroll;
import com.testshared1.testdb_26may.ListPeriodicBonusPayroll;
import com.testshared1.testdb_26may.ListPeriodicDeductionPayroll;
import com.testshared1.testdb_26may.ListTravelExpenseDetail;
import com.testshared1.testdb_26may.PaymentCheck;
import com.testshared1.testdb_26may.PayrollDetail;
import com.testshared1.testdb_26may.service.BonusEventualService;
import com.testshared1.testdb_26may.service.DeductionEventualService;
import com.testshared1.testdb_26may.service.ListCommissionPayrollService;
import com.testshared1.testdb_26may.service.ListLoanDetailPayrollService;
import com.testshared1.testdb_26may.service.ListOvertimePayrollService;
import com.testshared1.testdb_26may.service.ListPeriodicBonusPayrollService;
import com.testshared1.testdb_26may.service.ListPeriodicDeductionPayrollService;
import com.testshared1.testdb_26may.service.ListTravelExpenseDetailService;
import com.testshared1.testdb_26may.service.PaymentCheckService;
import com.testshared1.testdb_26may.service.PayrollDetailService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class PayrollDetail.
 * @see PayrollDetail
 */
@RestController("TestDB_26may.PayrollDetailController")
@RequestMapping("/TestDB_26may/PayrollDetail")
@Api(description = "Exposes APIs to work with PayrollDetail resource.", value = "PayrollDetailController")
public class PayrollDetailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollDetailController.class);

    @Autowired
    @Qualifier("TestDB_26may.PayrollDetailService")
    private PayrollDetailService payrollDetailService;

    @Autowired
    @Qualifier("TestDB_26may.ListOvertimePayrollService")
    private ListOvertimePayrollService listOvertimePayrollService;

    @Autowired
    @Qualifier("TestDB_26may.ListLoanDetailPayrollService")
    private ListLoanDetailPayrollService listLoanDetailPayrollService;

    @Autowired
    @Qualifier("TestDB_26may.ListTravelExpenseDetailService")
    private ListTravelExpenseDetailService listTravelExpenseDetailService;

    @Autowired
    @Qualifier("TestDB_26may.ListPeriodicBonusPayrollService")
    private ListPeriodicBonusPayrollService listPeriodicBonusPayrollService;

    @Autowired
    @Qualifier("TestDB_26may.BonusEventualService")
    private BonusEventualService bonusEventualService;

    @Autowired
    @Qualifier("TestDB_26may.ListPeriodicDeductionPayrollService")
    private ListPeriodicDeductionPayrollService listPeriodicDeductionPayrollService;

    @Autowired
    @Qualifier("TestDB_26may.DeductionEventualService")
    private DeductionEventualService deductionEventualService;

    @Autowired
    @Qualifier("TestDB_26may.ListCommissionPayrollService")
    private ListCommissionPayrollService listCommissionPayrollService;

    @Autowired
    @Qualifier("TestDB_26may.PaymentCheckService")
    private PaymentCheckService paymentCheckService;

    /**
     * @deprecated Use {@link #findPayrollDetails(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of PayrollDetail instances matching the search criteria.")
    public Page<PayrollDetail> findPayrollDetails(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering PayrollDetails list");
        return payrollDetailService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of PayrollDetail instances matching the search criteria.")
    public Page<PayrollDetail> findPayrollDetails(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering PayrollDetails list");
        return payrollDetailService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportPayrollDetails(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return payrollDetailService.export(exportType, query, pageable);
    }

    @RequestMapping(value = "/{id:.+}/listLoanDetailPayrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listLoanDetailPayrolls instance associated with the given id.")
    public Page<ListLoanDetailPayroll> findAssociatedListLoanDetailPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listLoanDetailPayrolls");
        return listLoanDetailPayrollService.findAssociatedValues(id, "ListLoanDetailPayroll", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listCommissionPayrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listCommissionPayrolls instance associated with the given id.")
    public Page<ListCommissionPayroll> findAssociatedListCommissionPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listCommissionPayrolls");
        return listCommissionPayrollService.findAssociatedValues(id, "ListCommissionPayroll", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/paymentChecks", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the paymentChecks instance associated with the given id.")
    public Page<PaymentCheck> findAssociatedPaymentChecks(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated paymentChecks");
        return paymentCheckService.findAssociatedValues(id, "PaymentCheck", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listPeriodicDeductionPayrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicDeductionPayrolls instance associated with the given id.")
    public Page<ListPeriodicDeductionPayroll> findAssociatedListPeriodicDeductionPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicDeductionPayrolls");
        return listPeriodicDeductionPayrollService.findAssociatedValues(id, "ListPeriodicDeductionPayroll", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/bonusEventuals", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the bonusEventuals instance associated with the given id.")
    public Page<BonusEventual> findAssociatedBonusEventuals(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated bonusEventuals");
        return bonusEventualService.findAssociatedValues(id, "BonusEventual", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listPeriodicBonusPayrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listPeriodicBonusPayrolls instance associated with the given id.")
    public Page<ListPeriodicBonusPayroll> findAssociatedListPeriodicBonusPayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listPeriodicBonusPayrolls");
        return listPeriodicBonusPayrollService.findAssociatedValues(id, "ListPeriodicBonusPayroll", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/deductionEventuals", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the deductionEventuals instance associated with the given id.")
    public Page<DeductionEventual> findAssociatedDeductionEventuals(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated deductionEventuals");
        return deductionEventualService.findAssociatedValues(id, "DeductionEventual", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listOvertimePayrolls", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listOvertimePayrolls instance associated with the given id.")
    public Page<ListOvertimePayroll> findAssociatedListOvertimePayrolls(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listOvertimePayrolls");
        return listOvertimePayrollService.findAssociatedValues(id, "ListOvertimePayroll", "idPayrollDetail", pageable);
    }

    @RequestMapping(value = "/{id:.+}/listTravelExpenseDetails", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the listTravelExpenseDetails instance associated with the given id.")
    public Page<ListTravelExpenseDetail> findAssociatedListTravelExpenseDetails(Pageable pageable, @PathVariable("id") Integer id) {
        LOGGER.debug("Fetching all associated listTravelExpenseDetails");
        return listTravelExpenseDetailService.findAssociatedValues(id, "ListTravelExpenseDetail", "idPayrollDetail", pageable);
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
	 * @param service ListOvertimePayrollService instance
	 */
    protected void setListOvertimePayrollService(ListOvertimePayrollService service) {
        this.listOvertimePayrollService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListLoanDetailPayrollService instance
	 */
    protected void setListLoanDetailPayrollService(ListLoanDetailPayrollService service) {
        this.listLoanDetailPayrollService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListTravelExpenseDetailService instance
	 */
    protected void setListTravelExpenseDetailService(ListTravelExpenseDetailService service) {
        this.listTravelExpenseDetailService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicBonusPayrollService instance
	 */
    protected void setListPeriodicBonusPayrollService(ListPeriodicBonusPayrollService service) {
        this.listPeriodicBonusPayrollService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BonusEventualService instance
	 */
    protected void setBonusEventualService(BonusEventualService service) {
        this.bonusEventualService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListPeriodicDeductionPayrollService instance
	 */
    protected void setListPeriodicDeductionPayrollService(ListPeriodicDeductionPayrollService service) {
        this.listPeriodicDeductionPayrollService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DeductionEventualService instance
	 */
    protected void setDeductionEventualService(DeductionEventualService service) {
        this.deductionEventualService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ListCommissionPayrollService instance
	 */
    protected void setListCommissionPayrollService(ListCommissionPayrollService service) {
        this.listCommissionPayrollService = service;
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PaymentCheckService instance
	 */
    protected void setPaymentCheckService(PaymentCheckService service) {
        this.paymentCheckService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new PayrollDetail instance.")
    public PayrollDetail createPayrollDetail(@RequestBody PayrollDetail payrolldetail) {
        LOGGER.debug("Create PayrollDetail with information: {}", payrolldetail);
        payrolldetail = payrollDetailService.create(payrolldetail);
        LOGGER.debug("Created PayrollDetail with information: {}", payrolldetail);
        return payrolldetail;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of PayrollDetail instances.")
    public Long countPayrollDetails(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting PayrollDetails");
        return payrollDetailService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the PayrollDetail instance associated with the given id.")
    public PayrollDetail getPayrollDetail(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting PayrollDetail with id: {}", id);
        PayrollDetail foundPayrollDetail = payrollDetailService.getById(id);
        LOGGER.debug("PayrollDetail details with id: {}", foundPayrollDetail);
        return foundPayrollDetail;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the PayrollDetail instance associated with the given id.")
    public PayrollDetail editPayrollDetail(@PathVariable(value = "id") Integer id, @RequestBody PayrollDetail payrolldetail) throws EntityNotFoundException {
        LOGGER.debug("Editing PayrollDetail with id: {}", payrolldetail.getIdPayrollDetail());
        payrolldetail.setIdPayrollDetail(id);
        payrolldetail = payrollDetailService.update(payrolldetail);
        LOGGER.debug("PayrollDetail details with id: {}", payrolldetail);
        return payrolldetail;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the PayrollDetail instance associated with the given id.")
    public boolean deletePayrollDetail(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting PayrollDetail with id: {}", id);
        PayrollDetail deletedPayrollDetail = payrollDetailService.delete(id);
        return deletedPayrollDetail != null;
    }
}

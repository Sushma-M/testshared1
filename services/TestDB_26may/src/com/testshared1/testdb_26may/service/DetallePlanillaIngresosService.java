/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testshared1.testdb_26may.DetallePlanillaIngresos;
import com.testshared1.testdb_26may.DetallePlanillaIngresosId;

/**
 * Service object for domain model class DetallePlanillaIngresos.
 *
 * @see {@link DetallePlanillaIngresos}
 */
public interface DetallePlanillaIngresosService {


	/**
	 * Finds DetallePlanillaIngresos by id.
	 *
	 * @param detallePlanillaIngresosId The id of the wanted DetallePlanillaIngresos.
	 * @return The found DetallePlanillaIngresos. If no DetallePlanillaIngresos is found, this method returns null.
	 */
	DetallePlanillaIngresos getById(DetallePlanillaIngresosId detallePlanillaIngresosId) throws EntityNotFoundException;

	/**
	 * Finds all DetallePlanillaIngresos.
	 *
	 * @return A list of DetallePlanillaIngresos.
	 */
    @Deprecated
	Page<DetallePlanillaIngresos> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all DetallePlanillaIngresos.
	 * @return A list of DetallePlanillaIngresos.
	 */
    Page<DetallePlanillaIngresos> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the DetallePlanillaIngresos in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the DetallePlanillaIngresos.
	 */
	long count(String query);

    Page<DetallePlanillaIngresos> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}


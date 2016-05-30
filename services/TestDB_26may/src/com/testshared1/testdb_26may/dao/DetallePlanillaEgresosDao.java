/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.testshared1.testdb_26may.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.testshared1.testdb_26may.DetallePlanillaEgresos;
import com.testshared1.testdb_26may.DetallePlanillaEgresosId;

/**
 * Specifies methods used to obtain and modify DetallePlanillaEgresos related information
 * which is stored in the database.
 */
@Repository("TestDB_26may.DetallePlanillaEgresosDao")
public class DetallePlanillaEgresosDao extends WMGenericDaoImpl<DetallePlanillaEgresos, DetallePlanillaEgresosId> {

    @Autowired
    @Qualifier("TestDB_26mayTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

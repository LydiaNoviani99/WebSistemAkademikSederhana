/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.AcademicYearDaoImpl;
import com.lydia.entity.AcademicYear;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "AcademicYearWebService")
public class AcademicYearWebService {

    private AcademicYearDaoImpl academicYearDaoImpl;

    public AcademicYearWebService() {
        academicYearDaoImpl = new AcademicYearDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAcademicYear")
    public Integer addAcademicYear(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setId(id);
        academicYear.setName(name);
        return academicYearDaoImpl.save(academicYear);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateAcademicYear")
    public Integer updateAcademicYear(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setId(id);
        academicYear.setName(name);
        return academicYearDaoImpl.update(academicYear);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteAcademicYear")
    public Integer deleteAcademicYear(
            @WebParam(name = "id") int id) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setId(id);
        return academicYearDaoImpl.delete(academicYear);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAllAcademicYear")
    public java.util.List<AcademicYear> showAllAcademicYears() {
        return academicYearDaoImpl.findAll();
    }
}

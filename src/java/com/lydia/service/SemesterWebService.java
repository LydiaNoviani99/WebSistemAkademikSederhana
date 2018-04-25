/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.SemesterDaoImpl;
import com.lydia.entity.Semester;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "SemesterWebService")
public class SemesterWebService {

    private SemesterDaoImpl semesterDaoImpl;

    public SemesterWebService() {
        semesterDaoImpl = new SemesterDaoImpl();
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addSemester")
    public Integer addSemester(
            @WebParam(name = "name") String name) {
        Semester semester = new Semester();
        semester.setName(name);
        return semesterDaoImpl.save(semester);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateSemester")
    public Integer updateSemester(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        Semester semester = new Semester();
        semester.setId(id);
        semester.setName(name);
        return semesterDaoImpl.update(semester);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteSemester")
    public Integer deleteSemester(
            @WebParam(name = "id") int id) {
        Semester semester = new Semester();
        semester.setId(id);
        return semesterDaoImpl.delete(semester);
        //TODO write your implementation code here:
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.FacultyDaoImpl;
import com.lydia.entity.Faculty;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "FacultyWebService")
public class FacultyWebService {

    private FacultyDaoImpl facultyDaoImpl;

    public FacultyWebService() {
        facultyDaoImpl = new FacultyDaoImpl();
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
    @WebMethod(operationName = "addFaculty")
    public Integer addFaculty(
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name) {
        Faculty faculty = new Faculty();
        faculty.setCode((short) code);
        faculty.setName(name);
        return facultyDaoImpl.save(faculty);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateFaculty")
    public Integer updateFaculty(
            @WebParam(name = "id") int id,
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name) {
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setCode((short) code);
        faculty.setName(name);
        return facultyDaoImpl.update(faculty);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteFaculty")
    public Integer deleteFaculty(
            @WebParam(name = "id") int id) {
        Faculty faculty = new Faculty();
        faculty.setId(id);
        return facultyDaoImpl.delete(faculty);
        //TODO write your implementation code here:
    }

}

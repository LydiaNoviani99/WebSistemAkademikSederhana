/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.DepartmentDaoImpl;
import com.lydia.entity.Department;
import com.lydia.entity.Faculty;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "DepartmentWebService")
public class DepartmentWebService {

    private DepartmentDaoImpl departmentDaoImpl;

    public DepartmentWebService() {
        departmentDaoImpl = new DepartmentDaoImpl();
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
    @WebMethod(operationName = "addDepartment")
    public Integer addDepartment(
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name,
            @WebParam(name = "faculty_id") int faculty_id) {
        Department department = new Department();
        department.setCode((short) code);
        department.setName(name);
        Faculty faculty = new Faculty();
        faculty.setId(faculty_id);
        department.setFaculty(faculty);
        //TODO write your implementation code here:
        return departmentDaoImpl.save(department);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateDepartment")
    public Integer updateDepartment(
            @WebParam(name = "id") int id,
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name,
            @WebParam(name = "faculty_id") int faculty_id) {
        Department department = new Department();
        department.setId(id);
        department.setCode((short) code);
        department.setName(name);
        Faculty faculty = new Faculty();
        faculty.setId(faculty_id);
        department.setFaculty(faculty);
        //TODO write your implementation code here:
        return departmentDaoImpl.update(department);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteDepartment")
    public Integer deleteDepartment(
            @WebParam(name = "id") int id) {
        Department department = new Department();
        department.setId(id);
        return departmentDaoImpl.delete(department);
        //TODO write your implementation code here:
    }
}

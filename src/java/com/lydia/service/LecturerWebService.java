/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.LecturerDaoImpl;
import com.lydia.entity.Department;
import com.lydia.entity.Lecturer;
import com.lydia.entity.Role;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "LecturerWebService")
public class LecturerWebService {

    private LecturerDaoImpl lecturerDaoImpl;

    public LecturerWebService() {
        lecturerDaoImpl = new LecturerDaoImpl();
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
    @WebMethod(operationName = "addLecturer")
    public Integer addLecturer(
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id,
            @WebParam(name = "role_idRole") int role_idRole) {

        Lecturer lecturer = new Lecturer();
        lecturer.setName(name);
        lecturer.setPassword(password);

        Department department = new Department();
        department.setId(department_id);

        Role role = new Role();
        role.setIdRole(role_idRole);

        lecturer.setDepartment(department);
        lecturer.setRole(role);

        return lecturerDaoImpl.save(lecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateLecturer")
    public Integer updateLecturer(
            @WebParam(name = "nik") String nik,
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id,
            @WebParam(name = "role_idRole") int role_idRole) {

        Lecturer lecturer = new Lecturer();
        lecturer.setNik(nik);
        lecturer.setName(name);
        lecturer.setPassword(password);

        Department department = new Department();
        department.setId(department_id);

        Role role = new Role();
        role.setIdRole(role_idRole);

        lecturer.setDepartment(department);
        lecturer.setRole(role);

        return lecturerDaoImpl.update(lecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteLecturer")
    public Integer deleteLecturer(
            @WebParam(name = "nik") String nik) {
        Lecturer lecturer = new Lecturer();
        lecturer.setNik(nik);
        return lecturerDaoImpl.delete(lecturer);
    }
}

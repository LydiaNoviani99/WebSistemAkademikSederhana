/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.StudentDaoImpl;
import com.lydia.entity.Department;
import com.lydia.entity.Student;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {

    private StudentDaoImpl studentDaoImpl;

    public StudentWebService() {
        studentDaoImpl = new StudentDaoImpl();
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
    @WebMethod(operationName = "addStudentWebService")
    public Integer addStudentWebService(
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id) {
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);

        Department department = new Department();
        department.setId(department_id);

        student.setDepartment(department);
        return studentDaoImpl.save(student);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudent")
    public Integer updateStudent(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPassword(password);

        Department department = new Department();
        department.setId(department_id);

        student.setDepartment(department);
        return studentDaoImpl.update(student);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudent")
    public Integer deleteStudent(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id) {
        Student student = new Student();
        student.setId(id);
        return studentDaoImpl.delete(student);
    }
}

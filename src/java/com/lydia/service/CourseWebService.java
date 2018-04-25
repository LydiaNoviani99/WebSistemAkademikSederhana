/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.CourseDaoImpl;
import com.lydia.entity.Course;
import com.lydia.entity.Department;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "CourseWebService")
public class CourseWebService {

    private CourseDaoImpl courseDaoImpl;

    public CourseWebService() {
        courseDaoImpl = new CourseDaoImpl();
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
    @WebMethod(operationName = "addCourse")
    public Integer addCourse(
            @WebParam(name = "name") String name,
            @WebParam(name = "theory_credits") int theory_credits,
            @WebParam(name = "practicum_credits") int practicum_credits,
            @WebParam(name = "department_id") int department_id) {
        Course course = new Course();
        course.setName(name);
        course.setTheoryCredits((short) theory_credits);
        course.setPracticumCredits(practicum_credits);
        Department department = new Department();
        department.setId(department_id);
        course.setDepartment(department);
        return courseDaoImpl.save(course);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateCourse")
    public Integer updateCourse(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "theory_credits") int theory_credits,
            @WebParam(name = "practicum_credits") int practicum_credits,
            @WebParam(name = "department_id") int department_id) {
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setTheoryCredits((short) theory_credits);
        course.setPracticumCredits(practicum_credits);
        Department department = new Department();
        department.setId(department_id);
        course.setDepartment(department);
        return courseDaoImpl.update(course);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCourse")
    public Integer deleteCourse(
            @WebParam(name = "id") String id) {
        Course course = new Course();
        course.setId(id);
        return courseDaoImpl.delete(course);
        //TODO write your implementation code here:
    }
}

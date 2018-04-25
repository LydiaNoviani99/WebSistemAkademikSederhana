/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.RoleDaoImpl;
import com.lydia.entity.Role;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "RoleWebService")
public class RoleWebService {

    private RoleDaoImpl roleDaoImpl;

    public RoleWebService() {
        roleDaoImpl = new RoleDaoImpl();
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
    @WebMethod(operationName = "addRole")
    public Integer addRole(
            @WebParam(name = "ketRole") String ketRole) {
        Role role = new Role();
        role.setKetRole(ketRole);
        return roleDaoImpl.save(role);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateRole")
    public Integer updateRole(
            @WebParam(name = "idRole") int idRole,
            @WebParam(name = "ketRole") String ketRole) {
        Role role = new Role();
        role.setIdRole(idRole);
        role.setKetRole(ketRole);
        return roleDaoImpl.update(role);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteRole")
    public Integer deleteRole(
            @WebParam(name = "idRole") int idRole) {
        Role role = new Role();
        role.setIdRole(idRole);
        return roleDaoImpl.delete(role);
    }

}

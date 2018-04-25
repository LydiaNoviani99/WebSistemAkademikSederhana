/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.service;

import com.lydia.dao.RoomDaoImpl;
import com.lydia.entity.Room;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author USER
 */
@WebService(serviceName = "RoomWebService")
public class RoomWebService {

    private RoomDaoImpl roomDaoImpl;

    public RoomWebService() {
        roomDaoImpl = new RoomDaoImpl();
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
    @WebMethod(operationName = "addRoom")
    public Integer addRoom(
            @WebParam(name = "name") String name) {
        Room room = new Room();
        room.setName(name);
        return roomDaoImpl.save(room);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateRoom")
    public Integer updateRoom(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        Room room = new Room();
        room.setId(id);
        room.setName(name);
        return roomDaoImpl.update(room);
        //TODO write your implementation code here:
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudent")
    public Integer deleteStudent(
            @WebParam(name = "id") int id) {
        Room room = new Room();
        room.setId(id);
        return roomDaoImpl.delete(room);
        //TODO write your implementation code here:
    }
}

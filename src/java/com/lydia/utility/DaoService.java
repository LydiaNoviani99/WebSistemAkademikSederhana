/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.utility;

import java.util.List;

/**
 *
 * @author USER
 * @param <T>
 */
public interface DaoService<T> {

    int save(T t);

    int delete(T t);

    int update(T t);

    List<T> findAll();

    T find(Object object);

}

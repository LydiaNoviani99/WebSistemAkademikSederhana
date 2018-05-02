/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.dao;

import com.lydia.entity.Faculty;
import com.lydia.utility.DaoService;
import com.lydia.utility.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER
 */
public class FacultyDaoImpl implements DaoService<Faculty> {

    @Override
    public int save(Faculty t) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(t);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int delete(Faculty t) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(t);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int update(Faculty t) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(t);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<Faculty> findAll() {
        List<Faculty> facultys = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Faculty.class);
        facultys.addAll(criteria.list());
        session.close();
        return facultys;
    }

    @Override
    public List<Faculty> find(Object object) {
        List<Faculty> categories = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Faculty.class).add(
                Restrictions.like("name", "%" + object.toString() + "%"));

        categories.addAll(criteria.list());
        return categories;
    }

}

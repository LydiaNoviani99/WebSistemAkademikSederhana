/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.dao;

import com.lydia.entity.Semester;
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
public class SemesterDaoImpl implements DaoService<Semester> {

    @Override
    public int save(Semester t) {
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
    public int delete(Semester t) {
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
    public int update(Semester t) {
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
    public List<Semester> findAll() {
        List<Semester> semesters = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Semester.class);
        semesters.addAll(criteria.list());
        session.close();
        return semesters;
    }

    @Override
    public List<Semester> find(Object object) {
        List<Semester> categories = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Semester.class).add(
                Restrictions.like("name", "%" + object.toString() + "%"));

        categories.addAll(criteria.list());
        return categories;
    }

}

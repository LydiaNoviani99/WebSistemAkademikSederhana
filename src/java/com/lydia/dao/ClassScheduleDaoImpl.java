/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.dao;

import com.lydia.entity.ClassSchedule;
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
public class ClassScheduleDaoImpl implements DaoService<ClassSchedule> {

    @Override
    public int save(ClassSchedule t) {
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
    public int delete(ClassSchedule t) {
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
    public int update(ClassSchedule t) {
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
    public List<ClassSchedule> findAll() {
        List<ClassSchedule> classSchedules = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ClassSchedule.class);
        classSchedules.addAll(criteria.list());
        session.close();
        return classSchedules;
    }

    @Override
    public List<ClassSchedule> find(Object object) {
        List<ClassSchedule> categories = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ClassSchedule.class).add(
                Restrictions.like("name", "%" + object.toString() + "%"));

        categories.addAll(criteria.list());
        return categories;
    }

}

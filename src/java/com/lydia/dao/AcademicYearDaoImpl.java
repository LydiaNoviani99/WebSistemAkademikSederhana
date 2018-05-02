/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lydia.dao;

import com.lydia.entity.AcademicYear;
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
public class AcademicYearDaoImpl implements DaoService<AcademicYear> {

    @Override
    public int save(AcademicYear t) {
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
    public int delete(AcademicYear t) {
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
    public int update(AcademicYear t) {
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
    public List<AcademicYear> findAll() {
        List<AcademicYear> academicYears = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AcademicYear.class);
        academicYears.addAll(criteria.list());
        session.close();
        return academicYears;
    }

    @Override
    public List<AcademicYear> find(Object object) {
        List<AcademicYear> categories = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AcademicYear.class).add(
                Restrictions.like("name", "%" + object.toString() + "%"));

        categories.addAll(criteria.list());
        return categories;
    }

}

package com.iot.model.dao.implementation;

import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Factory;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactoryDAO implements GeneralDAO<Factory> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Factory> findAll() {
        List<Factory> factories = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            factories = session.createQuery("from Factory ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factories;
    }

    @Override
    public Factory findOne(Integer id) throws SQLException {
        Factory factory = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            factory = session.get(Factory.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    @Override
    public void create(Factory factory) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(factory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Factory factory) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(factory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Factory factory = session.get(Factory.class, id);
            if (factory != null) {
                session.delete(factory);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

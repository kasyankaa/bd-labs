package com.iot.model.dao.implementation;

import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Country;
import com.iot.model.entity.Delivery;
import com.iot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO implements GeneralDAO<Delivery> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Delivery> findAll() {
        List<Delivery> deliveries = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            deliveries = session.createQuery("from Delivery ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    @Override
    public Delivery findOne(Integer id) throws SQLException {
        Delivery delivery = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            delivery = session.get(Delivery.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delivery;
    }

    @Override
    public void create(Delivery delivery) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(delivery);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id,  Delivery delivery) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(delivery);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Delivery delivery = session.get(Delivery.class, id);
            if (delivery != null) {
                session.delete(delivery);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

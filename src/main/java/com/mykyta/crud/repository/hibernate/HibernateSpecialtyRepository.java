package com.mykyta.crud.repository.hibernate;

import com.mykyta.crud.model.Specialty;
import com.mykyta.crud.repository.SpecialtyRepository;
import com.mykyta.crud.util.SessionFactoryInit;
import jakarta.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class HibernateSpecialtyRepository implements SpecialtyRepository {

    private final static String TABLE_NAME = "specialties";

    @Override
    public List<Specialty> getAll() {
        Query query;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            query = session.createQuery("FROM Specialty ", Specialty.class);
            return query.getResultList();
        }

    }

    @Override
    public Specialty getById(Integer integer) {
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            return session.get(Specialty.class, integer);
        }
    }

    @Override
    public Specialty create(Specialty entity) {
        Transaction transaction;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public Specialty update(Specialty entity) {
        Transaction transaction;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public void deleteById(Integer integer) {
        Transaction transaction;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            transaction = session.beginTransaction();
            Specialty specialty = getById(integer);
            session.remove(specialty);
            transaction.commit();
        }
    }
}

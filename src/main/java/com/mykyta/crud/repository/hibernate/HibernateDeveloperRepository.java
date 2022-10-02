package com.mykyta.crud.repository.hibernate;

import com.mykyta.crud.model.Developer;
import com.mykyta.crud.repository.DeveloperRepository;
import com.mykyta.crud.repository.SkillRepository;
import com.mykyta.crud.util.SessionFactoryInit;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDeveloperRepository implements DeveloperRepository {

    private final SkillRepository skillRepository = new HibernateSkillRepository();
    private static final String TABLE_NAME = "developers";

    @Override
    public List<Developer> getAll() {
        Query query;
        List list;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            query = session.createQuery("SELECT d FROM Developer d JOIN FETCH d.skills  JOIN FETCH d.specialty", Developer.class);
            list = query.getResultList();
        }
        return list;
    }

    @Override
    public Developer getById(Integer integer) {
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            Query query = session.createQuery("SELECT DISTINCT d " +
                    "FROM Developer d " +
                    "JOIN FETCH d.skills s " +
                    "JOIN FETCH d.specialty sp " +
                    "WHERE d.id = " + integer, Developer.class);
            Developer developer = (Developer) query.getResultList().get(0);;
            return developer;
        }
    }

    @Override
    public Developer create(Developer entity) {
        Transaction transaction;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public Developer update(Developer entity) {
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
            Developer developer = new Developer();
            developer.setId(integer);
            session.remove(developer);
            transaction.commit();
        }
    }
}

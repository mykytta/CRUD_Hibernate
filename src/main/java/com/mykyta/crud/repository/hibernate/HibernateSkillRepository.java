package com.mykyta.crud.repository.hibernate;

import com.mykyta.crud.model.Skill;
import com.mykyta.crud.repository.SkillRepository;
import com.mykyta.crud.util.SessionFactoryInit;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateSkillRepository implements SkillRepository {
    @Override
    public List<Skill> getAll() {
        Query query;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            query = session.createQuery("FROM Skill", Skill.class);
            return query.getResultList();
        }
    }

    @Override
    public Skill getById(Integer integer) {
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            return session.get(Skill.class, integer);
        }
    }

    @Override
    public Skill create(Skill entity) {
        Transaction transaction;
        try (Session session = SessionFactoryInit.getInstance().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public Skill update(Skill entity) {
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
            Skill skill = new Skill();
            skill.setId(integer);
            session.remove(skill);
            transaction.commit();
        }
    }
}

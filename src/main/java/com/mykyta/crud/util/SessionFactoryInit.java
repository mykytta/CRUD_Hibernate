package com.mykyta.crud.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInit {
    private static SessionFactory sessionFactory;

    private SessionFactoryInit(){}

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getInstance(){
        return sessionFactory;
    }
}

package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUtil {
    public static void addEmployee(Employee employee){
        SessionFactory sessionFactory = ConnectionFactory.sessionFactory();

        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();

        session.save(employee);
        t.commit();
        session.close();
    }
    public static void updateEmployee(Employee employee){
        SessionFactory sessionFactory = ConnectionFactory.sessionFactory();

        //get the connection
        Session session = sessionFactory.openSession();

        Transaction txn = session.beginTransaction();

        session.update(employee);
        txn.commit();
        session.close();
    }
}

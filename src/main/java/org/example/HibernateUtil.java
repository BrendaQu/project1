package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    public static Employee getEmployee(String email, String password){
        Employee employee = new Employee();
        SessionFactory sessionFactory = ConnectionFactory.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        String hql = "from Employee where email= :email AND password= :password";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List employees = query.list();
        employee = (Employee) employees.get(0);

        return employee;

    }
}

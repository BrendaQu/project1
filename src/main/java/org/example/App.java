package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "project stated..." );

      /*  Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();


        Session session = factory.openSession();

        Transaction t = session.beginTransaction();*/

        Integer id = 113;
        String name = "Ava Lopez";
        String email = "ava@one.com";
        String password = "password12";
        String empStartDate = "07/11/2019";
        String phone = "(888) 888-8888";
        String country = "United States";
        String title = "Account Manager";
        String type = "regular";



        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setEmpStartDate(empStartDate);
        employee.setPhone(phone);
        employee.setCountry(country);
        employee.setTitle(title);
        employee.setType(type);

      HibernateUtil.addEmployee(employee);


    }
}

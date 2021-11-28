package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

        Transaction t = session.beginTransaction();

        //Add employee into database
        Integer id = 115;
        String name = "Emma Li";
        String email = "emma@one.com";
        String password = "password15";
        String empStartDate = "03/10/2016";
        String phone = "(777) 777-7777";
        String country = "United States";
        String title = "Chief Executive Officer";
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

        HibernateUtil.addEmployee(employee);*/

/*
        HibernateUtil.updateRequestStatus(3,"approved");*/

        // get request by Employee Id test
        List<Request> requests = HibernateUtil.getRequestsByEmployeeId(101);
        for(Request r: requests){
            System.out.println( "Employee ID: " + r.getEmployee().getId() + " Request Id: " +  r.getRequestId());
        }

    }
}

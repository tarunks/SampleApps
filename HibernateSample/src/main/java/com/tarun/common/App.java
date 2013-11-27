package com.tarun.common;

import com.tarun.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import java.sql.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Read
        System.out.println("******* READ *******");
        List employees = list();
        System.out.println("Total Employees: " + employees.size());


        // Write
        System.out.println("******* WRITE *******");
        Employee empl = new Employee("Jack", "Bauer", "C-25",new Date(System.currentTimeMillis()));
        empl = save(empl);
        empl = read(empl.getEmpId());
        System.out.printf("%d %s %s \n", empl.getEmpId(), empl.getFirstName(), empl.getLastName());


          /*
        // Update
        System.out.println("******* UPDATE *******");
        Employee empl2 = read(1l); // read employee with id 1
        System.out.println("Name Before Update:" + empl2.getFirstName());
        empl2.setFirstName("James");
        update(empl2);	// save the updated employee details

        empl2 = read(1l); // read again employee with id 1
        System.out.println("Name Aftere Update:" + empl2.getFirstName());


        // Delete
        System.out.println("******* DELETE *******");
        delete(empl);
        Employee empl3 = read(empl.getEmpId());
        System.out.println("Object:" + empl3);

        */
    }
    private static List list() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        List employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }
    private static Employee read(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();
        return employee;
    }
    private static Employee save(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Long id = (Long) session.save(employee);
        employee.setEmpId(id);

        session.getTransaction().commit();

        session.close();

        return employee;
    }

    private static Employee update(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(employee);

        session.getTransaction().commit();

        session.close();
        return employee;

    }

    private static void delete(Employee employee) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(employee);

        session.getTransaction().commit();

        session.close();
    }

}

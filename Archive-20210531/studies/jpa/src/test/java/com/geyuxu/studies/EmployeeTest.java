package com.geyuxu.studies;

import com.geyuxu.studies.bean.Department;
import com.geyuxu.studies.bean.Employee;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {
    @Test
    public void testInsert(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee(159);
        emp.setName("Miya2");
        emp.setSalary(1111);
        emp.setPhoneNumberForDb("13847374816");
        em.persist(emp);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Test
    public void testInsert2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee(162);
        emp.setName("Miya2");
        emp.setSalary(1111);
        emp.setPhoneNumberForDb("02513847374816");
        em.persist(emp);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Test
    public void testInsert3(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee();
        emp.setName("Gyx2");
        emp.setSalary(90000);
        emp.setPhoneNumberForDb("02513847374816");
        em.persist(emp);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Test
    public void testInsertDepartment(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee();
        emp.setName("Gyx2");
        emp.setSalary(90000);
        emp.setPhoneNumberForDb("02513847374816");
        Department department = new Department();
        department.setName("架构部");
        emp.setDepartment(department);

        em.persist(department);
        em.persist(emp);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    @Test
    public void testFind(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

        Employee employee = em.find(Employee.class, 158);

        em.close();
        emf.close();

        System.out.println(employee.getId());
    }

    @Test
    public void testFindByDept(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();

       // TODO

        em.close();
        emf.close();

    }
}

package com.geyuxu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        EmployeeService service = new EmployeeService(em);

        em.getTransaction().begin();
        Employee emp = service.createEmployee(160,"LL oe",450000);
        em.getTransaction().commit();

        Employee emp2 = service.findEmployee(160);
        System.out.println("Found :"+emp2.getName());

        List<Employee> emps = service.findAllEmployee();
        for (Employee e :
                emps) {
            System.out.println("Found employees "+e);
        }

        em.close();
        emf.close();

    }
}

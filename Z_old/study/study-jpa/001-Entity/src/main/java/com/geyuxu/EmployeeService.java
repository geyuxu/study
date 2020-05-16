package com.geyuxu;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeService {
    private EntityManager em;

    public EmployeeService(EntityManager em) {
        this.em = em;
    }

    public Employee createEmployee(int id,String name,long salary){
        Employee emp = new Employee(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }

    public void removeEmployee(int id){
        Employee emp = findEmployee(id);
        if(emp != null){
            em.remove(emp);
        }
    }

    public Employee raiseEmployeeSalary(int id,long raise){
        Employee emp = em.find(Employee.class,id);
        if(emp!=null){
            emp.setSalary(emp.getSalary() + raise);
        }
        return emp;
    }

    public Employee findEmployee(int id) {
        Employee employee = em.find(Employee.class,id);
        return employee;
    }

    public List<Employee> findAllEmployee() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e",Employee.class);

        return query.getResultList();
    }

}

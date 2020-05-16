package com.geyuxu.studies.bean;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="emp")
@Access(AccessType.FIELD)
public class Employee {

    public static final String LOCAL_AREA_CODE = "025";




    @GeneratedValue(strategy = GenerationType.AUTO)
//    @TableGenerator(name="Emp_Gen")
//    @GeneratedValue(generator = "Emp_Gen")
//    @TableGenerator(name = "Emp_Gen",table="ID_GEN",pkColumnName = "GEN_NAME",pkColumnValue = "GEN_VAL")
//    @GeneratedValue(generator = "Emp_Gen")
    @Id private int id;



    private String name;
    private long salary;
    @Transient private String phoneNum;

    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    private Department department;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "PHONE")
    public String getPhoneNumberForDb() {
        if(phoneNum.length() == 14){
            return phoneNum;
        }else {
            return LOCAL_AREA_CODE + phoneNum;
        }

    }

    public void setPhoneNumberForDb(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

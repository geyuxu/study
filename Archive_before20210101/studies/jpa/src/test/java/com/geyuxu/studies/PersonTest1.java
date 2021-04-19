package com.geyuxu.studies;

import com.geyuxu.studies.bean.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonTest1 {

    @Test
    public void save() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("module1");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(new Person("person1"));
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    @Test
    public void select(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("module1");
        EntityManager em = factory.createEntityManager();
//        Person person = em.find(Person.class, 1); //相当于hibernate的get
        Person person = em.find(Person.class, 1); //相当于hibernate的load
//        load之后返回的是代理对象，使用的是cglib动态创建字节码的技术
//        如果不访问数据，是不回发生数据的加载行为的
//        org.hibernate.LazyInitializationException: could not initialize proxy - no Session
        em.close();
        System.out.println(person.getName());
        factory.close();
    }
}

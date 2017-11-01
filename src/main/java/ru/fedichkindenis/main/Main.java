package ru.fedichkindenis.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.fedichkindenis.Entity.Teacher;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }

        Session session = sessionFactory.openSession();

        List<Teacher> teacherList = session.createQuery("from Teacher t").list();

        for(Teacher teacher : teacherList) {
            System.out.println(teacher.toString());
        }
    }
}

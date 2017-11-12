package ru.fedichkindenis.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fedichkindenis.Entity.Teacher;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {

        }

        Session session = sessionFactory.openSession();

        List<Teacher> teacherList = session.createQuery("from Teacher t").list();

        for(Teacher teacher : teacherList) {
            System.out.println(teacher.toString());
        }
        session.close();
        sessionFactory.close();
    }
}

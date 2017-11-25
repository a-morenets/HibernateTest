package ru.fedichkindenis.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.type.Type;
import ru.fedichkindenis.Entity.Schedule;
import ru.fedichkindenis.Entity.Teacher;
import ru.fedichkindenis.Enum.DayWeek;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = getSessionFactory();
        Transaction transaction = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.getTransaction();

          /*  transaction.begin();
            Teacher teacher = createTeacher(session);
            transaction.commit();*/

        /*  Teacher teacher = session.get(Teacher.class, 1l);
            System.out.println(teacher.getSurName());*/


           /* transaction.begin();
            deleteTeacher(session, teacher);
            transaction.commit();*/

           // printTeacher(session, 1);

         /*   Teacher teacher = session.get(Teacher.class, 1l);
            transaction.begin();
            Schedule schedule = createSchedule(session, teacher);
            transaction.commit();*/

            Teacher teacher = session.get(Teacher.class, 1l);
            printSchedule(teacher.getScheduleList());

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        sessionFactory.close();
    }

    private static SessionFactory getSessionFactory() {

        return new Configuration().configure().buildSessionFactory();
    }

    private static Teacher createTeacher(Session session) throws Exception {

        Teacher teacher = new Teacher();
        teacher.setFirstName("Иван");
        teacher.setSurName("Иванович");
        teacher.setSecondName("Иванов");
        teacher.setAddress("Киев");
        teacher.setPhone("777-00-00");
        teacher.setDateBirth(new Date());

        session.save(teacher);

        return teacher;
    }

    private static void printTeacher(Session session, long id) throws Exception {

        Query query = session.createQuery("from Teacher t");
        //query.setParameter("id", id);

        List<Teacher> teacherList = query.list();

        for(Teacher teacher : teacherList) {
            System.out.println("Имя: " + teacher.getFirstName());
            System.out.println("Отчество: " + teacher.getSurName());
            System.out.println("Фамилия: " + teacher.getSecondName());
            System.out.println("Адрес: " + teacher.getAddress());
            System.out.println("Телефон: " + teacher.getPhone());
            System.out.println("Дата родения: " + teacher.getDateBirth());
            System.out.println();
        }
    }

    private static void deleteTeacher(Session session, Teacher teacher) throws Exception {

        session.delete(teacher);
    }

    private static Schedule createSchedule(Session session, Teacher teacher) throws Exception {

        Schedule schedule = new Schedule();
        schedule.setTeacher(teacher);
        schedule.setSubject("математика");
        schedule.setNumRoom("№5");
        schedule.setStartTime(new Date());
        schedule.setDayWeek(DayWeek.MONDAY);


        session.save(schedule);

        return schedule;
    }

    private static void printSchedule(List<Schedule> scheduleList) throws Exception {

        for(Schedule schedule : scheduleList) {
            System.out.println("Предмет: " + schedule.getSubject());
            System.out.println("Номер кабинета: " + schedule.getNumRoom());
            System.out.println("Время начала: " + schedule.getStartTime());
            System.out.println("День недели: " + schedule.getDayWeek());
            System.out.println();
        }
    }
}

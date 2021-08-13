package dev.patika.client;

import dev.patika.controller.StudentController;
import dev.patika.model.*;
import dev.patika.util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class MainClient {

    public static void main(String[] args) {
        if (checkTestData() == 0) {
            saveTestData();
        }

        StudentController controller = new StudentController();
        List<Student> list = controller.findAllStudent();
        for (Student student : list) {
            System.out.println(student);
        }

        System.exit(0);
    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student ", Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student student1 = new Student("Ümit Çelebi", LocalDate.of(1997, Month.JULY, 21), "Istanbul/Bahçelievler", "Male");
        Student student2 = new Student("Ahmet Kara", LocalDate.of(1995, Month.JANUARY, 18), "Istanbul/Esenler", "Male");
        Student student3 = new Student("Elif Çelebi", LocalDate.of(1998, Month.MAY, 12), "Istanbul/Bağcılar", "Female");

        Course course1 = new Course("Spring Boot", "course1", 01);
        Course course2 = new Course("Java Programming", "course2", 02);
        Course course3 = new Course("Algorithm", "course3", 03);

        Instructor permanentInstructor1 = new PermanentInstructor("Aslan", "Istanbul", "5223223322", 7500);
        Instructor permanentInstructor2 = new PermanentInstructor("Kerem Şahinerr", "Isparta", "5124778888", 8820);
        Instructor visitingResearcher = new VisitingResearcher("Emin Yılmaz", "Giresun", "5412113322", 350);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor2);
        course3.setInstructor(visitingResearcher);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course1.getStudents().add(student3);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(permanentInstructor1);
            em.persist(permanentInstructor2);
            em.persist(visitingResearcher);

            em.getTransaction().commit();

            System.out.print("All data persisted...");
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
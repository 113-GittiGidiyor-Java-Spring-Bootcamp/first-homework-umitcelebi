package dev.patika.service;

import dev.patika.model.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.repository.StudentRepository;
import dev.patika.util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Student> findAll() {
        return em.createQuery("FROM Student",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public void save(Student object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void delete(Student object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void delete(int id) {
        try {
            em.getTransaction().begin();
            Student student = em.createQuery("FROM Student WHERE Student =:id", Student.class).setParameter("id", id).getSingleResult();
            em.remove(student);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void update(Student object) {
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public List<Student> findByGender(String gender) {
        List<Student> list = em.createQuery("from Student s WHERE s.gender =:gender", Student.class).setParameter("gender", gender).getResultList();
        return list;
    }
}

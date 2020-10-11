package Service.Student;

import Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lombok.Getter;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Iterable<Student> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student AS s ", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student AS s WHERE s.id = :id", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Student save(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            if (student.getId() > 0) {
                session.merge(student);
            } else {
                session.persist(student);
            }
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public Student delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            Student student = findById(id);
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}

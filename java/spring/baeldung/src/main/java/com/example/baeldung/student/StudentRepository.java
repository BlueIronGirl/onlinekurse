package com.example.baeldung.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertStudent(Student student) {
        this.entityManager.persist(student);
    }

    public Student getStudentByIdTypedQuery(Long id) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("Select u from Student u where u.id = :id", Student.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    public Student getStudentByIdNamedQuery(Long id) {
        Query namedQuery = entityManager.createNamedQuery("Student.findUserById");
        namedQuery.setParameter("id", id);
        return (Student) namedQuery.getSingleResult();
    }
}

package com.example.baeldung.student;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StudentTimer {
    private final StudentRepository studentRepository;

    public StudentTimer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Scheduled(fixedDelay = 10000)
    public void schedule() {
        Address address = new Address();
        address.setOrt("Essen");

        Student student = new Student();
        student.setName("Alice");
        student.setAge(3);
        student.setGender(Gender.FEMALE);
        student.setAddress(address);
        student.setBirthDate(new Date(2013, 3, 3));

        studentRepository.insertStudent(student);

        System.out.println(studentRepository.getStudentByIdTypedQuery(1L));
        System.out.println(studentRepository.getStudentByIdNamedQuery(1L));
    }
}

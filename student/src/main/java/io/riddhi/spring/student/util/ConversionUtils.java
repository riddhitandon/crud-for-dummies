package io.riddhi.spring.student.util;
import io.riddhi.spring.student.entity.StudentEntity;
import io.riddhi.spring.student.pojo.Student;
import org.springframework.stereotype.Component;

@Component
public class ConversionUtils {

    public StudentEntity getStudentEntity(Student student){
        StudentEntity studentEntity= new StudentEntity();
        studentEntity.setInfo(student.getInfo());

        studentEntity.setName(student.getName());
        studentEntity.setRollNumber(student.getRollNumber());
        return studentEntity;
    }

    public Student getStudent(StudentEntity studentEntity){
        Student student= new Student();
        student.setInfo(studentEntity.getInfo());
        student.setName(studentEntity.getName());
        student.setRollNumber(studentEntity.getRollNumber());
        return student;
    }

}

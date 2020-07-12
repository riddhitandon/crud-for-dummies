package io.riddhi.spring.student.service;

import io.riddhi.spring.student.entity.StudentEntity;
import io.riddhi.spring.student.pojo.Student;
import io.riddhi.spring.student.repository.StudentRepository;
import io.riddhi.spring.student.util.ConversionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private ConversionUtils conversionUtils;

    @Autowired
    private StudentRepository studentRepository;

    public String createStudent(Student student){
        String result = null;
        try {
            StudentEntity studentEntity = conversionUtils.getStudentEntity(student);
            studentRepository.save(studentEntity);
        }catch (Exception e){
            result="Error occurred while saving student";
            return result;
        }
        result ="Student saved successfully";
        return result;
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        List<StudentEntity> studentEntities= studentRepository.findAll();
        for(StudentEntity studentEntity: studentEntities){
            students.add(conversionUtils.getStudent(studentEntity));
        }
        return students;
    }

    public Student getStudentById(Integer id){
        Optional<StudentEntity> optionalStudentEntity= studentRepository.findById(id);
        if(optionalStudentEntity.isPresent()){
            StudentEntity studentEntity = optionalStudentEntity.get();
            return conversionUtils.getStudent(studentEntity);
        }else{
            return null;
        }
    }

    public Student getStudentByRollNumber(Integer rollNumber){
        Optional<StudentEntity> optionalStudentEntity= studentRepository.findByRollNumber(rollNumber);
        if(optionalStudentEntity.isPresent()){
            StudentEntity studentEntity = optionalStudentEntity.get();
            return conversionUtils.getStudent(studentEntity);
        }else{
            return null;
        }
    }
    @Transactional
    public String deleteStudentByRollNumber(Integer rollNumber){
        Optional<StudentEntity> optionalStudentEntity= studentRepository.findByRollNumber(rollNumber);
        if(optionalStudentEntity.isPresent()) {
            studentRepository.deleteByRollNumber(rollNumber);
            StudentEntity studentEntity = optionalStudentEntity.get();
            return "Student deleted successfully with rollNumber: " + studentEntity.getRollNumber();
        }else {
            return "Student not found!!";
        }

    }

    public String updateStudentDetails(Student student){
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findByRollNumber(student.getRollNumber());
        if(optionalStudentEntity.isPresent()){
            StudentEntity studentEntity = optionalStudentEntity.get();
            if(student.getName()!=null){
                studentEntity.setName(student.getName());
            }
            if(student.getInfo()!=null){
                studentEntity.setInfo(student.getInfo());
            }
            studentRepository.save(studentEntity);
            return "Student details updated successfully";
        }
        return "Student Not Found!!";
    }
}

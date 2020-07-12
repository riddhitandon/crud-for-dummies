package io.riddhi.spring.student.repository;
//data access objects(DAO)
import io.riddhi.spring.student.entity.StudentEntity;
import io.riddhi.spring.student.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
public Optional<StudentEntity> findByRollNumber(Integer rollNumber);

/*@Modifying
public Integer removeByRollNumber(Integer rollNumber);*/
@Modifying
public Integer deleteByRollNumber(Integer rollNumber);

/*@Modifying
@Query("delete from StudentEntity s where s.rollNumber=:rollNumber")
void deleteStudent(@Param("rollNumber") Integer rollNumber);*/

}

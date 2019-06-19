package edu.mum.waa.backend.meditation.ws.repository;

import edu.mum.waa.backend.meditation.ws.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

@Query(value = "Select sum(b.totalDate) from Student s left join s.blocks b where s.studentId=:studentId")
public Long getTotalDay(Integer studentId);

}

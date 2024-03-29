package edu.mum.waa.backend.meditation.ws.repository;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.Student;
import edu.mum.waa.backend.meditation.ws.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "Select sum(b.totalDate) from Student s left join s.blocks b where s.studentId=:studentId")
    public Long getTotalDay(Integer studentId);

    @Query(value = "Select s from Student s where s.user.id=:userId")
    public Student findUserByStudentId(Long userId);

//    @Query(value = "Select s from Student s where s.studentId like :userId")
    @Query("SELECT s FROM Student s where s.studentId like %:keyword%")
    public List<Student> search(@Param("keyword") String keyword);
    @Query(value = "Select s from Student s where upper(s.entry) = :entryStr")
    public List<Student> findStudentsByEntry(String entryStr);

    @Query(value = "Select b.students from Block b where  b.blockId = :blockId")
    public List<Student> findStudentsByBlockId(Long blockId);

    @Query(value = "Select distinct upper(s.entry) from Student s")
    public List<String> getEntryList();
}

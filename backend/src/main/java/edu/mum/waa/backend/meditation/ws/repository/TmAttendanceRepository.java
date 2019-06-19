package edu.mum.waa.backend.meditation.ws.repository;

import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TmAttendanceRepository extends JpaRepository<TmAttendance, Long> {

    @Query(value = "SELECT a FROM TmAttendance a WHERE a.studentId = :studentId and a.date between :startDate and :endDate")
    public List<TmAttendance> findByBlock(Integer studentId, LocalDate startDate, LocalDate endDate);

    public List<TmAttendance> findAllByStudentId(Integer studentId);

}

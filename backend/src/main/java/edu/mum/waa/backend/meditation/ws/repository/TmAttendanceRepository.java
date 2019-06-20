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

    @Query(value = "SELECT a FROM TmAttendance a WHERE a.date between :startDate and :endDate")
    public List<TmAttendance>findTmAttendancesByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query(value="SELECT COUNT(DISTINCT a.studentId)  FROM TmAttendance a WHERE a.date BETWEEN :startDate AND :endDate")
    public Long findDistinctByStudentIdAndDateIsBetween(LocalDate startDate, LocalDate endDate);

    /*
    @Query(value = "select a from TmAttendance a where a.studentId in (select s.studentId from Students s where entry =:entry)")
    public List<TmAttendance> findTmAttendancesByEntry(String entry);
*/
    public Long countDistinctByStudentId(Integer studentId);

    @Query("Select count (a) from TmAttendance a where a.studentId = :studentId  and a.date= :date  and a.type = :type")
    Integer getAttendedRecord(@Param("studentId") Integer studentId,
                              @Param("date") LocalDate date, @Param("type") String type);
}

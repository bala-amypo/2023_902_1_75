package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {
    
    @Query("SELECT vl FROM VisitLog vl WHERE vl.visitor.id = :visitorId AND vl.entryTime >= :since")
    List<VisitLog> findByVisitorSince(@Param("visitorId") Long visitorId, @Param("since") LocalDateTime since);
    
    @Query("SELECT COUNT(vl) FROM VisitLog vl WHERE vl.visitor.id = :visitorId AND vl.entryTime BETWEEN :start AND :end")
    long countVisitsInWindow(@Param("visitorId") Long visitorId, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
    
    List<VisitLog> findByVisitorId(Long visitorId);
}
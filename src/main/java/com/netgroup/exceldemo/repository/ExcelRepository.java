package com.netgroup.exceldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netgroup.exceldemo.data.dao.Excel;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExcelRepository extends JpaRepository<Excel, Integer>{

    @Query(value="SELECT e FROM Excel e WHERE e.uploadDate BETWEEN ?1 AND ?2 ORDER BY e.uploadDate")
    List<Excel> findBetweenDates(LocalDate inizio,LocalDate fine);

}

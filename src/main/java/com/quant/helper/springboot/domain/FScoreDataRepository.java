package com.quant.helper.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FScoreDataRepository extends JpaRepository<FScoreData,Long> {

    //쿼리문 작성
    @Query(value = "TRUNCATE TABLE fscore_data", nativeQuery = true)
    Object truncateTable();

    @Query(value = "SELECT * FROM fscore_data f ORDER BY f.fscore DESC",nativeQuery = true)
    List<FScoreData> findFScoreDesc();

}

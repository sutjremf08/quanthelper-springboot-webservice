package com.quant.helper.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaseDataRepository extends JpaRepository<BaseData,Long> {

    //쿼리문 작성
    @Query(value = "TRUNCATE TABLE base_date", nativeQuery = true)
    Object truncateTable();

    @Query(value = "SELECT * FROM base_data b ORDER BY b.date,b.code DESC",nativeQuery = true)
    List<FScoreData> findBaseDesc();

    //코드값으로 조회하는 쿼리문 설정
}

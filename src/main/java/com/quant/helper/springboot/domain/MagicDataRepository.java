package com.quant.helper.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MagicDataRepository extends JpaRepository<MagicData,Long> {

    //쿼리문 작성
    @Query(value = "TRUNCATE TABLE magic_data", nativeQuery = true)
    Object truncateTable();

    @Query(value = "SELECT * FROM magic_data m ORDER BY m.rank ASC",nativeQuery = true)
    List<MagicData> findMagicAsc();
}

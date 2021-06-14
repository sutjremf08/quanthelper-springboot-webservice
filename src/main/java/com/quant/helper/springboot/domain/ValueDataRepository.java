package com.quant.helper.springboot.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ValueDataRepository extends JpaRepository<ValueData,Long> {

    //쿼리문 작성
    @Query(value = "TRUNCATE TABLE value_data", nativeQuery = true)
    Object truncateTable();

    @Query(value = "SELECT * FROM value_data v ORDER BY v.rank ASC",nativeQuery = true)
    List<ValueData> findValueAsc();

}

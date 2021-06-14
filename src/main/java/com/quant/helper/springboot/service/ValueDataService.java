package com.quant.helper.springboot.service;

import com.quant.helper.springboot.domain.ValueData;
import com.quant.helper.springboot.domain.ValueDataRepository;
import com.quant.helper.springboot.web.dto.ValueDataRequestDto;
import com.quant.helper.springboot.web.dto.ValueDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ValueDataService {

    private final ValueDataRepository valueDataRepository;

    @Transactional(readOnly = true)
    public ValueDataResponseDto findById(Long id) {
        ValueData entity = valueDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목코드가 없습니다." + id));
        return new ValueDataResponseDto(entity);
    }

    //list 출력
    @Transactional(readOnly = true)
    public List<ValueDataResponseDto> findValueAsc() {
        return valueDataRepository.findValueAsc().stream()
                .map(ValueDataResponseDto::new)
                .collect(Collectors.toList());
    }

    // 크롤링한 json 객체를 한꺼번에 테이블에 insert
    public void bulkUpdate(
            List<ValueDataRequestDto> requestList) {

        // 테이블 내 모든 데이터 삭제
        // deleteAll은 select를 먼저 수행하므로 상당한 비용을 동반
        // (대체할 수 있는 메서드가 무엇인지)
        valueDataRepository.deleteAll();

        // 모든 신규 데이터들 insert
        for (ValueDataRequestDto request : requestList) {
            valueDataRepository.save(request.toEntity());
        }

    }
}

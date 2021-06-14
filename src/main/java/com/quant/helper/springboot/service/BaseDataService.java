package com.quant.helper.springboot.service;

import com.quant.helper.springboot.domain.BaseData;
import com.quant.helper.springboot.domain.BaseDataRepository;
import com.quant.helper.springboot.web.dto.BaseDataRequestDto;
import com.quant.helper.springboot.web.dto.BaseDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BaseDataService {

    private final BaseDataRepository baseDataRepository;

    @Transactional(readOnly = true)
    public BaseDataResponseDto findById(Long id) {
        BaseData entity = baseDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 종목코드가 없습니다." + id));
        return new BaseDataResponseDto(entity);
    }

    // 크롤링한 json 객체를 한꺼번에 테이블에 insert
    public void bulkUpdate(
            List<BaseDataRequestDto> requestList) {

        // 테이블 내 모든 데이터 삭제
        // deleteAll은 select를 먼저 수행하므로 상당한 비용을 동반
        // (대체할 수 있는 메서드가 무엇인지)
        baseDataRepository.deleteAll();

        // 모든 신규 데이터들 insert
        for (BaseDataRequestDto request : requestList) {
            baseDataRepository.save(request.toEntity());
        }

    }
}
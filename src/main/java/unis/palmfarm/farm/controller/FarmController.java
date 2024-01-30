package unis.palmfarm.farm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import unis.palmfarm.farm.dto.FarmDetailResponseDTO;
import unis.palmfarm.farm.dto.FarmRequestDTO;
import unis.palmfarm.farm.dto.FarmResponseDTO;
import unis.palmfarm.farm.service.FarmService;
import unis.palmfarm.good.service.GoodService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class FarmController {
    private final FarmService farmService;
    private final GoodService goodService;
    //농가 등록
    @PostMapping("/api/farm")
    public void save(FarmRequestDTO farmRequestDTO) throws IOException {
        farmService.saveFarm(farmRequestDTO);
    }

    // 농가 전체 리스트 조회
    @GetMapping("/api/farm") //  페이지 크기 12 정렬은 name속성 ASC 오름차순 지정 , name기준으로
    public List<FarmResponseDTO> listFarm(@PageableDefault(sort = {"name"}, direction =Sort.Direction.ASC, size = 12) Pageable pageable) {
        return farmService.findAllFarm(pageable);// 농장 정보에 대한 데이터 전송 객체
    }

    //한 농가 상세 조회
    @GetMapping("/api/farm/{farmId}")
    public FarmDetailResponseDTO findOneFarm(@PathVariable("farmId") Long farmId){
        Long goodCount = goodService.getGoodCountFarm(farmId);
        return farmService.findById(farmId, goodCount);
    }

    //농가 지역별 검색 **서울 경기 인천 강원 충청 경상 전라 제주**
    @GetMapping("/api/farm/search")
    public List<FarmResponseDTO> findSameRegionFarm(@RequestParam("regName") String region,  @PageableDefault(sort = {"name"},direction = Sort.Direction.ASC, size = 12) Pageable pageable){
        System.out.println("서울 나왔으면 " + region);
        return farmService.findSameRegion(region , pageable);
    }


}

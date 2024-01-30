package unis.palmfarm.farm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import unis.palmfarm.config.S3Config;
import unis.palmfarm.farm.dto.FarmDetailResponseDTO;
import unis.palmfarm.farm.dto.FarmRequestDTO;
import unis.palmfarm.farm.dto.FarmResponseDTO;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.farm.repository.FarmRepository;
import unis.palmfarm.farm.repository.FarmSearchRepository;


import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;
    private final FarmSearchRepository farmSearchRepository;
    private final S3Config s3Config;

    public void saveFarm(FarmRequestDTO farmRequestDTO){
        try{
            if (farmRequestDTO.getImgUrl() != null) {
                String filePath = s3Config.upload(farmRequestDTO.getImgUrl());
                farmRequestDTO.toEntity().setImgUrl(filePath);
            }
            farmRepository.save(farmRequestDTO.toEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FarmResponseDTO> findAllFarm(Pageable pageable){
        return farmRepository.findAll(pageable).stream().map(FarmResponseDTO::new).collect(Collectors.toList());
    }

    public List<FarmEntity> findFarm(){
        return farmRepository.findAll();
    }


    public FarmDetailResponseDTO findById(Long id, Long goodCount){
        FarmEntity farmEntity = farmRepository.findById(id).orElse(null);
        if (farmEntity != null) {
            return new FarmDetailResponseDTO(farmEntity,goodCount);
        }
        return null;
    }

    public List<FarmResponseDTO> findSameRegion(String region, Pageable pageable){
        System.out.println("wow");
        return farmSearchRepository.findSameRegion(region, pageable).stream().map(FarmResponseDTO::new).collect(Collectors.toList());
    }



}

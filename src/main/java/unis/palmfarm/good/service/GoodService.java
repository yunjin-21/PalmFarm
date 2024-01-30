package unis.palmfarm.good.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.farm.repository.FarmRepository;
import unis.palmfarm.good.dto.GoodRequestDTO;
import unis.palmfarm.good.dto.GoodResponseDTO;
import unis.palmfarm.good.entity.GoodEntity;
import unis.palmfarm.good.repository.GoodRepository;
import unis.palmfarm.good.repository.GoodSearchRepository;
import unis.palmfarm.user.entity.UserEntity;
import unis.palmfarm.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodService {
    private final GoodRepository goodRepository;
    private final FarmRepository farmRepository;
    private final UserRepository userRepository;
    private final GoodSearchRepository goodSearchRepository;

    public void good(GoodRequestDTO goodRequestDTO){
        Long goodId = goodSearchRepository.findGoodByUserIdAndFarmId(goodRequestDTO.getUserId(), goodRequestDTO.getFarmId());

        if(goodId == null){
            Optional<FarmEntity> farmEntity = farmRepository.findById(goodRequestDTO.getFarmId());
            Optional<UserEntity> userEntity = userRepository.findById(goodRequestDTO.getUserId());
            goodRepository.save(GoodEntity.builder().farmEntity(farmEntity.get()).userEntity(userEntity.get()).build());
        }else {
            goodRepository.deleteById(goodId);
        }
    }

    public List<GoodResponseDTO> userGoodList(Long userId){
        return goodSearchRepository.findGoodList(userId).stream().map(GoodResponseDTO::new).collect(Collectors.toList());
    }

    public GoodResponseDTO userGoodRecent(){
        GoodEntity recentGood = goodSearchRepository.findRecentGood();
        return new GoodResponseDTO(recentGood);
    }

    public Long getGoodCountFarm(Long farmId){
        return goodSearchRepository.goodCountFarm(farmId);
    }

}

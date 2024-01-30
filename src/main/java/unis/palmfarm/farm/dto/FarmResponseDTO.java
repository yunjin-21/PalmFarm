package unis.palmfarm.farm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import unis.palmfarm.farm.entity.FarmEntity;

@Getter
@NoArgsConstructor
public class FarmResponseDTO {
    private String name;
    private String imgUrl;
    private String region;


    public  FarmResponseDTO(FarmEntity farmEntity){
        this.name = farmEntity.getName();
        this.imgUrl = farmEntity.getImgUrl();
        this.region = farmEntity.getRegion();
    }
}
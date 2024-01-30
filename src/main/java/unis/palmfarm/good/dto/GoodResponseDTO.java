package unis.palmfarm.good.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.good.entity.GoodEntity;

@Getter
@NoArgsConstructor
public class GoodResponseDTO {//(농가이름+이미지+지역)
    private String name;
    private String imgUrl;
    private String region;

    public  GoodResponseDTO(GoodEntity goodEntity){
        this.name = goodEntity.getFarmEntity().getName();
        this.imgUrl = goodEntity.getFarmEntity().getImgUrl();
        this.region = goodEntity.getFarmEntity().getRegion();
    }
}
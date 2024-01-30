package unis.palmfarm.farm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import unis.palmfarm.farm.entity.FarmEntity;

@Getter
@NoArgsConstructor
public class FarmDetailResponseDTO {
    private Long id;
    private String name;
    private String imgUrl;
    private String region;
    private String address;

    private String recruitPeriod; // 모집 기간
    private String volunteerTime; // 봉사 시간
    private String recruiter; // 모집 인원
    private String agency; // 모집 기관

    private Long goodCount;
    public  FarmDetailResponseDTO(FarmEntity farmEntity, Long goodCount){
        this.id = farmEntity.getId();
        this.name = farmEntity.getName();
        this.imgUrl = farmEntity.getImgUrl();
        this.region = farmEntity.getRegion();
        this.address = farmEntity.getAddress();
        this.recruitPeriod = farmEntity.getRecruitPeriod();
        this.volunteerTime = farmEntity.getVolunteerTime();
        this.recruiter = farmEntity.getRecruiter();
        this.agency = farmEntity.getAgency();
        this.goodCount = goodCount;
    }
}

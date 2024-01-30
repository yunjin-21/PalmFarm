package unis.palmfarm.farm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import unis.palmfarm.farm.entity.FarmEntity;

@Getter @Setter
@NoArgsConstructor
public class FarmRequestDTO {
    private MultipartFile imgUrl;
    private String name;//제목: 무궁화 농장 텃밭 가꾸기
    private String region; // 지역이름
    private String address; // 봉사 주소
    private String recruitPeriod; // 모집 기간
    private String volunteerTime; // 봉사 시간
    private String recruiter; // 모집 인원
    private String agency; // 모집 주체
    public FarmEntity toEntity() {
        return FarmEntity.builder()
                .name(name)
                .imgUrl(imgUrl != null ? imgUrl.getOriginalFilename() : null)
                .region(region)
                .address(address)
                .recruitPeriod(recruitPeriod)
                .volunteerTime(volunteerTime)
                .recruiter(recruiter)
                .agency(agency)
                .build();
    }

    // 다른 필드 및 메서드들

    public void setImgUrl(MultipartFile imgUrl) {
        this.imgUrl = imgUrl;
    }
}
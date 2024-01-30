package unis.palmfarm.farm.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unis.palmfarm.comment.entity.CommentEntity;
import unis.palmfarm.good.entity.GoodEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "farms")
@NoArgsConstructor // 디폴트 생성자를 생성해줌
public class FarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="farm_id")
    private Long id;
    private String name;
    private String imgUrl;
    private String region;
    private String address;// Address클래스로 나누어도 될듯!

    private String recruitPeriod; // 모집 기간
    private String volunteerTime; // 봉사 시간
    private String recruiter; // 모집 인원
    private String agency; // 모집 기간

    @OneToMany(mappedBy = "farmEntity")
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "farmEntity")
    private List<GoodEntity> goodEntityList = new ArrayList<>();

    // 빌더 패턴으로 객체 생성
    @Builder
    public FarmEntity(String name, String imgUrl, String region, String address, String recruitPeriod, String volunteerTime, String recruiter, String agency){
        this.name = name;
        this.imgUrl = imgUrl;
        this.region = region;
        this.address = address;
        this.recruitPeriod = recruitPeriod;
        this.volunteerTime = volunteerTime;
        this.recruiter = recruiter;
        this.agency = agency;
    }

}

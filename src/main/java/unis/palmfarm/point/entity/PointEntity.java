package unis.palmfarm.point.entity;

import lombok.Getter;
import lombok.Setter;
import unis.palmfarm.user.entity.UserEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "points")
public class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="point_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}

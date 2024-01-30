package unis.palmfarm.good.entity;

import lombok.*;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.user.entity.UserEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter @Builder
@Table(name="goods")
@NoArgsConstructor
@AllArgsConstructor
public class GoodEntity {
    @GeneratedValue
    @Id
    @Column(name="good_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="farm_id")
    private FarmEntity farmEntity;

}

package unis.palmfarm.comment.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.user.entity.UserEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comments")@NoArgsConstructor
public class CommentEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private Long id;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="farm_id")
    private FarmEntity farmEntity;

    public void changeContent(String content){
        this.content =content;
    }
    @Builder
    public CommentEntity(String title, String content, UserEntity userEntity, FarmEntity farmEntity,Rating rating){
        this.title =title;
        this.content =content;
        this.userEntity =userEntity;
        this.farmEntity =farmEntity;
        this.rating = rating;
    }

}
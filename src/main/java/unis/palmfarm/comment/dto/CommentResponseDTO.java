package unis.palmfarm.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import unis.palmfarm.comment.entity.CommentEntity;
import unis.palmfarm.comment.entity.Rating;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDTO {
    private String title;
    private String content;
    private String nickname;

    private Rating rating;
    private LocalDateTime createDateTime;

    //수정 시간은 반영?? 보류
    private LocalDateTime modifiedDateTime;

    public CommentResponseDTO(CommentEntity commentEntity){
        this.title = commentEntity.getTitle();
        this.content = commentEntity.getContent();
        this.nickname = commentEntity.getUserEntity().getNickname();
        this.createDateTime = commentEntity.getCreateDateTime();
        this.modifiedDateTime = commentEntity.getModifiedDateTime();
        this.rating = commentEntity.getRating();
    }
}

package unis.palmfarm.comment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unis.palmfarm.comment.entity.Rating;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDTO {
    private Long farmId;
    private Long userId;

    private String title;
    private String content;

    private Rating rating;
}

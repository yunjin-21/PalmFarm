package unis.palmfarm.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unis.palmfarm.comment.dto.CommentRequestDTO;
import unis.palmfarm.comment.dto.CommentResponseDTO;
import unis.palmfarm.comment.dto.CommentUpdateRequestDTO;
import unis.palmfarm.comment.service.CommentService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/comment")
    public void saveComment(@Valid @RequestBody CommentRequestDTO commentRequestDTO){
        commentService.saveComment(commentRequestDTO);
    }

    //한개 농가에 대한 후기 전체 조회
    @GetMapping("/comment/farm/{farmId}")
    public List<CommentResponseDTO> findOneFarmComment(@PathVariable(value = "farmId")Long farmId){
        return commentService.findOneFarmComment(farmId);
    }

    //여러 농가에 대한 후기들 (여러 사용자가 입력한 다양한 농가 후기) 전체 조회 title 속성을 기준으로
    @GetMapping("/comment")
    public List<CommentResponseDTO> findAllFarmComment(@PageableDefault(sort={"title"}, direction = Sort.Direction.ASC, size = 10) Pageable pageable){
        return commentService.findAllComment(pageable);
    }

    // 여러사용자가 입력한 전체 농가 후기중 최근 3개 후기 조회
    @GetMapping("/comment/recent")
    public List<CommentResponseDTO> findRecentFarmComment(){
        return commentService.findThreeCommentsByAllUsers();
    }

    // 한 사용자가 작성한 여러 농가에 대한 후기들 전체 조회
    @GetMapping("/comment/user/{userId}")
    public List<CommentResponseDTO> findAllCommentByUser(@PathVariable(value = "userId")Long userId){
        return commentService.findOneUserAllComment(userId);
    }

    //내가 작성한 후기 중 최근에 작성한 최근 후기 1개 조회
    @GetMapping("/comment/user/recent/{userId}")
    public CommentResponseDTO findOneCommentByUser(@PathVariable(value = "userId")Long userId){
        return commentService.findOneUserOneComment(userId);
    }




    //comment 삭제 -> commentId 1번 삭제했더니 1번이 아예 없는게 맞겠지??
    @DeleteMapping("/comment/{commentId}")
    public void deleteComment(@PathVariable(value = "commentId")Long commentId){
        commentService.deleteComment(commentId);
    }

    //comment 수정
    @PatchMapping("/comment/{commentId}")
    public void updateComment(@PathVariable(value = "commentId")Long commentId, @RequestBody CommentUpdateRequestDTO commentUpdateRequestDTO){
        commentService.updateComment(commentId, commentUpdateRequestDTO.getContent());
    }

}
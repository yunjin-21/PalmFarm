package unis.palmfarm.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unis.palmfarm.comment.dto.CommentRequestDTO;
import unis.palmfarm.comment.dto.CommentResponseDTO;
import unis.palmfarm.comment.entity.CommentEntity;
import unis.palmfarm.comment.entity.Rating;
import unis.palmfarm.comment.repository.CommentRepository;
import unis.palmfarm.comment.repository.FindCommentRespository;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.farm.repository.FarmRepository;
import unis.palmfarm.user.entity.UserEntity;
import unis.palmfarm.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final FarmRepository farmRepository;
    private final FindCommentRespository findCommentRespository;

    public void saveComment(CommentRequestDTO commentRequestDTO) {
        Optional<FarmEntity> farmEntity = farmRepository.findById(commentRequestDTO.getFarmId());
        Optional<UserEntity> userEntity = userRepository.findById(commentRequestDTO.getUserId());
        String title = commentRequestDTO.getTitle();
        String content = commentRequestDTO.getContent();
        Rating rating = commentRequestDTO.getRating();
        commentRepository.save(CommentEntity.builder().farmEntity(farmEntity.get()).userEntity(userEntity.get()).title(title).content(content).rating(rating).build());
    }

    public List<CommentResponseDTO> findOneFarmComment(Long farmId) {
        return findCommentRespository.findOneFarmByComment(farmId).stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }

    public List<CommentResponseDTO> findAllComment(Pageable pageable){
        return commentRepository.findAll(pageable).stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }

    public List<CommentResponseDTO> findThreeCommentsByAllUsers(){
        return findCommentRespository.findThreeCommentsByAll().stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }

    public List<CommentResponseDTO> findOneUserAllComment(Long userId){
        return findCommentRespository.findOneUserByComment(userId).stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }

    public CommentResponseDTO findOneUserOneComment(Long userId){
        CommentEntity recentComment =  findCommentRespository.findOneUserByOneComment(userId);
        return new CommentResponseDTO(recentComment);
    }



    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }

    public void updateComment(Long commentId, String content){
        Optional<CommentEntity> commentEntity = commentRepository.findById(commentId);
        commentEntity.get().changeContent(content);
    }
}
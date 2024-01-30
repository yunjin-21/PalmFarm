package unis.palmfarm.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unis.palmfarm.comment.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}

package unis.palmfarm.comment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unis.palmfarm.comment.entity.CommentEntity;
import unis.palmfarm.comment.entity.QCommentEntity;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.farm.entity.QFarmEntity;
import unis.palmfarm.user.entity.QUserEntity;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FindCommentRespository {
    public final JPAQueryFactory jpaQueryFactory;
    QFarmEntity qfarmEntity = QFarmEntity.farmEntity;
    QCommentEntity qCommentEntity = QCommentEntity.commentEntity;
    QUserEntity qUserEntity = QUserEntity.userEntity;
    //한개 농장아이디로 한 개 농장에 대한 여러 후기를 가져옴
    public List<CommentEntity> findOneFarmByComment(Long farmId){
        return jpaQueryFactory.select(qCommentEntity)
                .from(qCommentEntity)
                .innerJoin(qCommentEntity.userEntity,qUserEntity)
                .fetchJoin()
                .where(qCommentEntity.farmEntity.id.eq(farmId))
                .fetch();

    }

    //한개 사용자아이디로 여러 농장에 대한 여러 후기를 가져옴
    public List<CommentEntity> findOneUserByComment(Long userId){
        return jpaQueryFactory.select(qCommentEntity)
                .from(qCommentEntity)
                .innerJoin(qCommentEntity.farmEntity, qfarmEntity)
                .fetchJoin()
                .where(qCommentEntity.userEntity.id.eq(userId))
                .fetch();
    }

    //전체 농가 후기들중 최근 3개의 후기 정보 가져옴
    public List<CommentEntity> findThreeCommentsByAll(){
        List<Long> recentCommentIds = jpaQueryFactory.select(qCommentEntity.id.max())
                .from(qCommentEntity)
                .groupBy(qCommentEntity.id)
                .orderBy(qCommentEntity.id.desc()) //가장 큰 id부터 내림차순
                .limit(3)
                .fetch();

        if(recentCommentIds.isEmpty()){
            return Collections.emptyList();
        }
        return jpaQueryFactory.select(qCommentEntity)
                .from(qCommentEntity)
                .where(qCommentEntity.id.in(recentCommentIds)) //중요!
                .orderBy(qCommentEntity.id.desc())  //modified date time으로 바꿔야 할듯!
                .fetch();
    }

    //한 사용자의 최근 후기 정보
    public CommentEntity findOneUserByOneComment(Long userId){
        return jpaQueryFactory.select(qCommentEntity)
                .from(qCommentEntity)
                .innerJoin(qCommentEntity.farmEntity, qfarmEntity)
                .fetchJoin()
                .where(qCommentEntity.userEntity.id.eq(userId))
                .orderBy(qCommentEntity.id.desc())
                .limit(1)
                .fetchOne();
    }



}

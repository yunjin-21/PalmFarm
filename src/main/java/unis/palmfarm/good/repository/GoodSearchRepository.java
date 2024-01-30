package unis.palmfarm.good.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import unis.palmfarm.farm.entity.QFarmEntity;
import unis.palmfarm.good.entity.GoodEntity;
import unis.palmfarm.good.entity.QGoodEntity;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GoodSearchRepository {
    private final JPAQueryFactory jpaQueryFactory;
    QFarmEntity qFarmEntity = QFarmEntity.farmEntity;
    QGoodEntity qGoodEntity = QGoodEntity.goodEntity;

    //userId와 farmId에 해당하는 좋아요 정보의 id를 반환
    public Long findGoodByUserIdAndFarmId(Long userId, Long farmId){
        return jpaQueryFactory.select(qGoodEntity.id)
                .from(qGoodEntity).where(qGoodEntity.farmEntity.id.eq(farmId).and(qGoodEntity.userEntity.id.eq(userId)))
                .fetchOne();
    }

    //한개의 사용자 아이디로 좋아요한 농장들에 대한 여러 정보 가져옴
    public List<GoodEntity> findGoodList(Long userId){
        return jpaQueryFactory.select(qGoodEntity)//좋아요에 대한 모든 필드 선택
                .from(qGoodEntity) // 조회할 엔티티 지정
                .innerJoin(qGoodEntity.farmEntity, qFarmEntity) // farmEntity필드와 qFarmEntity를 연결하고 함께 로드
                .fetchJoin()
                .where(qGoodEntity.userEntity.id.eq(userId)) // 조회 조건 지정
                .fetch();
    }

    //최근에 좋아요 누른 한개의 농장 정보 가져옴
    public GoodEntity findRecentGood(){
        Long recentGoodId = jpaQueryFactory.select(qGoodEntity.id.max())
                .from(qGoodEntity)
                .fetchOne();

        if(recentGoodId == null){
            return null;
        }
        return jpaQueryFactory.select(qGoodEntity)
                .from(qGoodEntity)
                .innerJoin(qGoodEntity.farmEntity,qFarmEntity)
                .fetchJoin()
                .where(qGoodEntity.id.eq(recentGoodId))
                .fetchOne();

    }

    //한 농가의 좋아요 개수 반환
    public Long goodCountFarm(Long farmId){
        return jpaQueryFactory.select(qGoodEntity.id.count())
                .from(qGoodEntity)
                .where(qGoodEntity.farmEntity.id.eq(farmId))
                .fetchOne();
    }

}

package unis.palmfarm.farm.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.farm.entity.QFarmEntity;

import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FarmSearchRepository {
    private final JPAQueryFactory jpaQueryFactory;
    QFarmEntity qFarmEntity = QFarmEntity.farmEntity;

    //지역(ex 서울)을 누르면 서울 지역의 해당하는 농가 정보를 반환
    public List<FarmEntity> findSameRegion(String region, Pageable pageable){
        System.out.println("Region: " + region); // 경기,서울

        List<FarmEntity> result =  jpaQueryFactory.select(qFarmEntity)
                .from(qFarmEntity)
                .where(qFarmEntity.region.eq(region))
                .offset(pageable.getOffset())//현재 페이지의 시작위치  만약 2페이지 요청 크기가 10이면 10을 반환
                .limit(pageable.getPageSize()) // 페이지 크기  11~20 반환
                .fetch();

        System.out.println("Query Result: " + result);
        return result;
    }
}

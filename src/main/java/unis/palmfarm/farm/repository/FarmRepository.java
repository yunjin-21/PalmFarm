package unis.palmfarm.farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import unis.palmfarm.farm.entity.FarmEntity;

import java.util.List;


public interface FarmRepository extends JpaRepository<FarmEntity,Long> {
   // Page<FarmEntity> findAllByOrderByGoodCountDesc(Pageable pageable);
}

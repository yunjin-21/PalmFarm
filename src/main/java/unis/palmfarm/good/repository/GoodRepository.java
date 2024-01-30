package unis.palmfarm.good.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unis.palmfarm.farm.entity.FarmEntity;
import unis.palmfarm.good.entity.GoodEntity;
import unis.palmfarm.user.entity.UserEntity;

public interface GoodRepository extends JpaRepository<GoodEntity,Long> {
}

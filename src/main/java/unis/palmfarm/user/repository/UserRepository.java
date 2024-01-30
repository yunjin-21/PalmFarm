package unis.palmfarm.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unis.palmfarm.user.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> { // Long id pk 확인 ! crud 연산 지원
    //Optional<UserEntity> findById(Long id);
    //이메일로 회원정보 조회 (select * from user where user_email=?)
    //Optional<UserEntity> findByUserEmail(String userEmail);

    Optional<UserEntity> findOneByMyidAndPassword(String myid, String password);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByMyid(String myid);
    Optional<UserEntity> findByNickname(String nickname);

}
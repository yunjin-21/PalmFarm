package unis.palmfarm.profile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unis.palmfarm.profile.dto.ProfileDTO;
import unis.palmfarm.user.entity.UserEntity;
import unis.palmfarm.user.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileService {
    private final UserRepository userRepository;

    public Optional<UserEntity> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public ProfileDTO buildProfileDTO(UserEntity userEntity){
        return ProfileDTO.builder()
                .nickname(userEntity.getNickname())
                .email(userEntity.getEmail())
                .build();
    }
}

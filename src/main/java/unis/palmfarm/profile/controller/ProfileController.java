package unis.palmfarm.profile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unis.palmfarm.profile.dto.ProfileDTO;
import unis.palmfarm.profile.service.ProfileService;
import unis.palmfarm.user.entity.UserEntity;


import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/{userId}")
    public ResponseEntity<ProfileDTO> getProfile(@PathVariable("userId") Long userId) {
        Optional<UserEntity> userEntityOptional = profileService.getUserById(userId);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            ProfileDTO profileDTO = profileService.buildProfileDTO(userEntity);
            return ResponseEntity.ok(profileDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
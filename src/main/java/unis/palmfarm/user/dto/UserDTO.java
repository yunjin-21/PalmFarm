package unis.palmfarm.user.dto;

import lombok.*;
import unis.palmfarm.user.entity.UserEntity;

@Getter @Setter
@RequiredArgsConstructor
@ToString
public class UserDTO {
    private String myid;
    private String password;
    private String nickname;
    private String email;

    public static UserDTO ToUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setMyid(userEntity.getMyid());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setNickname(userEntity.getNickname());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }


}
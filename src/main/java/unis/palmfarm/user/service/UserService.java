package unis.palmfarm.user.service;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unis.palmfarm.user.dto.LoginDTO;
import unis.palmfarm.user.dto.UserDTO;
import unis.palmfarm.user.entity.UserEntity;
import unis.palmfarm.user.message.LoginMessage;
import unis.palmfarm.user.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String signup(UserDTO userDTO){
        // dto -> entity 변환
        UserEntity userEntity = UserEntity.toUserEntity(userDTO);
       // 비번만 패스워드인코드 다시 세팅
        //userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        //userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        // repository의 save메서드 호출 jpa가 제공해줌
        userRepository.save(userEntity);
        // 레포지토리의 save메서드 호출 (조건 entity 객체를 넘겨줘야 함)

        return userEntity.getNickname();
    }

    @Transactional
    public LoginMessage login(LoginDTO loginDTO){
        String msg="";
        Optional<UserEntity> userEntity = userRepository.findByMyid(loginDTO.getMyid());
        if(userEntity.isPresent()){
            UserEntity userEntity1 = userEntity.get();
            if(userEntity1.getPassword().equals(loginDTO.getPassword())){
                Optional<UserEntity> userEntity2 = userRepository.findOneByMyidAndPassword(loginDTO.getMyid(), loginDTO.getPassword());
                if(userEntity2.isPresent()){
                    return new LoginMessage("login success", true);
                }else{
                    return new LoginMessage("login failed", false);
                }
            }else{
                return new LoginMessage("password is not matched", false);
            }
        }else {
            return new LoginMessage("myid is not existed", false);
        }

    }


    /*@Transactional
    public UserDTO login(LoginDTO loginDTO){
        String msg="";
        Optional<UserEntity> userEntity = userRepository.findByMyid(loginDTO.getMyid());
        if(userEntity.isPresent()){
            UserEntity userEntity1 = userEntity.get();
            if(userEntity1.getPassword().equals(loginDTO.getPassword())){
                Optional<UserEntity> userEntity2 = userRepository.findOneByMyidAndPassword(loginDTO.getMyid(), loginDTO.getPassword());
                if(userEntity2.isPresent()){
                    UserDTO userDTO = new UserDTO();
                    userDTO.setNickname(userEntity1.getNickname()); // 닉네임 반환해서 로그인 했을때 닉네임 보이게??
                    return userDTO;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }else {
            return null;
        }

    }*/
}
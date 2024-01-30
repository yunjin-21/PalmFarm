package unis.palmfarm.user.entity;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import unis.palmfarm.comment.entity.CommentEntity;
import unis.palmfarm.comment.entity.CommentEntity;
import unis.palmfarm.good.entity.GoodEntity;
import unis.palmfarm.user.dto.UserDTO;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "users")
public class UserEntity {//테이블 역할
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name="user_id")
    private Long id;

    @NotEmpty
    private String myid;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    @NotEmpty @Email
    private String email;

    @OneToMany(mappedBy = "userEntity")
    private List<GoodEntity> goodEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity")
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public static UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setMyid(userDTO.getMyid());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setNickname(userDTO.getNickname());
        userEntity.setEmail(userDTO.getEmail());
        return userEntity;
    }

}
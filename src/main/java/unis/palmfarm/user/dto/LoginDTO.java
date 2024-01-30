package unis.palmfarm.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class LoginDTO {
    private String myid;
    private String password;

    public LoginDTO(String myid, String password){
        this.myid = myid;
        this.password = password;
    }

}

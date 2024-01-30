package unis.palmfarm.user.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class LoginMessage {
    String message;
    Boolean status;

    public LoginMessage(String message,Boolean status){
        this.message = message;
        this.status = status;
    }
}

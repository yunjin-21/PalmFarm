package unis.palmfarm.profile.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder//객체를 생성할때 매개변수 순서나 타입에 구애x
public class ProfileDTO {
    private final String nickname;
    private final String email;
}

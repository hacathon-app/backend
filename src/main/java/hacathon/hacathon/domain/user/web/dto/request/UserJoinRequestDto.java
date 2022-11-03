package hacathon.hacathon.domain.user.web.dto.request;

import hacathon.hacathon.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinRequestDto {

    private String name;
    private String password;

    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .build();
    }
}

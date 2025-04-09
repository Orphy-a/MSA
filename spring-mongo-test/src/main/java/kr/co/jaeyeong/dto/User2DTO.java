package kr.co.jaeyeong.dto;

import kr.co.jaeyeong.document.User2Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2DTO {

    private String uid;
    private String name;
    private String hp;
    private int age;

    public User2Document toDocument(){
        return User2Document.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }

}

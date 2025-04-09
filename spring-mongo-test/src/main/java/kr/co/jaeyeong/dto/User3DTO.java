package kr.co.jaeyeong.dto;

import kr.co.jaeyeong.document.User3Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User3DTO {

    private String uid;
    private String name;
    private String birth;
    private int age;


    public User3Document toDocument(){
        return User3Document.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }


}

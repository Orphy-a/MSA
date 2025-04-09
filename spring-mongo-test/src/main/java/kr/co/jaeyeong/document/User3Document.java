package kr.co.jaeyeong.document;

import kr.co.jaeyeong.dto.User3DTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "user3")
public class User3Document {

    @Id
    private String _id;

    private String uid;
    private String name;
    private String birth;
    private int age;


    public User3DTO toDTO(){
        return User3DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }



}

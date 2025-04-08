package kr.co.jaeyeong.document;

import kr.co.jaeyeong.dto.User2DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2Document {

    @Id
    private String _id;

    private String uid;
    private String name;
    private String hp;
    private int age;

    public User2DTO toDTO(){

        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();

    }


}

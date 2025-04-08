package kr.co.jaeyeong.service;

import kr.co.jaeyeong.document.User2Document;
import kr.co.jaeyeong.dto.User2DTO;
import kr.co.jaeyeong.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class User2Service {

    private final User2Repository user2Repository;


    public void save(User2DTO user2DTO) {

        User2Document doc = user2DTO.toDocument();
        log.info(user2DTO.toString());

        user2Repository.save(doc);

    }

    public void findById(){}

    public List<User2DTO> findAll(){

        List<User2Document> docs = user2Repository.findAll();

        List<User2DTO> dtos = docs.stream().map((document)-> {
            User2DTO dto = document.toDTO();
            return dto;
        }).toList();

        return dtos;

    }

    public void modify(){}

    public void delete(){}

}

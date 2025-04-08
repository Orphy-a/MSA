package kr.co.jaeyeong.service;

import kr.co.jaeyeong.document.User2Document;
import kr.co.jaeyeong.dto.User2DTO;
import kr.co.jaeyeong.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public List<User2DTO> findAll(){

        List<User2Document> docs = user2Repository.findAll();

        List<User2DTO> dtos = docs.stream().map((document)->{
                User2DTO dto = document.toDTO();
                return dto;
            }).toList();


        return dtos;
    }

    public void findByUid(String uid){}

    public void register(User2DTO user2DTO){

        User2Document user2document = user2DTO.toDocument();

        user2Repository.save(user2document);


    }

    public void modify(){

    }

    public void delete(String uid){
        user2Repository.deleteByUid(uid);
    }


}

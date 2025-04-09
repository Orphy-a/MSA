package kr.co.jaeyeong.service;

import kr.co.jaeyeong.document.User2Document;
import kr.co.jaeyeong.dto.User1DTO;
import kr.co.jaeyeong.dto.User2DTO;
import kr.co.jaeyeong.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class User2Service {

    private final User2Repository user2Repository;

    public void save(User2DTO user2dto){

        User2Document user2document = user2dto.toDocument();

        user2Repository.save(user2document);

    }

    public User2DTO findByUid(String uid){

        Optional<User2Document> user2document = user2Repository.findByUid(uid);

        log.info("user2document {}", user2document);

        if(user2document.isPresent()){
            User2DTO user2dto = user2document.get().toDTO();
            return user2dto;
        }

        return null;

    }

    public void modify(User2DTO user2DTO){

        String uid = user2DTO.getUid();

        Optional<User2Document> optUser2 = user2Repository.findByUid(uid);

        if(optUser2.isPresent()){

            User2Document user2document = user2DTO.toDocument();
            user2document.set_id(optUser2.get().get_id());

            user2Repository.save(user2document);
        }


    }


    public List<User2DTO> findAll(){

        List<User2Document> user2Documents = user2Repository.findAll();

        List<User2DTO> user2DTOS = user2Documents.stream().map((document)->{
            User2DTO user2dto = document.toDTO();
            return user2dto;
        }).toList();

        return user2DTOS;

    }

    public void delete(String uid){

        user2Repository.deleteByUid(uid);

    }


}

package kr.co.jaeyeong.service;

import kr.co.jaeyeong.document.User3Document;
import kr.co.jaeyeong.dto.User3DTO;
import kr.co.jaeyeong.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User3Service {

    private final User3Repository user3Repository;

    public void save(User3DTO user3DTO){

        User3Document user3Document = user3DTO.toDocument();

        user3Repository.save(user3Document);

    }

    public User3DTO findById(String uid){

        log.info("uid : " + uid);

        Optional<User3Document> user3Document = user3Repository.findByUid(uid);

        log.info("user3Document : " + user3Document);

        if(user3Document.isPresent()){
            User3DTO user3dto = user3Document.get().toDTO();
            return user3dto;
        }

        return null;

    }

    public List<User3DTO> findAll(){

        List<User3Document> user3Documents = user3Repository.findAll();

        List<User3DTO> user3DTOS = user3Documents.stream()
                .map((document)-> {User3DTO user3dto = document.toDTO();
                return user3dto;})
                .toList();

        return user3DTOS;

    }

    public void modify(){

    }

    public void delete(String uid){

        user3Repository.deleteByUid(uid);

    }


}

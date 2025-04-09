package kr.co.jaeyeong.repository;

import kr.co.jaeyeong.document.User3Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User3Repository extends MongoRepository<User3Document,String> {
    void deleteByUid(String uid);

    Optional<User3Document> findByUid(String uid);
}

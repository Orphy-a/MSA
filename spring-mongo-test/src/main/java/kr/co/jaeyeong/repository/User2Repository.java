package kr.co.jaeyeong.repository;

import kr.co.jaeyeong.document.User2Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User2Repository extends MongoRepository<User2Document, String> {
    void deleteByUid(String uid);
}

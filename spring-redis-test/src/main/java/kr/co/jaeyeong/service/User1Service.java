package kr.co.jaeyeong.service;

import kr.co.jaeyeong.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@Service
public class User1Service {

    private final static String KEY = "user1";
    private final RedisTemplate<String, User1DTO> redisTemplate;

    public void save(User1DTO user1DTO) {
        redisTemplate.opsForHash().put(KEY, user1DTO.getUid(), user1DTO);
    }

    @Cacheable(value = KEY, key = "#uid")
    public User1DTO findByUid(String uid) {

        log.info("findByUid: {}!!!!!!!!!!!!!!!!!!!!!!", uid);

        return (User1DTO) redisTemplate.opsForHash().get(KEY, uid);
    }

    public Map<Object, Object> findAll(){

        return redisTemplate.opsForHash().entries(KEY);
    }

    public void update(User1DTO user1DTO) {
        // save와 동일
        redisTemplate.opsForHash().put(KEY, user1DTO.getName(), user1DTO);
    }

    public void delete(String uid) {
        redisTemplate.opsForHash().delete(KEY, uid);
    }



}

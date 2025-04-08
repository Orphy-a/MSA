package kr.co.jaeyeong.controller;

import kr.co.jaeyeong.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;


    @PostMapping("/redis/string")
    public void setValue(String key, String value) {
        mainService.setValue(key, value);
    }

    @GetMapping("redis/string/{key}")
    public ResponseEntity<String> getValue(@PathVariable("key") String key){

        String value = mainService.getValue(key);

        return ResponseEntity.ok().body(value);

    }

    @GetMapping("/redis/addToListFromRight")
    public void addToListFromRight(String key, String value) {

        mainService.addToListFromRight(key, value);
    }

    @GetMapping("/redis/addToListFromLeft")
    public void addToListFromLeft(String key, String value) {

        mainService.addToListFromLeft(key, value);
    }

    @GetMapping("/redis/getFromList")
    public void getFromList(String key, int index) {

        mainService.getFromList(key, index);
    }

    @GetMapping("/redis/getRangeFromList")
    public void getRangeFromList(String key, int start, int end) {

        mainService.getRangeFromList(key, start, end);
    }

    @PostMapping("/redis/set")
    public void addToSet(String key, String... values) {

        mainService.addToSet(key, values);
    }

    @GetMapping("/redis/set/{key}")
    public void getFromSet(String key) {

        mainService.getFromSet(key);
    }

    @PostMapping("/redis/addToHash")
    public void addToHash(String key, String hashKey, String value) {

        mainService.addToHash(key, hashKey, value);
    }


    @GetMapping("/redis/getFromHash")
    public void getFromHash(String key, String hashKey) {

        mainService.getFromHash(key, hashKey);
    }


}

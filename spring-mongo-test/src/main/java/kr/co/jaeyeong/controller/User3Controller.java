package kr.co.jaeyeong.controller;

import kr.co.jaeyeong.dto.User3DTO;
import kr.co.jaeyeong.repository.User3Repository;
import kr.co.jaeyeong.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class User3Controller {

    private final User3Service user3Service;

    @GetMapping("/user3/list")
    public String list(Model model){

        List<User3DTO> user3DTOS = user3Service.findAll();
        model.addAttribute("user3DTOS", user3DTOS);

        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){

        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO){

        user3Service.save(user3DTO);

        return "redirect:/user3/list";

    }


    @GetMapping("/user3/modify")
    public String modify(String uid, Model model){

        log.info("uid : " + uid);

        User3DTO user3DTO = user3Service.findById(uid);
        model.addAttribute("user3DTO", user3DTO);

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO){


        user3Service.save(user3DTO);

        return "redirect:/user3/list";
    }



    @GetMapping("/user3/delete")
    public String delete(String uid){

        log.info("uid : " + uid);

        user3Service.delete(uid);


        return "redirect:/user3/list";
    }

}

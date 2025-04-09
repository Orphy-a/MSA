package kr.co.jaeyeong.controller;

import kr.co.jaeyeong.dto.User2DTO;
import kr.co.jaeyeong.service.User2Service;
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
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2/list")
    public String list(Model model){


        List<User2DTO> user2DTOS = user2Service.findAll();


        model.addAttribute("user2DTOS", user2DTOS);

        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){

        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2dto){

        user2Service.save(user2dto);

        return "redirect:/user2/list";

    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model){

        User2DTO user2DTO = user2Service.findByUid(uid);
        model.addAttribute("user2DTO", user2DTO);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2dto){

        user2Service.modify(user2dto);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String uid){

        user2Service.delete(uid);

        return "redirect:/user2/list";
    }

}

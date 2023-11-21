package com.sdd.sbb4;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@Setter
@Controller
public class MainController {

    @GetMapping("/hello")
    @ResponseBody
    public String showHello() {
        return "안녕하세요";
    }
}

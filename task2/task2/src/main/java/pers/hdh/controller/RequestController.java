package pers.hdh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.hdh.model.User;

@Controller
public class RequestController {

    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user) {
//        System.out.println(user.toString());
        return user.toString();
    }
}

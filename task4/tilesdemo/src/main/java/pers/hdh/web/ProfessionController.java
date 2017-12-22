package pers.hdh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.hdh.model.Profession;
import pers.hdh.service.ProfessionService;

import java.util.List;

@Controller
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @RequestMapping(value="list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Profession> professionList = professionService.findAll(0, 6);
        model.addAttribute("list", professionList);
        return "t11";
    }
}

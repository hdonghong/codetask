package pers.hdh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.hdh.model.Applicant;
import pers.hdh.service.ApplicantService;

import java.util.List;

/**
 * 学员的控制器
 * @author Chandler
 */
@Controller
@RequestMapping("/applicant") // url: /模块/资源/{id}/细分
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value="list", method = RequestMethod.GET)
    public String list(Model model) {
        // 获取列表页
        List<Applicant> applicantList = applicantService.findAll(0, 4);
        model.addAttribute("list", applicantList);
        // xxx.jsp + model = ModelAndView
        return "t10"; // /"t10".jsp
    }
}

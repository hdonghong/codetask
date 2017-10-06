package pers.hdh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.hdh.bean.Applicant;
import pers.hdh.service.ApplicantService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {
    private static Logger log  = LoggerFactory.getLogger(ApplicantController.class);
    private ApplicantService service;

    @Autowired
    public void setCourseService(ApplicantService service) {
        this.service = service;
    }

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getApplicants(Model model) {
        List<Applicant> list = service.getApplicants();
//        log.info(""+list.size());
        model.addAttribute("list",list);
        return "index";
    }

    /**
     * 查询单个用户
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getApplicant(@RequestParam("id") Integer id, Model model) {
//        log.info(id+"?");
        Applicant applicant = service.getApplicant(id);
        List<Applicant> list = new ArrayList<Applicant>();
        list.add(applicant);
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * 跳转到添加用户页面
     * @return
     */
    @RequestMapping(value = "/addpage", method = RequestMethod.GET)
    public String addpage() {
        return "addpage";
    }

    /**
     * 添加用户
     * @param applicant
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addApplicant(Applicant applicant) {
        service.add(applicant);
        return "redirect:";
    }

    /**
     * 跳转到修改用户页面
     * @return
     */
    @RequestMapping(value="/editpage/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable("id") Integer id, Model model) {
        Applicant applicant = service.getApplicant(id);
        model.addAttribute("applicant", applicant);
        return "editpage";
    }

    /**
     * 修改用户
     * @param applicant
     * @return
     */
    @RequestMapping(value="/", method = RequestMethod.PUT)
    public String update(Applicant applicant) {
        service.update(applicant);
        return "redirect:";
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
//        log.info(id.toString());
        service.delete(id);
        return "redirect:";
    }

}

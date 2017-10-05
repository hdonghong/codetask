package pers.hdh.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.hdh.model.Course;
import pers.hdh.service.CourseService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private static Logger log  = LoggerFactory.getLogger(CourseController.class);

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    // 处理：http://localhost:8080/courses/view?courseId=123
    @RequestMapping(value="/view", method= RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
        log.debug("In viewCourse courseId = {}", courseId);

        Course course = courseService.getCoursebyId(courseId);
        model.addAttribute(course);
        return "course_overview";
    }

    // ResfFul风格：http://localhost:8080/courses/view/123
    @RequestMapping(value="/view2/{courseId}")
    public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
        log.debug("In viewCourse2 courseId = {}", courseId);

        Course course = courseService.getCoursebyId(courseId);
        model.put("course", course);
        return "course_overview";
    }

    // 使用Spring Mvc中HttpServletRequest
    @RequestMapping("/view3")
    public String viewCourse3(HttpServletRequest request) {
        Course course = courseService.getCoursebyId(
                Integer.parseInt(request.getParameter("courseId")));
        request.setAttribute("course", course);
        return "course_overview";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String createCourse() {
        return "course_admin/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String doSave(Course course) {
        log.debug("Info of Course");
        log.debug(ReflectionToStringBuilder.toString(course));

        // 在此进行业务操作，比如数据库持久化
        course.setCourseId(123);
        return "redirect:view2/"+course.getCourseId();
    }

    @RequestMapping("/upload")
    public String showUploadPage(Boolean multi){
        if (multi!=null && multi) {
            return "course_admin/multifile";
        }

        return "course_admin/file";
    }

    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            log.debug("Process File:{}", multipartFile.getOriginalFilename());
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File("F:\\",
                    System.currentTimeMillis()+ multipartFile.getOriginalFilename()));
        }
        return "success";
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public @ResponseBody Course getCourseInJson(Integer courseId) {
        return courseService.getCoursebyId(courseId);
    }

    @RequestMapping(value="/jsontype/{courseId}", method=RequestMethod.GET)
    public ResponseEntity<Course> getCourseInjson2(@PathVariable Integer courseId) {
        Course course = courseService.getCoursebyId(courseId);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}

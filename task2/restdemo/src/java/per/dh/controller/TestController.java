package per.dh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import per.dh.object.User;

@Controller
public class TestController {
    // 基本类型绑定
    @RequestMapping(value = "baseType.do")
    @ResponseBody // 方法的返回值会放到responsebody数据区里
    public String baseType(@RequestParam("xage") int age) { //通过注解起别名
        return "age : " + age;
    }

    // 包装类型绑定
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age2 : " + age;
    }

    // 数组类型绑定
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name) {
        StringBuilder sbf = new StringBuilder();
        for (String item : name) {
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    // 简单对象绑定:object.do?name=tom&age=11
    // 多层级对象绑定:object.do?name=tom&age=11&contactInfo.phone=110&contactInfo.address=china
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user) {
        return user.toString();
    }
}

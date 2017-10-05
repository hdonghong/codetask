package per.dh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import per.dh.object.*;

import java.util.List;

@Controller
public class DataBindingController {
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

    // 同属性多对象
    @RequestMapping(value = "object2.do")
    @ResponseBody
    public String Object2(User user, User2 user2) {
        return user.toString() + " " + user2.toString();
    }
    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }
    @InitBinder("user2")
    public void initUser2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user2.");
    }

    // List绑定
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userList) {
        return "listsize:" + userList.getUsers().size()+ " "+userList.toString();
    }

    // Set绑定
    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm userSet) {
        return "setsize:" + userSet.getUsers().size() + " " + userSet.toString();
    }

    // Map绑定
    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm) {
        return "mapsize:" + userMapForm.getUsers().size() + " " + userMapForm.toString();
    }

    // json绑定
    /* json格式传值
        {
          "name":"tom",
          "age":16,
          "contactInfo":{
            "phone":110,
            "address":"guangzhou"
          }
        }
    */
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user) {
        return user.toString();
    }

    // xml的数据绑定
    /*
        <?xml version="1.0" encoding="UTF-8" ?>
        <admin>
          <name>Jim</name>
          <age>16</age>
        </admin>
     */
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin) {
        return admin.toString();
    }
}

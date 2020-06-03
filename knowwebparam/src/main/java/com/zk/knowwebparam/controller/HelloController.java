package com.zk.knowwebparam.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面以html进行结尾
 * json数据以json进行结尾
 */
@RestController
public class HelloController {

    @RequestMapping("/hello.html")
    public String sayHello(Model model){
        //model用来保存在页面元素中使用的变量
        return "success";
    }

    public ModelAndView sayWorld(){
        ModelAndView mv=new ModelAndView();
        //mv用来保存页面的变量以及要跳转的页面信息
        return mv;
    }
}

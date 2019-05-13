package com.example.ValidationForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class EmpController {


    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("emp", new Emp());
        model.addAttribute("ajayemp", Arrays.asList( new Emp(1,"aaa","bbb"),new Emp(2,"ccc","ddd"),
                new Emp(3,"eee","fff"),new Emp(4,"ggg","hhh") ));

        return "index";
    }

    @PostMapping("/")//@ModelAttribute
    public String helloadd(@Valid Emp emp, BindingResult res,Model model) {
        if(res.hasErrors()) {
            return "index";
        }
        return "success";
    }


}

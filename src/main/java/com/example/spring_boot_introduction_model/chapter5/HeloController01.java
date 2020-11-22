package com.example.spring_boot_introduction_model.chapter5;

import com.example.spring_boot_introduction_model.chapter5.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController01 {

    @Autowired
    MyDataRepository repository;

    @RequestMapping("/index01")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index01");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("data", list);
        return mav;
    }
}

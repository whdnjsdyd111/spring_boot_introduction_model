package com.example.spring_boot_introduction_model.chapter5;

import com.example.spring_boot_introduction_model.chapter5.MyData;
import com.example.spring_boot_introduction_model.chapter5.repositories.MyDataRepository;
import com.example.spring_boot_introduction_model.chapter5.repositories.MyDataRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class HeloController04 {

    @PostConstruct
    public void init() {
        MyData d1 = new MyData();
        d1.setName("kim");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
        d1.setMemo("this is my data!");
        repository.saveAndFlush(d1);

        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
        d2.setMemo("my girl friend.");
        repository.saveAndFlush(d2);

        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
        d3.setMemo("my work friend.");
        repository.saveAndFlush(d3);
    }

    @Autowired
    MyDataRepository04 repository;

    @RequestMapping(value = "/edit04/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute("formModel") MyData mydata,
                              @PathVariable int id,
                              ModelAndView mav) {
        mav.setViewName("edit04");
        mav.addObject("title", "edit mydata.");
        MyData data = repository.findByid((long) id);
        mav.addObject("formModel", data);
        return mav;
    }

    @RequestMapping(value = "/edit04", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView update(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        repository.saveAndFlush(mydata);
        return new ModelAndView("redirect:/edit04");
    }
}

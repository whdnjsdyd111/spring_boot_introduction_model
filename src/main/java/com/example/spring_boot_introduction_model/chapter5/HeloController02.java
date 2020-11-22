package com.example.spring_boot_introduction_model.chapter5;

import com.example.spring_boot_introduction_model.chapter5.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController02 {

    @Autowired
    MyDataRepository repository;

    @RequestMapping(value = "/index02", method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        mav.setViewName("index02");
        mav.addObject("msg", "this is sample content.");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/index02", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        repository.saveAndFlush(mydata);
        return new ModelAndView("redirect:/index02");
    }
}

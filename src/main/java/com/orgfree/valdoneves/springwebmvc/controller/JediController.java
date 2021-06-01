package com.orgfree.valdoneves.springwebmvc.controller;

import com.orgfree.valdoneves.springwebmvc.model.Jedi;
import com.orgfree.valdoneves.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    //irá em conjunto com o thymeleaf retornar uma resposta dinamica da pagina
    @GetMapping("/jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", repository.getAllJedi());

        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        modelAndView.addObject("jedi", new Jedi());
        return modelAndView;
    }
}

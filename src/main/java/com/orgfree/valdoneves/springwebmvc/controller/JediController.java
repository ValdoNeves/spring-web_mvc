package com.orgfree.valdoneves.springwebmvc.controller;

import com.orgfree.valdoneves.springwebmvc.model.Jedi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JediController {

    //padrão para exibir uma pagina html normal
//    @GetMapping("/jedi")
//    public String jedi(){
//        return "jedi";
//    }

    //irá em conjunto com o thymeleaf retornar uma resposta dinamica da pagina
    @GetMapping("/jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        final Jedi luke = new Jedi("Luke", "Skywlker");
        modelAndView.addObject("allJedi", List.of(luke));

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

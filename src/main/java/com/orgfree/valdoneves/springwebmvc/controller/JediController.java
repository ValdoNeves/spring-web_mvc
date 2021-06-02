package com.orgfree.valdoneves.springwebmvc.controller;

import com.orgfree.valdoneves.springwebmvc.model.Jedi;
import com.orgfree.valdoneves.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "new-jedi";
        }
        repository.add(jedi);
        redirectAttributes.addFlashAttribute("message", "Jedi Cadastrado com Sucesso!");

        //redirect faz parte do Spring mvc
        return "redirect:jedi";
    }

}

package com.project.termsOfReferenceСalculator.controllers;

import com.project.termsOfReferenceСalculator.model.FullExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Controller
public class MainController {

    @Autowired
    private FullExpression fullExpression;

    @GetMapping("/expression")
    public String expression(Model model) {

        model.addAttribute("fullExpression",fullExpression);
        return "expression";
    }

    @GetMapping("/database")
    public String database(Model model) {
        return "database-page";
    }

    @PostMapping("/expression")
    public String result(@RequestParam String expression, Model model) {
        fullExpression.calc(expression);
        model.addAttribute("fullExpression",fullExpression);
        return "expression";
    }
}

package com.project.termsOfReferenceСalculator.controllers;

import com.project.termsOfReferenceСalculator.domain.ExpressionMap;
import com.project.termsOfReferenceСalculator.model.FullExpression;
import com.project.termsOfReferenceСalculator.repos.ExpressionMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private FullExpression fullExpression;

    @Autowired
    private ExpressionMapRepository expressionMapRepository;


    @GetMapping("/expression")
    public String expression(Model model) {

        model.addAttribute("fullExpression", fullExpression);
        return "expression";
    }


    @PostMapping("/expression")
    public String result(@RequestParam String expression, Model model) {
        fullExpression.calc(expression);
        model.addAttribute("fullExpression", fullExpression);

        if (fullExpression.isNormal()) {
            ExpressionMap expressionMap = new ExpressionMap(fullExpression.getInput(), fullExpression.getResult());
            expressionMapRepository.save(expressionMap);
        }

        return "expression";
    }
}

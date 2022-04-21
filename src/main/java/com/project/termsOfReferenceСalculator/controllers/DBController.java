package com.project.termsOfReferenceСalculator.controllers;

import com.project.termsOfReferenceСalculator.domain.ExpressionMap;
import com.project.termsOfReferenceСalculator.repos.ExpressionMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DBController {
    @Autowired
    private ExpressionMapRepository expressionMapRepository;

    @GetMapping("/database")
    public String database(Model model) {
        Iterable<ExpressionMap> expressionMaps = expressionMapRepository.findAll();
        model.addAttribute("expressionMaps", expressionMaps);
        return "database-page";
    }

    @GetMapping("/expression/{id}")
    public String expressionEdit(Model model) {

        return "database-page";
    }
}

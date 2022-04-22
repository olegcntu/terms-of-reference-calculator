package com.project.termsOfReferenceСalculator.controllers;

import com.project.termsOfReferenceСalculator.domain.ExpressionMap;
import com.project.termsOfReferenceСalculator.model.FullExpression;
import com.project.termsOfReferenceСalculator.repos.ExpressionMapRepository;
import com.project.termsOfReferenceСalculator.service.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DBController {
    @Autowired
    private ExpressionMapRepository expressionMapRepository;

    @Autowired
    private FullExpression fullExpression;

    @Autowired
    private Search searchResult;

    @GetMapping("/database")
    public String database(Model model) {
        Iterable<ExpressionMap> expressionMaps = expressionMapRepository.findAll();
        model.addAttribute("expressionMaps", expressionMaps);
        return "database-page";
    }

    @GetMapping("/expression/{id}")
    public String expressionEditInput(@PathVariable("id") int id, Model model) {
        ExpressionMap expressionMap = expressionMapRepository.findById(id).get();

        fullExpression.setInput(expressionMap.getExpression());
        fullExpression.setResult(expressionMap.getResult());
        model.addAttribute("fullExpression", fullExpression);
        model.addAttribute("expressionMap", expressionMap);
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String expressionEdit(@PathVariable("id") int id,
                                 @RequestParam("expression") String expression, Model model) {
        ExpressionMap expressionMap = expressionMapRepository.findById(id).get();
        fullExpression.calc(expression);

        if (fullExpression.isNormal()) {
            expressionMap.setResult(fullExpression.getResult());
            expressionMap.setExpression(fullExpression.getInput());
            expressionMapRepository.save(expressionMap);
        }
        model.addAttribute("expressionMap", expressionMap);
        model.addAttribute("fullExpression", fullExpression);
        return "/edit";
    }

    @PostMapping("/search")
    public String expressionSearch(@RequestParam("search") String search, Model model) {
        //Iterable<ExpressionMap> expressionMaps = expressionMapRepository.findByResult(search);
        //Iterable<ExpressionMap> expressionMaps = expressionMapRepository.findByResultAfter(search);
        //Iterable<ExpressionMap> expressionMaps = expressionMapRepository.findByResultBefore(search);

        Iterable<ExpressionMap> expressionMaps=searchResult.searching(search);
        model.addAttribute("expressionMaps", expressionMaps);

        return "/database-page";
    }

}

package com.project.termsOfReferenceСalculator.service;

import com.project.termsOfReferenceСalculator.domain.ExpressionMap;
import com.project.termsOfReferenceСalculator.repos.ExpressionMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Search {
    @Autowired
    private ExpressionMapRepository expressionMapRepository;

    public Iterable<ExpressionMap> searching(String search) {
        Iterable<ExpressionMap> expressionMaps;
        char sign = search.charAt(0);

        switch (sign) {
            case '>' -> {
                return expressionMapRepository.findByResultAfter(search);
            }
            case '<' -> {
                return expressionMapRepository.findByResultBefore(search);
            }
        }
        return expressionMapRepository.findByResult(search);
    }
}
package com.project.termsOfReferenceŠ”alculator.service;

import com.project.termsOfReferenceŠ”alculator.domain.ExpressionMap;
import com.project.termsOfReferenceŠ”alculator.repos.ExpressionMapRepository;
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
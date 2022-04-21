package com.project.termsOfReferenceСalculator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExpressionMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String expression;

    private String result;

    public ExpressionMap() {
    }

    public Integer getId() {
        return id;
    }

    public ExpressionMap(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }

}

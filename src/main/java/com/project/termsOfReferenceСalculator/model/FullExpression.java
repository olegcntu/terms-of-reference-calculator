package com.project.termsOfReferenceСalculator.model;

import com.project.termsOfReferenceСalculator.service.CalculationNotes;
import com.project.termsOfReferenceСalculator.service.ReversePolishNotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FullExpression {

    private String input;
    private String result = "0";
    private boolean normal;


    private ReversePolishNotation reversePolishNotation;
    private CalculationNotes calculationNotes;

    @Autowired
    public void setReversePolishNotation(ReversePolishNotation reversePolishNotation) {
        this.reversePolishNotation = reversePolishNotation;
    }

    @Autowired
    public void setCalculationNotes(CalculationNotes calculationNotes) {
        this.calculationNotes = calculationNotes;
    }


    public void calc(String inputEx) {
        this.input = inputEx;
        if (input.isEmpty()) {
            this.normal = false;
            this.result = "";
            return;
        }

        List<String> expression = reversePolishNotation.parse(inputEx);
        if (!ReversePolishNotation.flag) {
            this.result = expression.get(0);
            return;
        }
        this.result = calculationNotes.calc(expression);
        this.normal = ReversePolishNotation.flag;
    }

    public String getInput() {
        return input;
    }

    public boolean isNormal() {
        return normal;
    }

    public String getResult() {
        return result;
    }
}

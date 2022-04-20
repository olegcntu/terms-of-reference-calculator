package com.project.termsOfReferenceСalculator.model;

import com.project.termsOfReferenceСalculator.service.CalculationNotes;
import com.project.termsOfReferenceСalculator.service.ReversePolishNotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FullExpression {

    public String result = "0";

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

        List<String> expression = reversePolishNotation.parse(inputEx);
        if (!ReversePolishNotation.flag) {
            this.result = expression.get(0);
            return;
        }
        this.result = calculationNotes.calc(expression);

    }

    public String getResult() {
        return result;
    }
}

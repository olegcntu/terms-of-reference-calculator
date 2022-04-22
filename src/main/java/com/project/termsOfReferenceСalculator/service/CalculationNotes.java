package com.project.termsOfReferenceСalculator.service;

import com.project.termsOfReferenceСalculator.model.FullExpression;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

@Component
public class CalculationNotes {

    private static boolean flagCalculator=true;

    public static boolean isFlagCalculator() {
        return flagCalculator;
    }

    public String calc(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();
        try {
            for (String x : postfix) {
                switch (x) {
                    case "+" -> stack.push(stack.pop() + stack.pop());
                    case "-" -> {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(a - b);
                    }
                    case "*" -> stack.push(stack.pop() * stack.pop());
                    case "/" -> {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(a / b);
                    }
                    case "u-" -> stack.push(-stack.pop());
                    default -> stack.push(Double.valueOf(x));
                }
            }
        } catch (Exception e) {
            this.flagCalculator=false;
            return "incorrect expression";
        }


        return stack.pop().toString();
    }


}

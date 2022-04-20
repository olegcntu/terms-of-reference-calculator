package com.project.termsOfReferenceСalculator.service;

import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

@Component
public class CalculationNotes {
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
        }catch (Exception e){
            return "incorrect expression";
        }
        if(stack.isEmpty()){return "";}

        return stack.pop().toString();
    }


}

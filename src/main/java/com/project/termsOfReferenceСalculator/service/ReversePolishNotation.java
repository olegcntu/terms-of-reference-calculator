package com.project.termsOfReferenceСalculator.service;
import org.springframework.stereotype.Component;
import java.util.*;



@Component
public class ReversePolishNotation {
    private static String operators = "+-*/";
    private static String delimiters = "() " + operators;
    public static boolean flag = true;

    public ReversePolishNotation() {
    }

    private  boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }



    private  int priority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public  List<String> parse(String infix) {
        List<String> postfix = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();//знаки
        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
        String prev = "";
        String curr = "";
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                postfix.add(0,"incorrect expression.");
                flag = false;
                return postfix;
            }
            if (curr.equals(" ")) continue;
             if (isDelimiter(curr)) {
                if (curr.equals("(")) stack.push(curr);
                else if (curr.equals(")")) {
                    try {
                        while (!stack.peek().equals("(")) {
                            postfix.add(stack.pop());

                        }
                    }catch (Exception e){
                        postfix.add(0,"parentheses are not comparable ");
                        flag = false;
                        return postfix;
                    }

                    stack.pop();

                } else {
                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev) && !prev.equals(")")))) {
                        curr = "u-";
                    } else {
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                            postfix.add(stack.pop());
                        }

                    }
                    stack.push(curr);
                }

            } else {
                postfix.add(curr);
            }
            prev = curr;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) postfix.add(stack.pop());
            else {
                postfix.add(0,"incorrect expression");
                flag = false;
                return postfix;
            }
        }
        return postfix;
    }
}

package com.example.simplecalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // ArrayList to store the numbers and symbols
    private List<String> calculatorList = new ArrayList<>();

    // Output variable
    private String output = "";

    // Default Constructor
    public Calculator() {}

    // push Method to add strings to the list
    public void push(String input) {
        calculatorList.add(input);
    }

    // calculate Method to calculate the resulting output
    public String calculate() {
        boolean valid_flag = true;
        int calculateOutput = 0;
        for(int i = 0; i < calculatorList.size() && calculatorList.size() >= 3 && valid_flag; i++) {

            // If the i is at the 0 index then set calculateOutput to the 0 index of list
            if(i == 0) {
                try {
                    calculateOutput = Integer.parseInt(calculatorList.get(i));
                }
                catch (NumberFormatException e){
                    valid_flag = false;
                }
            }

            // If i is greater or equal to 2 and the modulus of i%2 is 0 then we have correct input
            if ((i >= 2) && (i%2 == 0)) {
                // Check if the middle string between numbers is a valid symbol
                if (symbolCheck(calculatorList.get(i - 1))) {
                    try {
                        calculateOutput = calculation(calculateOutput, Integer.parseInt(calculatorList.get(i)), calculatorList.get(i - 1));
                    }
                    catch (NumberFormatException e) {
                        valid_flag = false;
                    }
                }
                else {
                    valid_flag = false;
                }
            }
        }

        if(valid_flag != true) {
            output = "failed";
        }
        else {
            output = Integer.toString(calculateOutput);
        }
        return output;
    }

    // calculation Method to calculate 2 numbers
    private int calculation(int first, int second, String symbol) {
        int currentOutput = 0;
        switch (symbol) {
            case "+":
                currentOutput = first + second;
                break;
            case "*":
                currentOutput = first * second;
                break;
            case "-":
                currentOutput = first - second;
                break;
            case "/":
                currentOutput = first / second;
                break;
            default:
                break;
        }
        return currentOutput;
    }

    private boolean symbolCheck(String symbol) {
        return (symbol == "+" || symbol == "-" || symbol == "*" || symbol == "/");
    }

    // clear Method to clean the arrayList for next calculation
    public void clear() {
        calculatorList.clear();
    }
}

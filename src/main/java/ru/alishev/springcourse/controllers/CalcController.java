package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class CalcController {

    @GetMapping("/calculator")
    public String calc(@RequestParam("a") int a,
                       @RequestParam("b") int b,
                       @RequestParam("operation") String operation,
                       Model model) {

        model.addAttribute("message", calculate(operation, a, b));
        return "calculator/calculator";
    }

    private String calculate(String operation, int a, int b) {
        switch (operation.toLowerCase(Locale.ROOT)) {
            case "multiplication": return "A * B = " + (a*b);
            case "addition": return "A + B = " + (a+b);
            case "subtraction": return "A - B = " + (a-b);
            case "division": return "A / B = " + (a/b);
            default: return "Unsupported operation.";
        }
    }
}

package com.uel.br;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calcular")
    public String calcular(@RequestParam int value1, @RequestParam int value2,
            @RequestParam int operation, Model model) {
            if(operation == 1)
                model.addAttribute("result", value1 + value2);
            if(operation == 2)
                model.addAttribute("result", value1 - value2);
            if(operation == 3)
                model.addAttribute("result", value1 * value2);
            if(operation == 4)
                model.addAttribute("result", value1 / value2);

        return "result";
    }

}
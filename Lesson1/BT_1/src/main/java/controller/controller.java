package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class controller {
    @PostMapping(value = "/exchange")
    public String MoneyExchanger(@RequestParam float usd, Model model) {
        model.addAttribute("usd", usd*23000);
        return "home";

    }

    @GetMapping(value = "/exchange")
    public String Money() {
        return "home";
    }
}



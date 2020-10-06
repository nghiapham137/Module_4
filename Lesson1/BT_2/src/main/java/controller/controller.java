package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
    @GetMapping(value = "/translate")
    public String translateGet() {
        return "index";
    }

    @PostMapping(value = "/translate")
    public String translatePost(@RequestParam("word") String input, Model model) {
        model.addAttribute("word",input);
        switch (input) {
            case "Hello":
                model.addAttribute("output","Xin chào");
                break;
            case "Goodbye":
                model.addAttribute("output","Tạm biệt");
                break;
            default:
                model.addAttribute("output", "Tôi không biết, hỏi người khác đi");
                break;
        }
        return "index";
    }
}

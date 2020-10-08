package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Model.EmailConfiguration;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    @RequestMapping(value = "/showform", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("emailConfig", new EmailConfiguration());

        List<String> listLanguage = new ArrayList<>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        model.addAttribute("listLanguage", listLanguage);

        List<Integer> listPageSize = new ArrayList<>();
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
        model.addAttribute("listPageSize", listPageSize);
        return "create";
    }

    @RequestMapping(value = "/addconfig", method = RequestMethod.POST)
    public String addConfig(@ModelAttribute("emailConfig") EmailConfiguration emailConfig, ModelMap model) {
        model.addAttribute("emailConfig", emailConfig);
        return "view";
    }
}

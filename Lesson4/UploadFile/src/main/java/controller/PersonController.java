package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import Model.PersonForm;
import Model.Person;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class PersonController {
    @Autowired
    private Environment environment;


    @GetMapping("/person")
    public String showForm(Model model) {
        model.addAttribute("person", new PersonForm());
        return "create";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") PersonForm personForm, Model model) {
        Person person = new Person(personForm.getId(), personForm.getName());
        String fileUpload = environment.getProperty("file_upload");
        MultipartFile file = personForm.getImage();
        String image = file.getOriginalFilename();
        person.setImage(image);
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        }catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("person", person);
        return "result";
    }

}

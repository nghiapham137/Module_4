package controller;
import Model.Student;
import Service.StudentService;
import Service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students",studentList);
        return "/index";
    }

    @GetMapping("/student/create")
    public String create(Model model) {
        model.addAttribute("student",new Student());
        return "/create";
    }

    @PostMapping("/student/save")
    public String save(Student student, RedirectAttributes redirect) {
        student.setId((int)(Math.random() * 10000));
        studentService.save(student);
        redirect.addFlashAttribute("success", "Saved student successfully");
        return "redirect:/";
    }

    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/edit";
    }

    @PostMapping("/student/update")
    public String update(Student student, RedirectAttributes redirect) {
        studentService.update(student.getId(), student);
        redirect.addFlashAttribute("success", "Modified student successfully!");
        return "redirect:/";
    }

    @GetMapping("/student/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/delete";
    }

    @PostMapping("/student/delete")
    public String delete(Student customer, RedirectAttributes redirect) {
        studentService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/student/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "/view";
    }
}

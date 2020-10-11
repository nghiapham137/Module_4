package Controller;
import com.sun.org.apache.xpath.internal.operations.Mod;
import Service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import Model.Student;
import Model.StudentForm;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private Environment environment;

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public String home(Model model) {
        Iterable<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/create")
    public String showAddForm(Model model) {
        model.addAttribute("student", new StudentForm());
        return "create";
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute("student") StudentForm studentForm) {
        Student student = new Student(studentForm.getId(), studentForm.getName());
        String fileUpload = environment.getProperty("file_upload");
        MultipartFile file = studentForm.getImage();
        String image = file.getOriginalFilename();
        student.setImage(image);
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentService.save(student);
//        model.addAttribute("student", student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String showAddForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Student student = studentService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Student " + student.getName() + " is deleted");
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateStudent(Student student, Model model) {
        studentService.save(student);
        Iterable<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "redirect:/students";
    }
}

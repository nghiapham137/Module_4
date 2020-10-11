package Controller;
import com.sun.org.apache.xpath.internal.operations.Mod;
import Service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Model.Student;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/students")
public class StudentController {
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
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String saveStudent(Student student) {
        studentService.save(student);
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

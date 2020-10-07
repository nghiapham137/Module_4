package Service;

import Model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<Integer, Student> students;
    static {
        students = new HashMap<>();
        students.put(1, new Student(1, "John", "john@codegym.vn", "Hanoi"));
        students.put(2, new Student(2, "Bill", "bill@codegym.vn", "Danang"));
        students.put(3, new Student(3, "Alex", "alex@codegym.vn", "Saigon"));
        students.put(4, new Student(4, "Adam", "adam@codegym.vn", "Beijin"));
        students.put(5, new Student(5, "Sophia", "sophia@codegym.vn", "Miami"));
        students.put(6, new Student(6, "Rose", "rose@codegym.vn", "Newyork"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id, student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}

package Model;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private int id;
    private String name;
    private MultipartFile image;

    public StudentForm() {
    }

    public StudentForm(int id, String name, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}

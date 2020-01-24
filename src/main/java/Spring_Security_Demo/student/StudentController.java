package Spring_Security_Demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Emin Alizade"),
            new Student(2, "Fatima Nasibova"),
            new Student(3, "Ayyub Najafzade"),
            new Student(4, "Fatima Karimli"),
            new Student(5, "Rauf Rafizade"),
            new Student(6, "Vagif Guliyev")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("The Given ID: " + studentId + " Not Found"));
    }

}

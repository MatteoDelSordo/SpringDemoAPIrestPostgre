package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
//Io seguo il video eh, ma tutto dentro lo stesso package mi fa venire un coccolone, altro che perdita di capelli

private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

@GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudent();
}





}

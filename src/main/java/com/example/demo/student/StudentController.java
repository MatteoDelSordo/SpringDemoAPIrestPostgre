package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/prova")
    public List<Student> getStudents(Model model) {
        List<Student> students = studentService.getStudent();
        model.addAttribute("students", students);
        return students;
    }

    @PostMapping(path = ("/aggiungi"))
    public void registerNewStudent(@RequestBody Student s) {
        studentService.addStudent(s);
    }

    @DeleteMapping(path = ("/elimina/{id}"))
    public void deleteStudentByButton(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/modifica/{id}")
    public void updateStudentById(@PathVariable Long id,
                                  @RequestBody Student s) {
        studentService.updateStudentById(id, s);
    }


}

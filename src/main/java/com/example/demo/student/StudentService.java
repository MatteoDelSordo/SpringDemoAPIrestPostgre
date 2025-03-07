package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudent() {
        return studentRepository.findAll();
    }


    public void addStudent(Student s) {
        studentRepository.save(s);
    }


    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public void updateStudentById(Long id,
                                  Student s) {
/*        Questa cosa qui me l'ha suggerita chatgpt, sinceramente non ho capito per quale motivo senza
          lanciare l'eccezione intellij strilla fortissimo che pippo deve essere ti tipo optional mentre se uso questa
          cosa qui gli sta bene dato che non mi suggeriva un try chatch o di aggiungere un thorws nella dichiarazione
          del metodo,non so se mi sono spiegato.
          Fatto sta che cosi > Student pippo = studentRepository..findById(id) dava errore, se possibile lunedi
          vorrei aiuto nel capirlo. */
        Student pippo = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Studente non trovato"));
        ;
        // Student pippo = studentRepository.findById(id);

        pippo.setDob(s.getDob());
        pippo.setName(s.getName());
        pippo.setEmail(s.getEmail());
        studentRepository.delete(pippo);
        studentRepository.save(s);
    }


}

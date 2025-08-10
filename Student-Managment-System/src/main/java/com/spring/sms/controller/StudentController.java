package com.spring.sms.controller;

import com.spring.sms.entity.Student;
import com.spring.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Show all students and the form in one page
    @GetMapping
    public String showStudentsPage(Model model) {
        model.addAttribute("students", studentService.getAllStudents());  
        model.addAttribute("student", new Student());                      
        return "create_student";                                           
    }

    //  Save new student
    @PostMapping
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);              
        return "redirect:/students";                      
    }

    //  Load edit form with existing data
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));    
        model.addAttribute("students", studentService.getAllStudents());     
        return "create_student";                                             
    }

    //  Delete a student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}

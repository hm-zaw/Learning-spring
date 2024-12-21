package com.hmz.spring_jpa.Student;

import com.hmz.spring_jpa.School.SchoolRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    private final SchoolRepository schoolRepository;

    public StudentController(StudentRepository studentRepository, SchoolRepository schoolRepository, StudentMapper studentMapper, StudentService studentService) {
        this.schoolRepository = schoolRepository;
        this.studentService = studentService;
    }


    @PostMapping("/post")
    public StudentResponseDto post(
          @Valid @RequestBody StudentDto dto
    ){
        return this.studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student_id}")
    public StudentResponseDto findStudentById(
        @PathVariable("student_id") Integer id
    ){
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student_name}")
    public List<StudentResponseDto> findStudentByName(
        @PathVariable("student_name") String name
    ){
        return studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Integer id){
        studentService.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // For displaying the detail exception to end user
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMsg = error.getDefaultMessage();
                    errors.put(fieldName, errorMsg);
                }) ;
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}

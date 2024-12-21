package com.hmz.spring_jpa.School;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolMapper schoolMapper;
    private final SchoolService schoolService;

    public SchoolController(SchoolMapper schoolMapper, SchoolService schoolService) {
        this.schoolMapper = schoolMapper;
        this.schoolService = schoolService;
    }

    @PostMapping("/schoolPost")
    public SchoolDto postSchool(@RequestBody SchoolDto dto){
        return schoolService.postSchool(dto);
    }


    @GetMapping("/schools")
    public List<SchoolDto> getAllSchools(){
        return schoolService.getAllSchools();
    }

    @GetMapping("/schools/{school-id}")
    public School findSchoolById(
            @PathVariable("school-id") Integer id
    ){
        return schoolService.findSchoolById(id);
    }
}

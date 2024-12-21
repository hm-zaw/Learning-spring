package com.hmz.spring_jpa.School;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto postSchool(@RequestBody SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        var savedSch = schoolRepository.save(school);
        return schoolMapper.toSchoolDto(savedSch);
    }

    public List<SchoolDto> getAllSchools(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public School findSchoolById(Integer id){
        return schoolRepository.findById(id)
                .orElse(new School());
    }
}

package com.biswarup.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biswarup.model.Student;
import com.biswarup.service.CacheService;

@RestController
@RequestMapping("/student-info")
public class CacheResourceController {

  private final CacheService cacheService;

  public CacheResourceController(CacheService cacheService) {
    super();
    this.cacheService = cacheService;
  }

  @GetMapping("/{studentId}")
  public ResponseEntity<Student> getStudent(@PathVariable("studentId") String studentId) {

    Optional<Student> student = cacheService.getStudent(studentId);
    if (student.isPresent()) {
      return new ResponseEntity<>(student.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


  }

}

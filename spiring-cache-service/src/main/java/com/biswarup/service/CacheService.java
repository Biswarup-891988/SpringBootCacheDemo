package com.biswarup.service;

import java.util.Arrays;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import com.biswarup.model.Major;
import com.biswarup.model.Student;

public class CacheService {

  @Cacheable(value = "studentCache", key = "'studentCache'+#studentId")
  public Optional<Student> getStudent(String studentId) {
    try {
      Thread.sleep(8000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return Arrays
        .asList(new Student("101", "Amit", Major.Biology), new Student("102", "Suraj", Major.Math))
        .stream().filter(t -> t.getId().equalsIgnoreCase(studentId)).findFirst();

  }

}

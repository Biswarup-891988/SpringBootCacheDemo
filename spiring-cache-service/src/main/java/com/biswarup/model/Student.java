package com.biswarup.model;

public class Student {
  
  private String id;
  private String name;
  private Major major;
  
  public Student(String id, String name, Major major) {
    super();
    this.id = id;
    this.name = name;
    this.major = major;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Major getMajor() {
    return major;
  }
  public void setMajor(Major major) {
    this.major = major;
  }
  
  

}

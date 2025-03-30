package com.astraspecs.restful;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name= "T_Student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name= "c_fname",
            length = 255
    )
    private String firstname;

    private String lastname;

    @Column(
            unique = true
    )
    private String email;

    private int age;


    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )

    @JsonBackReference // the child ( student ) does not need to serialize tha parent ( school)
    private School school;

    public Student() {
    }

    public Student(int age, String email, String lastname, String firstname) {
        this.age = age;
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

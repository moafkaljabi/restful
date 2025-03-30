package com.astraspecs.restful;


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

package com.example.spring_boot_introduction_model.chapter5;

import javax.persistence.*;

@Entity
@Table(name = "mydata")
public class MyData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200, nullable = true)
    private String mail;

    @Column(nullable = true)
    private Integer age;

    @Column(nullable = true)
    private String memo;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public Integer getAge() {
        return age;
    }

    public String getMemo() {
        return memo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
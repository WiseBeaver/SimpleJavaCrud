package org.alex.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    private long id;
    @Min(value = 18,message = "age must be over 18")
    private int age;
    @NotEmpty(message = "name must not be empty")
    @Size(min = 2,max = 30,message = "name length must be between 2 and 30")
    private String name;

    public User() {
    }

    public User(long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
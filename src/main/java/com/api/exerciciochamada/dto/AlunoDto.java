package com.api.exerciciochamada.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AlunoDto {
    private Integer id;
    @NotBlank
    private String name;
    @Min(value = 1,message = "A idade deve ser maior que 0")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge( Integer age ) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AlunoDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

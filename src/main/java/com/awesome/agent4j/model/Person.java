package com.awesome.agent4j.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "人物信息实体")
public class Person {
    @Schema(description = "姓名")
    private String name;
    
    @Schema(description = "年龄")
    private Integer age;
    
    @Schema(description = "职业")
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}

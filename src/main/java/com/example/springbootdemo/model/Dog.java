package com.example.springbootdemo.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dog {
    private String name;
    private String breed;
    private Gender gender;
    private int age;
    private Long id;
}

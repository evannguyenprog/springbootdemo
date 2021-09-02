package com.example.springbootdemo.entity;

import com.example.springbootdemo.model.Gender;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dog")
public class DogEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private Gender gender;
    private int age;
}

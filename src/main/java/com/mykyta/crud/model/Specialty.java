package com.mykyta.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private Integer id;
    @Column(name = "name")
    private String specialtyName;

    public Specialty(Integer id, String specialtyName) {
        this.id = id;
        this.specialtyName = specialtyName;
    }

    public Specialty() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specialtyName='" + specialtyName + '\'' +
                '}';
    }
}

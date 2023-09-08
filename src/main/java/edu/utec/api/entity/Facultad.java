package edu.utec.api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "facultad")
public class Facultad {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String nombre;
    private List<String> cursos_id;
    private List<Long> estudiantes_id;

    public Facultad() {}
}
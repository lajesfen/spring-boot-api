package edu.utec.api.entity.user;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String facultad_id;
    private List<String> cursos;

    public Alumno() {}
}
package edu.utec.api.entity.system;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String nombre;
    private Long profesor_id;
    private Number max_alumnos;
    private List<Long> lista_alumnos;

    public Curso() {}
}
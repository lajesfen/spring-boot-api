# API

## Restricciones
1. Solo hay un Profesor por curso.
2. Las diferentes secciones están definidas como un curso.
3. Cada curso pertenece a una facultad.

## Ejemplos

### GET `/facultades/`
```json
{
    "id": "FC1",
    "nombre": "Facultad 1",
    "cursos_id": [
        "CS2031",
        "CS2032",
        "CS2033"
    ],
    "estudiantes_id": [
        "20220401",
        "20220404"
    ]
}
```

### GET `/cursos/`
```json
{
    "id": "CS2031",
    "nombre": "Programación - 1.01",
    "profesor_id": "50031", //No implementado (Modelo similar a Alumno)
    "max_alumnos": 20,
    "lista_alumnos": [
        "202220401",
        "202220402",
        "202220403",
        "202220404"
    ]
}
```

### GET `/alumnos/`
```json
{
    "id": "202220439",
    "nombre": "Nombre de Alumno",
    "facultad_id": "FC1",
    "cursos": [
        "CS2031", 
        "CS2032",
        "CS2033"
    ]
}
```

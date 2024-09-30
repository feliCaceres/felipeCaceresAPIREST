package com.example.inicial1.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Audited
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Libro extends Base{

    private int fecha;
    private String genero;
    private int paginas;
    private String titulo;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}

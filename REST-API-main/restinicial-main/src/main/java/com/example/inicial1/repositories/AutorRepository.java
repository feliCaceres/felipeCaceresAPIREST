package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AutorRepository extends BaseRepository<Autor,Long> {

    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //boolean existsByDni(int dni);

    @Query(value= "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro%" )
    Page<Autor> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value= "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro%" )
    List<Autor> search(@Param("filtro") String filtro);

    @Query(
            value= "SELECT * FROM autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro% ",
            nativeQuery = true,
            countQuery = "SELECT count(*) FROM autor"
    )
    Page<Autor> searchNativo2(@Param("filtro") String filtro,Pageable pageable);

    @Query(
            value= "SELECT * FROM autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Autor> searchNativo(@Param("filtro") String filtro);
}

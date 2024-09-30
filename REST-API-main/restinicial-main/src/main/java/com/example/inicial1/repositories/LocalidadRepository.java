package com.example.inicial1.repositories;

import com.example.inicial1.entities.Localidad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LocalidadRepository extends BaseRepository<Localidad,Long>{
    List<Localidad> findByDenominacionContaining(String denominacion);
    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    //boolean existsByDni(int dni);

    @Query(value= "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%" )
    Page<Localidad> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value= "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%" )
    List<Localidad> search(@Param("filtro") String filtro);

    @Query(
            value= "SELECT * FROM Localidad WHERE Localidad.denominacion LIKE %:filtro%",
            nativeQuery = true,
            countQuery = "SELECT count(*) FROM Localidad"
    )
    Page<Localidad> searchNativo2(@Param("filtro") String filtro,Pageable pageable);

    @Query(
            value= "SELECT * FROM Localidad WHERE Localidad.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Localidad> searchNativo(@Param("filtro") String filtro);
}

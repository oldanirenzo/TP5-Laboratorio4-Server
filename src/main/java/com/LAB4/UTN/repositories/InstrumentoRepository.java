package com.LAB4.UTN.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LAB4.UTN.entities.Instrumento;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer>{

}

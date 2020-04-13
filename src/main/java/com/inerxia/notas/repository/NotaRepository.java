package com.inerxia.notas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inerxia.notas.model.Nota;

@Repository("repo")
public interface NotaRepository extends JpaRepository<Nota, Long>{
	
	   Optional<Nota> findByNombreAndTitulo(String nombre, String titulo);
	
		

}

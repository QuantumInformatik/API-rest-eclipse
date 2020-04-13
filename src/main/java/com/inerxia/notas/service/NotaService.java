package com.inerxia.notas.service;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inerxia.notas.exception.DataDuplicatedException;
import com.inerxia.notas.model.Nota;
import com.inerxia.notas.repository.NotaRepository;

@Service("notaService")
@Transactional
public class NotaService {
	
	@Autowired
	private NotaRepository repo;
	
	private static final Logger LOG = Logger.getLogger(NotaService.class.getName());

	public NotaService(NotaRepository repo) {
		this.repo = repo;
	}

	public Nota crearNota(Nota nota) {
		LOG.info("CREANDO NOTA");
		if (Objects.nonNull(nota.getId())) {
			Optional<Nota> notaOptional = repo.findById(nota.getId());
			if (notaOptional.isPresent()) {
				LOG.log(Level.WARNING, "EXCEPCION: REGISTRO DUPLICADO");
				throw new DataDuplicatedException("exception.data_duplicated.nota.id");
			}
		}
		Optional<Nota> notaOptionalNombreTitulo = repo.findByNombreAndTitulo(nota.getNombre(), nota.getTitulo());
		if (notaOptionalNombreTitulo.isPresent()) {
			throw new DataDuplicatedException("exception.data_duplicated.nota.titulo");
		}
		LOG.info("Nota ingresa con exito");
		return repo.save(nota);
	}

}

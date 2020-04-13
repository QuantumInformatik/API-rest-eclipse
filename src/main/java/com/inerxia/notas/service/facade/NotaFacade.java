package com.inerxia.notas.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inerxia.notas.dto.NotaDto;
import com.inerxia.notas.mapper.NotaMapper;
import com.inerxia.notas.service.NotaService;

@Service
@Transactional
public class NotaFacade {
	
	@Autowired
	private NotaMapper notaMapper;
	
	@Autowired
	private NotaService notaService;

	public NotaFacade(NotaMapper notaMapper, NotaService notaService) {
		this.notaMapper = notaMapper;
		this.notaService = notaService;
	}

	public NotaDto crearNota(NotaDto nota) {
		return notaMapper.toDto(notaService.crearNota(notaMapper.toEntity(nota)));
	}

}

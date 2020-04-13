package com.inerxia.notas.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inerxia.notas.dto.NotaDto;
import com.inerxia.notas.service.facade.NotaFacade;
import com.inerxia.notas.util.handler.StandardResponse;

@RestController
@RequestMapping("/api")
public class NotaController {

	private NotaFacade facade;
	private static final Logger LOG = Logger.getLogger(NotaController.class.getName());

	public NotaController(NotaFacade facade) {
		this.facade = facade;
	}

    @PostMapping(value ="/v1/nota")
	public ResponseEntity<StandardResponse<NotaDto>> crearNota(@Valid @RequestBody NotaDto notaDto) {
    	LOG.info("Iniciado la creacion de nota");
		NotaDto notaDto1 = facade.crearNota(notaDto);
		return ResponseEntity.ok(
				new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, "nota.crear.exito", notaDto1));
	}

}

package com.inerxia.notas.mapper;

import org.mapstruct.Mapper;
import com.inerxia.notas.dto.NotaDto;
import com.inerxia.notas.model.Nota;

@Mapper(componentModel = "spring")
public interface NotaMapper  extends EntityMapper<NotaDto, Nota> {

}

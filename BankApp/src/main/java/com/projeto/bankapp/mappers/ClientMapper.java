package com.projeto.bankapp.mappers;


import com.projeto.bankapp.entities.Cliententity;
import com.projeto.bankapp.models.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    void createClient(@MappingTarget Cliententity client, ClientDTO clientDTO);

    Cliententity clientDTOtoclient(ClientDTO clientDTO);
    ClientDTO clienttoclientDTO(Cliententity client);

}

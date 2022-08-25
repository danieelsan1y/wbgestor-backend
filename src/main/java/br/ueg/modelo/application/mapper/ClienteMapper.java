package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.ClienteCriarDTO;
import br.ueg.modelo.application.dto.ClienteListarDTO;
import br.ueg.modelo.application.model.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {
    private static  final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ClienteCriarDTO toCLienteCriarDTO(Cliente cliente) {
        return MODEL_MAPPER.map(cliente, ClienteCriarDTO.class);
    }

    public ClienteListarDTO toCLienteListarDTO(Cliente cliente) {
        return MODEL_MAPPER.map(cliente, ClienteListarDTO.class);
    }

    public Cliente clienteCriarDTOToCliente(ClienteCriarDTO clienteCriarDTO) {
        return  MODEL_MAPPER.map(clienteCriarDTO,Cliente.class);
    }

    public List<ClienteListarDTO> toClienteListarDTOList(List<Cliente> clientes) {
        List<ClienteListarDTO> clienteListarDTOS = clientes.stream().map(cliente -> toCLienteListarDTO(cliente)).collect(Collectors.toList());
        return clienteListarDTOS;
    }
}

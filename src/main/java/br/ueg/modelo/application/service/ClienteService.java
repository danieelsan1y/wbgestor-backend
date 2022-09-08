package br.ueg.modelo.application.service;

import br.ueg.modelo.application.enums.StatusCliente;
import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.Cliente;
import br.ueg.modelo.application.repository.ClienteRepository;
import br.ueg.modelo.comum.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void criar (Cliente cliente) {
        validarIdade(cliente.getDataDeNacimento());
        cliente.setStatusCliente(StatusCliente.ATIVO);
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }


    public Cliente buscarPorId(Long id) {
        return clienteRepository.buscarPorId(id);
    }

    public void atualizar(Long id, Cliente cliente) {
        Cliente clienteAntigo = clienteRepository.buscarPorId(id);
        alterarCampos(clienteAntigo,cliente);
        clienteRepository.save(clienteAntigo);
    }

    private void alterarCampos(Cliente clienteAntigo, Cliente cliente) {
        clienteAntigo.setNome(cliente.getNome());
        clienteAntigo.setStatusCliente(cliente.getStatusCliente());
        clienteAntigo.setCpf(cliente.getCpf());
        clienteAntigo.setDataDeNacimento(cliente.getDataDeNacimento());
        clienteAntigo.setEndereco(cliente.getEndereco());
        clienteAntigo.setTelefone(cliente.getTelefone());
        clienteAntigo.setCr(cliente.getCr());
    }

    public void desativar(Long id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        cliente.setStatusCliente(StatusCliente.INATIVO);
        clienteRepository.save(cliente);
    }

    public void ativar(Long id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        cliente.setStatusCliente(StatusCliente.ATIVO);
        clienteRepository.save(cliente);
    }

    private void retirarMascaraCpf(Cliente cliente) {

        String cpfnovo = cliente.getCpf();
        cpfnovo = cpfnovo.replaceAll("\\.", "");
        cpfnovo = cpfnovo.replaceAll("-", "");
        cliente.setCpf(cpfnovo);

    }

    private void colocarMascaraCpf(Cliente cliente) {

        StringBuilder cpfnovo = new StringBuilder(cliente.getCpf());
        cpfnovo = cpfnovo.insert(3, ".");
        cpfnovo = cpfnovo.insert(7, ".");
        cpfnovo = cpfnovo.insert(11, "-");

        cliente.setCpf(cpfnovo.toString());

    }

    private void retirarMascaraTelefone(Cliente cliente) {

        String telNovo = cliente.getTelefone();

        telNovo = telNovo.replaceAll("\\(", "");
        telNovo = telNovo.replaceAll("\\)", "");
        telNovo = telNovo.replaceAll("-", "");
        cliente.setTelefone(telNovo);

    }

    private void colocarMascaraTelefone(Cliente cliente) {

        StringBuilder telNovo = new StringBuilder(cliente.getTelefone());
        telNovo = telNovo.insert(0, "(");
        telNovo = telNovo.insert(3, ")");
        telNovo = telNovo.insert(9, "-");
        cliente.setTelefone(telNovo.toString());
    }


    private Integer validarIdade(LocalDate date) {
        int idade =0;
        if (!(date.equals(null))) {
            final LocalDate dataAtual = LocalDate.now();
            final Period periodo = Period.between(date, dataAtual);
            idade= periodo.getYears();
        }
        if(idade<18) {
            throw new BusinessException(SistemaMessageCode.ERRO_IDADE_NAO_PERMITIDA);
        }
        return null;
    }
}

package br.ueg.modelo.application.service;

import br.ueg.modelo.application.enums.StatusArma;
import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.Arma;
import br.ueg.modelo.application.model.Cliente;
import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.application.model.Usuario;
import br.ueg.modelo.application.repository.ArmaRepository;
import br.ueg.modelo.application.repository.ClienteRepository;
import br.ueg.modelo.application.repository.ModeloArmaRepository;
import br.ueg.modelo.application.service.validate.ArmaValidate;
import br.ueg.modelo.application.service.validate.ClienteValidate;
import br.ueg.modelo.comum.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArmaService {

    @Autowired
    ArmaRepository armaRepository;

    @Autowired
    ModeloArmaRepository modeloArmaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void realizarEntrada(Arma arma, Long id) {
        ArmaValidate.validarEntradaValoresNulos(arma,id);
        ArmaValidate.validarEntradaValoresBrancos(arma);

        verificarSerieExistente(arma.getSerie());

        ModeloArma modeloArma = VerificarModeloNaoExistente(id);
        arma.setCor(arma.getCor().toUpperCase());
        arma.setSerie(arma.getSerie().toUpperCase());
        arma.setModeloArma(modeloArma);
        arma.setDataEntrada(LocalDate.now());
        arma.setStatus(StatusArma.DISPONIVEL);
        armaRepository.save(arma);
    }

    public void trafegar(Long id, StatusArma statusArma, Long idCliente) {
        Arma armaAntiga = armaRepository.buscarPorId(id);
        ArmaValidate.validarStatusArma(statusArma);

        armaAntiga.setStatus(statusArma);
        Cliente cliente = verificarSeClienteEstaCadastrado(idCliente);
        armaAntiga.setCliente(cliente);
        armaRepository.save(armaAntiga);
    }

    public void realizarSaida(Long id) {
        Arma arma = armaRepository.buscarPorId(id);
        arma.setStatus(StatusArma.VENDIDO_E_RETIRADO);
        arma.setDataSaida(LocalDate.now());
        armaRepository.save(arma);
    }

    public void atualizar(Arma arma, Long idArma, Long idCliente, Long idModeloArma) {
        Arma armaAntiga = armaRepository.buscarPorId(idArma);
        alterarCampos(armaAntiga, arma, idCliente, idArma);
        armaRepository.save(armaAntiga);

    }

    private void alterarCampos(Arma armaAntiga, Arma arma, Long idCliente, Long idModeloArma) {
        Cliente cliente = clienteRepository.buscarPorId(idCliente);
        ModeloArma modeloArma = modeloArmaRepository.buscarPorId(idModeloArma);
        if (arma.getStatus() == StatusArma.DISPONIVEL) {
            armaAntiga.setDataSaida(null);
        }
        armaAntiga.setModeloArma(modeloArma);
        armaAntiga.setCliente(cliente);
        armaAntiga.setCor(arma.getCor());
        armaAntiga.setSerie(arma.getSerie());
        armaAntiga.setStatus(arma.getStatus());
    }

    public List<Arma> buscarTodas() {
        return armaRepository.findAll();
    }

    public Arma buscarPorId(Long id) {
        return armaRepository.buscarPorId(id);
    }

    public List<Arma> buscarArmasVendidasEmEstoque() {
        return armaRepository.buscarArmasVendidasEmEstoque();
    }



    private Cliente verificarSeClienteEstaCadastrado(Long id) {
        Cliente cliente = clienteRepository.buscarPorId(id);
        if(cliente != null) {
            return cliente;
        } else {
            throw new BusinessException(SistemaMessageCode.ERRO_CLIENTE_NAO_CADASTRADO);
        }
    }
    private  void verificarSerieExistente(String serie) {
        Arma arma = armaRepository.findArmaBySerie(serie);
        if(arma != null) {
            throw new BusinessException(SistemaMessageCode.ERRO_SERIE_CADASTRADA);
        }
    }
    private ModeloArma VerificarModeloNaoExistente(Long id) {
        ModeloArma modeloArma = modeloArmaRepository.buscarPorId(id);
        if (modeloArma == null) {
            throw new BusinessException(SistemaMessageCode.ERRO_MODELO_NAO_EXISTENTE);
        } else {
            return modeloArma;
        }

    }
}

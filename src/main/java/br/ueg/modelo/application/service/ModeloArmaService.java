package br.ueg.modelo.application.service;

import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.application.repository.ModeloArmaRepository;
import br.ueg.modelo.application.service.validate.ModeloArmaValidate;
import br.ueg.modelo.comum.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloArmaService {

    @Autowired
    ModeloArmaRepository modeloArmaRepository;

    public void criar(ModeloArma modeloArma) {
        verificarSeNaoExisteModeloArmaPorModelo(modeloArma.getModelo());
        ModeloArmaValidate.verificarCamposEmBranco(modeloArma);
        ModeloArmaValidate.verificarCamposNulos(modeloArma);
        modeloArma.setModelo(modeloArma.getModelo().toUpperCase());
        modeloArma.setMarca(modeloArma.getMarca().toUpperCase());
        modeloArma.setPaisFabricacao(modeloArma.getPaisFabricacao().toUpperCase());
        modeloArma.setCalibre(modeloArma.getCalibre().toUpperCase());
        modeloArmaRepository.save(modeloArma);
    }

    public List<ModeloArma> listarTodos() {
        return modeloArmaRepository.findAll();
    }

    public void atualizar(Long id, ModeloArma modeloArma) {
        ModeloArma modeloArmaAntigo = modeloArmaRepository.buscarPorId(id);
        atualizarCampos(modeloArmaAntigo, modeloArma);
    }

    private void atualizarCampos(ModeloArma modeloArmaAntigo, ModeloArma modeloArma) {
        if(modeloArma.getModelo().toUpperCase().equals(modeloArmaAntigo.getModelo().toUpperCase())) {

        } else {
            verificarSeNaoExisteModeloArmaPorModelo(modeloArma.getModelo());
        }
        modeloArmaAntigo.setModelo(modeloArma.getModelo().toUpperCase());
        modeloArmaAntigo.setAlmaArma(modeloArma.getAlmaArma());
        modeloArmaAntigo.setTamanhoArma(modeloArma.getTamanhoArma());
        modeloArmaAntigo.setPreco(modeloArma.getPreco());
        modeloArmaAntigo.setPaisFabricacao(modeloArma.getPaisFabricacao().toUpperCase());
        modeloArmaAntigo.setCalibre(modeloArma.getCalibre().toUpperCase());
        modeloArmaAntigo.setCapacidade(modeloArma.getCapacidade());
        modeloArmaAntigo.setMarca(modeloArma.getMarca().toUpperCase());
        modeloArmaAntigo.setQuantidadeDeCano(modeloArma.getQuantidadeDeCano());
        modeloArmaRepository.save(modeloArmaAntigo);
    }

    public ModeloArma buscarPorId(Long id) {
        verificarSeExisteModeloArmaPorId(id);
        return modeloArmaRepository.buscarPorId(id);

    }


    private void verificarSeExisteModeloArmaPorId (Long id) {
        Optional<ModeloArma> modeloArma = modeloArmaRepository.findById(id);
        if(modeloArma.isPresent()) {

        } else {
            throw new BusinessException(SistemaMessageCode.ERRO_MODELO_NAO_EXISTENTE);
        }
    }

    private void verificarSeNaoExisteModeloArmaPorModelo(String modelo) {
        ModeloArma modeloArma = modeloArmaRepository.findByModelo(modelo);
        if(modeloArma != null) {
            throw new BusinessException(SistemaMessageCode.ERRO_MODELO_EXISTENTE);
        }

    }

}

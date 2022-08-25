package br.ueg.modelo.application.service;

import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.application.repository.ModeloArmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloArmaService {

    @Autowired
    ModeloArmaRepository modeloArmaRepository;

    public void criar(ModeloArma modeloArma) {

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
        modeloArmaAntigo.setModelo(modeloArma.getModelo());
        modeloArmaAntigo.setAlmaArma(modeloArma.getAlmaArma());
        modeloArmaAntigo.setTamanhoArma(modeloArma.getTamanhoArma());
        modeloArmaAntigo.setPreco(modeloArma.getPreco());
        modeloArmaAntigo.setPaisFabricacao(modeloArma.getPaisFabricacao());
        modeloArmaAntigo.setCalibre(modeloArma.getCalibre());
        modeloArmaAntigo.setCapacidade(modeloArma.getCapacidade());
        modeloArmaAntigo.setMarca(modeloArma.getMarca());
        modeloArmaAntigo.setQuantidadeDeCano(modeloArma.getQuantidadeDeCano());
        modeloArmaRepository.save(modeloArmaAntigo);
    }

    public ModeloArma buscarPorId(Long id) {
        return modeloArmaRepository.buscarPorId(id);
    }
}

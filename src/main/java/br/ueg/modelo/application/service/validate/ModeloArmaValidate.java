package br.ueg.modelo.application.service.validate;

import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.ModeloArma;
import br.ueg.modelo.comum.exception.BusinessException;

public class ModeloArmaValidate {

    public static void verificarCamposEmBranco(ModeloArma modeloArma) {
        if (modeloArma.getModelo().isEmpty() || modeloArma.getCalibre().isEmpty() ||
                modeloArma.getMarca().isEmpty() || modeloArma.getPaisFabricacao().isEmpty()) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }

    public static void verificarCamposNulos(ModeloArma modeloArma) {
        if (modeloArma.getPreco().equals(null) || modeloArma.getAlmaArma().equals(null) ||
                modeloArma.getTamanhoArma().equals(null) || modeloArma.getCapacidade() <= 0 ||
                modeloArma.getPreco() <= 0 || modeloArma.getPaisFabricacao().equals(null) ||
                modeloArma.getQuantidadeDeCano() <= 0 || modeloArma.getCalibre().equals(null) ||
                modeloArma.getMarca().equals(null)) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }




}

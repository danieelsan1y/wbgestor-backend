package br.ueg.modelo.application.service.validate;

import br.ueg.modelo.application.enums.StatusArma;
import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.Arma;
import br.ueg.modelo.comum.exception.BusinessException;

public class ArmaValidate {

    public static void validarEntradaValoresNulos(Arma arma, Long modeloArmaId) {
        if (arma.getCor().equals(null) || arma.getSerie().equals(null) || modeloArmaId.equals(null)) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }

    public static void validarEntradaValoresBrancos(Arma arma) {
        if (arma.getCor().isEmpty() || arma.getSerie().isEmpty()) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }

    public static void validarStatusArma(StatusArma statusArma) {
        if (!statusArma.equals(StatusArma.DISPONIVEL) &&!statusArma.equals(StatusArma.VENDIDO_E_RETIRADO) &&
        !statusArma.equals(StatusArma.VENDIDO_EM_ESTOQUE) && !statusArma.equals(StatusArma.GARANTIA) &&
        !statusArma.equals(StatusArma.DESATIVADO)) {
            throw new BusinessException(SistemaMessageCode.ERRO_STATUS_INVALIDO);

        }
    }
}

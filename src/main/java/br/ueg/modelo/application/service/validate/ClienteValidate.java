package br.ueg.modelo.application.service.validate;

import br.ueg.modelo.application.enums.StatusCliente;
import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.Cliente;
import br.ueg.modelo.comum.exception.BusinessException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClienteValidate {

    public static void validarData(LocalDate dataCliente) {
        if (dataCliente != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            String data = sdf.format(dataCliente);
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate d = LocalDate.parse(data, formatter);
            } catch (DateTimeParseException e) {
                throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_DATA_INCORRETO);
            }
        } else {
            throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_DATA_INCORRETO);
        }

    }

    public static void validarCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new BusinessException(SistemaMessageCode.ERRO_CPF_INVALIDO);
        }
    }

    public static void validarTelefone(String telefone) {
        if (telefone.length() != 11) {
            throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_TELEFONE_INVALIDO);
        }
    }

    public static void validarSituacao(StatusCliente statusCliente) {
        if (statusCliente.equals("ATIVO") && !statusCliente.equals("INATIVO")) {
            throw new BusinessException(SistemaMessageCode.ERRO_STATUS_INVALIDO);
        }
    }

    public static void validarSeCpfTemLetra(String cpf) {
        boolean isNumeric = cpf.matches("[+-]?\\d*(\\.\\d+)?");
        if (isNumeric == false) {
            throw new BusinessException(SistemaMessageCode.ERRO_CPF_INVALIDO);
        }
    }

    public static void validarSeDataTemLetra(LocalDate dataCliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String data = sdf.format(dataCliente);
        data = data.replaceAll("/", "");
        boolean isNumeric = data.matches("[+-]?\\d*(\\.\\d+)?");
        if (isNumeric == false) {
            throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_DATA_INCORRETO);
        }
    }

    public static void validarSeTelefoneTemLetras(String telefone) {
        boolean isNumeric = telefone.matches("[+-]?\\d*(\\.\\d+)?");
        if (isNumeric == false) {
            throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_TELEFONE_INVALIDO);
        }
    }

    public static void validarCamposNulos(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getCpf() == null ||
                cliente.getDataDeNacimento() == null || cliente.getEndereco() == null ||
                cliente.getTelefone() == null || cliente.getCr() == null ||
                cliente.getValidadeCR() == null || cliente == null) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }


    public static void validarCamposEmBranco(Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getCpf().isEmpty() ||
                cliente.getEndereco().isEmpty() || cliente.getTelefone().equals(null) ||
                cliente.getCr().isEmpty()) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }
}

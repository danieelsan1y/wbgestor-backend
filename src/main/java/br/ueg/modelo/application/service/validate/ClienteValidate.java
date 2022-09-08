package br.ueg.modelo.application.service.validate;

import br.ueg.modelo.application.exception.SistemaMessageCode;
import br.ueg.modelo.application.model.Cliente;
import br.ueg.modelo.comum.exception.BusinessException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClienteValidate {

    public static void validarData(Cliente cliente) {
        if(cliente.getDataDeNacimento() !=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            String data = sdf.format(cliente.getDataDeNacimento());
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate d = LocalDate.parse(data, formatter);
            } catch (DateTimeParseException e) {
                throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_DATA_INCORRETO);
            }
        } else  {
            throw new BusinessException(SistemaMessageCode.ERRO_FORMATO_DATA_INCORRETO);
        }

    }
}

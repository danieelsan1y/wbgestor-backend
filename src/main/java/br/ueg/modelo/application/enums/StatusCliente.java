package br.ueg.modelo.application.enums;

public enum StatusCliente {
    ATIVO(0),
    INATIVO(1);

    private int code;

    private StatusCliente(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusCliente valueOf(int code) {
        for (StatusCliente value : StatusCliente.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}

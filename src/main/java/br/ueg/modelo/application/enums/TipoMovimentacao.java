package br.ueg.modelo.application.enums;

public enum TipoMovimentacao {
    ENTRADA(0),
    SAIDA(1);

    private int code;
    private TipoMovimentacao(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoMovimentacao valueOf(int code) {
        for (TipoMovimentacao value : TipoMovimentacao.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}

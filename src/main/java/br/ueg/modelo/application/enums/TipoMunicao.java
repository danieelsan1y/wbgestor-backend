package br.ueg.modelo.application.enums;

public enum TipoMunicao {
    UNIDADE(0);

    private int code;
    private TipoMunicao(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoMunicao valueOf(int code) {
        for (TipoMunicao value : TipoMunicao.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}

package br.ueg.modelo.application.enums;

public enum TamanhoArma {
    CURTA(0),
    LONGA(1);

    private int code;
    private TamanhoArma(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TamanhoArma valueOf(int code) {
        for (TamanhoArma value : TamanhoArma.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}

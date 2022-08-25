package br.ueg.modelo.application.enums;

public enum AlmaArma {
    LISA(0),
    RAIADA(1);

    private int code;
    private AlmaArma(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AlmaArma valueOf(int code) {
        for (AlmaArma value : AlmaArma.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}

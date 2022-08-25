package br.ueg.modelo.application.enums;

public enum StatusArma {
    DISPONIVEL(0),
    VENDIDO_EM_ESTOQUE(1),
    VENDIDO_E_RETIRADO(2),
    ROUBADO(3),
    DESATIVADO(4),
    GARANTIA(5);

    private int code;

    private StatusArma(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusArma valueOf(int code) {
        for (StatusArma value : StatusArma.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}

public enum PrioridadeEmergencia {
    NIVEL_1(1),
    NIVEL_2(2),
    NIVEL_3(3),
    NIVEL_4(4),
    NIVEL_5(5);

    private final int valor;

    PrioridadeEmergencia(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
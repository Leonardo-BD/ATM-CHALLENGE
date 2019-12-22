package br.com.ibm.challenge.enumerator;

public enum CedulasReal {

    NOTA_2      (2),
    NOTA_5      (5),
    NOTA_10     (10),
    NOTA_20     (20),
    NOTA_50     (50),
    NOTA_100    (100);

    int valor;

    CedulasReal(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "CedulasReal{" +
                "valor=" + valor +
                '}';
    }
}

package br.com.ibm.challenge.enumerator;

public enum ETipoDeposito {

    DINHEIRO    (1, "Dinheiro"),
    CHEQUE      (2, "Cheque");

    private final long id;
    private final String descricao;

    ETipoDeposito(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public static boolean tipoDepositoExistente(long idTipoDeposito) {
        for (ETipoDeposito eTipoDeposito : ETipoDeposito.values()) {
            if (eTipoDeposito.getId() == idTipoDeposito) {
                return true;
            }
        }

        return false;
    }
}

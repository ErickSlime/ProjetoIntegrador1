package br.unitins.greentech.model;

public enum Classificacao {

    ARENOSO(1, "Arenoso"),
    ARGILOSO(2, "Argiloso"),
    SILTOSO(3, "Siltoso");

    private int id;
    private String label;

    Classificacao(int id, String label) {

        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Classificacao valueOf(Integer id) throws IllegalArgumentException {

        if (id == null)
            return null;

        for (Classificacao classificacao : Classificacao.values()) {

            if (id == classificacao.id)
                return classificacao;
        }

        throw new IllegalArgumentException("Número fora das opções disponíveis");
    }
}

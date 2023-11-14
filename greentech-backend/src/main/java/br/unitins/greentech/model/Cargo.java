package br.unitins.greentech.model;

public enum Cargo {
    
    ADMIN(1, "Admin"),
    USER(2, "User");

    private int id;
    private String label;

    Cargo(int id, String label) {

        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Cargo valueOf(Integer id) throws IllegalArgumentException {

        if (id == null)
            return null;

        for (Cargo cargo : Cargo.values()) {

            if (id == cargo.id)
                return cargo;
        }

        throw new IllegalArgumentException("Número fora das opções disponíveis");
    }

}

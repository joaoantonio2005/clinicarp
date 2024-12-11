package model;

public class Dentista {
    private String nome;
    private String crm;
    private String telefone;
    private String email;

    // Construtor
    public Dentista(String nome, String crm, String telefone, String email) {
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
package model;

import java.util.Date;

public class Consulta {
    private Paciente paciente;
    private Dentista dentista;
    private Date dataConsulta;
    private String descricao;

    public Consulta(Paciente paciente, Dentista dentista, Date dataConsulta, String descricao) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public String getDescricao() {
        return descricao;
    }
}
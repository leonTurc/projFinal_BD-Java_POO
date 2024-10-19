package br.com.DTO;

import java.sql.Date;
import java.sql.Time;

public class AgendaDTO {
    ClienteDTO cliDto = new ClienteDTO();
    
    private int id;
    private Date data;
    private Time hora;
    private String descricao;
    private int idCli = cliDto.getIdCli();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}

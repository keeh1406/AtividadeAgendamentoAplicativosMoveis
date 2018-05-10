package com.example.opet.agendamento.Model;

import java.util.Date;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by opet on 09/05/2018.
 */
@Entity
public class Agenda {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nomeCompromisso;
    private String descricao;
    private Date data;
    private String prioridade;
    private int flRealizado;

    public Agenda() {
    }

    public Agenda(int id, String nomeCompromisso, String descricao, Date data, String prioridade, int flRealizado) {
        this.id = id;
        this.nomeCompromisso = nomeCompromisso;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
        this.flRealizado = flRealizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompromisso() {
        return nomeCompromisso;
    }

    public void setNomeCompromisso(String nomeCompromisso) {
        this.nomeCompromisso = nomeCompromisso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getFlRealizado() {
        return flRealizado;
    }

    public void setFlRealizado(Integer flRealizado) {
        this.flRealizado = flRealizado;
    }
}

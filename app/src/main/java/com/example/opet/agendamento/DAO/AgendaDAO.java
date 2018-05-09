package com.example.opet.agendamento.DAO;

import com.example.opet.agendamento.Model.Agenda;

import java.util.List;

/**
 * Created by opet on 09/05/2018.
 */

@Dao
public class AgendaDAO {
    @Insert
    public long insertAgenda(Agenda agenda);

    @Query("SELECT * FROM Agenda")
    public List<Agenda> findAll();
}

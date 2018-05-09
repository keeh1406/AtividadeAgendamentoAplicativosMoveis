package com.example.opet.agendamento.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;
import com.example.opet.agendamento.Model.Agenda;
import java.util.Date;
import java.util.List;

/**
 * Created by opet on 09/05/2018.
 */

@Dao
public interface AgendaDAO {
    @Query("SELECT * from Agenda")
    List<Agenda> getAll();

    @Query("SELECT * from Agenda WHERE id in (:agendaID)")
    List<Agenda> loadAgendaByIds(int[] agendaID);

    @Query("SELECT * from Agenda WHERE ID LIKE :id")
    Agenda findByAgenda(int id);

    @Query("SELECT * from Agenda WHERE data in (:agendaData)")
    List<Agenda> loadAgendaByDatas(Date[] agendaData);

    @Query ("SELECT * FROM Agenda Where FlRealizado LIKE 'false'")
    List<Agenda> loadAgendaByflRealizado(String[] agendaflRealizado);

    @Insert
    long insertAgenda(Agenda agenda);

    @Delete
    int delete(Agenda agenda);

    @Update
    int update(Agenda agenda);
    }

package com.example.opet.agendamento.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.opet.agendamento.DAO.AgendaDAO;
import com.example.opet.agendamento.Model.Agenda;

/**
 * Created by opet on 09/05/2018.
 */

public class AppDatabase {
    @Database(entities = {Agenda.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase{

        public abstract AgendaDAO agendaDAO();
        private static AppDatabase INSTANCE;

        public static AppDatabase getInstance(Context context) {
            if(INSTANCE == null)
                INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "agendadb").build();
            return INSTANCE;
        }
}

package com.example.opet.agendamento.Factory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.opet.agendamento.DAO.AgendaDAO;
import com.example.opet.agendamento.Model.Agenda;

/**
 * Created by opet on 09/05/2018.
 */
@Database(entities = {Agenda.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AgendaDAO agendaDAO();
    private static AppDatabase INSTANCE;


    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "agendadb").fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }


    public static void setINSTANCE(AppDatabase INSTANCE) {
        AppDatabase.INSTANCE = INSTANCE;
    }
}

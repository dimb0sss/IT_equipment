package com.lvovds.itequipment.db.computer;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ComputerNote.class},version = 1)
public abstract class ComputerNoteDatabase extends RoomDatabase {

    private static ComputerNoteDatabase instance = null;
    private static final String DB_NAME = "computer_notes.db";

    public static ComputerNoteDatabase getInstance(Application application) {
        if (instance==null) {
            instance = Room.databaseBuilder(application, ComputerNoteDatabase.class, DB_NAME)
                    .build();
        } return instance;


    }

    abstract ComputerNoteDao computerNoteDao();
}

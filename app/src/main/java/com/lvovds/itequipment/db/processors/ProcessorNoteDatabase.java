package com.lvovds.itequipment.db.processors;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lvovds.itequipment.db.computer.ComputerNote;
import com.lvovds.itequipment.db.computer.ComputerNoteDao;
import com.lvovds.itequipment.db.computer.ComputerNoteDatabase;

@Database(entities = {ProcessorNote.class},version = 1)
public abstract class ProcessorNoteDatabase extends RoomDatabase {
    private static ProcessorNoteDatabase instance = null;
    private static final String DB_NAME = "processor_notes.db";

    public static ProcessorNoteDatabase getInstance(Application application) {
        if (instance==null) {
            instance = Room.databaseBuilder(application, ProcessorNoteDatabase.class, DB_NAME)
                    .build();
//            instance.processorNoteDao().addProcessor(new ProcessorNote("Выбор модели процессора"));
//            instance.processorNoteDao().addProcessor(new ProcessorNote("Добавить запись"));

        } return instance;


    }

    public abstract ProcessorNoteDao processorNoteDao();
}

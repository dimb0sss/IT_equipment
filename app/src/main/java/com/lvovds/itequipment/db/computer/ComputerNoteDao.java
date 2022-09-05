package com.lvovds.itequipment.db.computer;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ComputerNoteDao {

    @Query("SELECT * FROM computer_notes")
    List<ComputerNote> getAllComputers();
}

package com.lvovds.itequipment.db.processors;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface ProcessorNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addProcessor(ProcessorNote processorNote);

    @Query("SELECT * FROM processor_note")
    LiveData<List<ProcessorNote>> getAllProcessors();

}

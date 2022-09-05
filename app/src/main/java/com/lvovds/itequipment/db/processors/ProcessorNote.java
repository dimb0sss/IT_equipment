package com.lvovds.itequipment.db.processors;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.lvovds.itequipment.db.computer.ComputerNote;

import java.util.ArrayList;

@Entity(tableName = "processor_note")
public class ProcessorNote {
    @PrimaryKey( autoGenerate = true)
    private int processorId;
    private String processorName;



    public ProcessorNote(String processorName) {
        this.processorName = processorName;
    }

    public int getProcessorId() {
        return processorId;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorId(int processorId) {
        this.processorId = processorId;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    //    private static ArrayList<String> processors = new ArrayList<>();
//
//    public static ProcessorNote getInstance() {
//        if (instance ==null) {
//            instance = new ProcessorNote();
//            instance.add("Выбор модели процессора");
//            instance.add("Добавить запись");
//        }
//        return instance;
//    }
//
//    public void add(String name) {
//        processors.add(name);
//    }
//
//    public ArrayList<String> getProcessors() {
//        return new ArrayList<>(processors);
//    }
//
//    private static ProcessorNote instance = null;
}

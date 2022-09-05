package com.lvovds.itequipment.db.computer;


import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.lvovds.itequipment.db.processors.ProcessorNote;

@Entity(tableName = "computer_notes")
public class ComputerNote {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String pcHostName;
    private String pcSerialNumber;
    private String pcInventaryNumber;
    private int pcProcessorId;
    private int pcMemorySizeId;

    public ComputerNote(String pcHostName, String pcSerialNumber, String pcInventaryNumber, int pcProcessorId, int pcMemorySizeId) {
        this.pcHostName = pcHostName;
        this.pcSerialNumber = pcSerialNumber;
        this.pcInventaryNumber = pcInventaryNumber;
        this.pcProcessorId = pcProcessorId;
        this.pcMemorySizeId = pcMemorySizeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPcHostName() {
        return pcHostName;
    }

    public void setPcHostName(String pcHostName) {
        this.pcHostName = pcHostName;
    }

    public String getPcSerialNumber() {
        return pcSerialNumber;
    }

    public void setPcSerialNumber(String pcSerialNumber) {
        this.pcSerialNumber = pcSerialNumber;
    }

    public String getPcInventaryNumber() {
        return pcInventaryNumber;
    }

    public void setPcInventaryNumber(String pcInventaryNumber) {
        this.pcInventaryNumber = pcInventaryNumber;
    }

    public int getPcProcessorId() {
        return pcProcessorId;
    }

    public void setPcProcessorId(int pcProcessorId) {
        this.pcProcessorId = pcProcessorId;
    }

    public int getPcMemorySizeId() {
        return pcMemorySizeId;
    }

    public void setPcMemorySizeId(int pcMemorySizeId) {
        this.pcMemorySizeId = pcMemorySizeId;
    }
}

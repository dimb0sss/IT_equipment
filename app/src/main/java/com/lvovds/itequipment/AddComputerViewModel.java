package com.lvovds.itequipment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lvovds.itequipment.db.computer.ComputerNote;
import com.lvovds.itequipment.db.processors.ProcessorNote;
import com.lvovds.itequipment.db.processors.ProcessorNoteDatabase;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class AddComputerViewModel extends AndroidViewModel {
    private ProcessorNoteDatabase processorNoteDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<ProcessorNote>> processorNote = new MutableLiveData<>();

    public AddComputerViewModel(@NonNull Application application) {
        super(application);
        processorNoteDatabase=ProcessorNoteDatabase.getInstance(getApplication());
    }

    public LiveData<List<ProcessorNote>>  getProcessorNote() {
        return processorNoteDatabase.processorNoteDao().getAllProcessors();
    }
}

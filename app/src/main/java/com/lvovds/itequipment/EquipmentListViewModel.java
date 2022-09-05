package com.lvovds.itequipment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lvovds.itequipment.db.computer.ComputerNoteDao;
import com.lvovds.itequipment.db.processors.ProcessorNote;
import com.lvovds.itequipment.db.processors.ProcessorNoteDao;
import com.lvovds.itequipment.db.processors.ProcessorNoteDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class EquipmentListViewModel extends AndroidViewModel {
    private ProcessorNoteDao processorNoteDao;
    private MutableLiveData<List<ProcessorNote>> processors = new MutableLiveData<>();
    private MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();




    public EquipmentListViewModel(@NonNull Application application) {
        super(application);
        processorNoteDao = ProcessorNoteDatabase.getInstance(getApplication()).processorNoteDao();
    }

    public LiveData<Boolean> getShouldCloseScreen() {
        return shouldCloseScreen;
    }

    public void add(ProcessorNote processorNote) {
        Disposable disposable = processorNoteDao.addProcessor(processorNote)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        shouldCloseScreen.postValue(true);
                    }
                });

        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    public LiveData<List<ProcessorNote>> getProcessors() {
        return processors;
    }
}

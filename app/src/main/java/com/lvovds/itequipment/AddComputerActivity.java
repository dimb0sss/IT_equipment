package com.lvovds.itequipment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.lvovds.itequipment.db.processors.ProcessorNote;

import java.util.ArrayList;
import java.util.List;

public class AddComputerActivity extends AppCompatActivity {
    private Spinner spinnerProccesor;
    private ArrayAdapter<String> adapter;
    private AddComputerViewModel addComputerViewModel;
    private List<String> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_computer);
        addComputerViewModel = new ViewModelProvider(this).get(AddComputerViewModel.class);
        initView();
        mList.add("Выберете процессор");
        mList.add("Добавить запись");
        adapter = new ArrayAdapter<String>(AddComputerActivity.this, android.R.layout.simple_list_item_1,mList){
            //Grey first item
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

            @Override
            public boolean isEnabled(int position) {
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
        } ;
        spinnerProccesor.setAdapter(adapter);
        addComputerViewModel.getProcessorNote().observe(this, new Observer<List<ProcessorNote>>() {
            @Override
            public void onChanged(List<ProcessorNote> processorNotes) {
                for (ProcessorNote processorNote : processorNotes) {
                    if (mList.contains(processorNote.getProcessorName())) {

                    } else {
                        mList.add(processorNote.getProcessorName());
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
        spinnerProccesor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1) {
                    startActivity(new Intent(AddComputerActivity.this,EquipmentListActivity.class));
                    spinnerProccesor.setSelection(0);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }



    public void showNotes(){
        spinnerProccesor.setAdapter(adapter);
    }

    private void initView() {
        spinnerProccesor = findViewById(R.id.spinnerPcProcessor);
    }

    public static Intent newIntent(Context context,int id) {
        Intent intent = new Intent(context,AddComputerActivity.class);
        intent.putExtra("newOption",id);
        return intent;
    }
}
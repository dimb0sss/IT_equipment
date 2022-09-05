package com.lvovds.itequipment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lvovds.itequipment.db.processors.ProcessorNote;

public class EquipmentListActivity extends AppCompatActivity {
    private EditText editTextUserOption;
    private Button buttonUserOption;

    private EquipmentListViewModel equipmentListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);
        equipmentListViewModel = new ViewModelProvider(this).get(EquipmentListViewModel.class);
        initView();
        equipmentListViewModel.getShouldCloseScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shouldClose) {
                if (shouldClose) {
                    finish();
                }
            }
        });
        saveOption();


    }

    private void saveOption() {
        buttonUserOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserOption.getText().toString().isEmpty()) {
                    Toast.makeText(EquipmentListActivity.this, R.string.error_string_empty,Toast.LENGTH_SHORT).show();
                } else {
                    ProcessorNote processorNote = new ProcessorNote(editTextUserOption.getText().toString());
                    equipmentListViewModel.add(processorNote);
                    finish();

//                    Intent intent = AddComputerActivity.newIntent(EquipmentListActivity.this,);
//                    startActivity(intent);
                }
            }
        });
    }

    private void initView() {
        editTextUserOption = findViewById(R.id.editTextUserOption);
        buttonUserOption = findViewById(R.id.buttonAddOption);
    }
}
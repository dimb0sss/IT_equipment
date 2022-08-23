package com.lvovds.itequipment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddComputerActivity extends AppCompatActivity {
    private Spinner spinnerProccesor;
    private Database database;
    ArrayAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_computer);
        initView();
        database=Database.getInstance();


        adapter = new ArrayAdapter(
                getApplicationContext(),android.R.layout.simple_list_item_1 ,database.getProcessors());
        adapter.notifyDataSetChanged();
        spinnerProccesor.setAdapter(adapter);
        Intent intent = getIntent();
        if (intent.hasExtra("newOption")) {
            int id = intent.getIntExtra("newOption",0);
            id--;
            System.out.println(id);
            spinnerProccesor.setSelection(id);
        }

        spinnerProccesor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if (i==1) {
                   Intent intent = new Intent(AddComputerActivity.this,EquipmentListActivity.class);
                   startActivity(intent);
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
        spinnerProccesor = findViewById(R.id.spinnerProccesor);
    }

}
package com.lvovds.itequipment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EquipmentListActivity extends AppCompatActivity {
    private EditText editTextUserOption;
    private Button buttonUserOption;
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);
        initView();
        database=Database.getInstance();

        buttonUserOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserOption.toString().isEmpty()) {
                    Toast.makeText(EquipmentListActivity.this,"Заполните поле",Toast.LENGTH_SHORT).show();
                } else {
                     database.add(editTextUserOption.getText().toString());

                    Intent intent = new Intent(EquipmentListActivity.this,AddComputerActivity.class);
                    intent.putExtra("newOption",database.getProcessors().size());
                    startActivity(intent);
                }
            }
        });


    }

    private void initView() {
        editTextUserOption = findViewById(R.id.editTextUserOption);
        buttonUserOption = findViewById(R.id.buttonAddOption);
    }
}
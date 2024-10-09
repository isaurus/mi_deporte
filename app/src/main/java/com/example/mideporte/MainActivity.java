package com.example.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class MainActivity extends AppCompatActivity {

    // Declaración de RadioGroup
    RadioGroup rbtgTipo;

    // Declaración de Spinner
    Spinner spnDeporte;

    // Declaración de TextView
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciación de RadioGroup con el objeto XML
        rbtgTipo = findViewById(R.id.rbtgTipo);

        // Instanciación de Spinner
        spnDeporte = findViewById(R.id.spnDeporte);

        // Adapter para el Spinner
        ArrayAdapter<CharSequence> adapterSpinnerDeporteIndividual= ArrayAdapter.createFromResource(this, R.array.spn_deporte_individual, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterSpinnerDeportePareja = ArrayAdapter.createFromResource(this, R.array.spn_deporte_pareja, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterSpinnerDeporteGrupal = ArrayAdapter.createFromResource(this,R.array.spn_deporte_grupal, android.R.layout.simple_spinner_item);

        // Instanciación de TextView
        txtResultado = findViewById(R.id.txtResultado);

        // Listener para el RadioGroup. La opción seleccionada determinada el conjunto mostrado en el Spinner
        rbtgTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbtIndividual){
                    spnDeporte.setAdapter(adapterSpinnerDeporteIndividual);
                    adapterSpinnerDeporteIndividual.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                } else if(checkedId == R.id.rbtEnPareja) {
                    spnDeporte.setAdapter(adapterSpinnerDeportePareja);
                    adapterSpinnerDeportePareja.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                }else{
                    spnDeporte.setAdapter(adapterSpinnerDeporteGrupal);
                    adapterSpinnerDeporteGrupal.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                }

            }
        });

        spnDeporte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtResultado.setText(spnDeporte.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
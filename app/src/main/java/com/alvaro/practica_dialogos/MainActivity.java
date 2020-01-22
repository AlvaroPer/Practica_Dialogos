package com.alvaro.practica_dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.alvaro.practica_dialogos.dialogos.DialogoBienvenida;
import com.alvaro.practica_dialogos.dialogos.DialogoFecha;
import com.alvaro.practica_dialogos.dialogos.DialogoHora;
import com.alvaro.practica_dialogos.dialogos.DialogoNota;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogoBienvenida.OnDialogoBienvenida, DialogoNota.onDialogoNota,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    TextView notaExamen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        notaExamen = findViewById(R.id.nota);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        DialogoBienvenida dialogoBienvenida = new DialogoBienvenida();
        dialogoBienvenida.show(getSupportFragmentManager(), "Inicio");
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.opcion_menu:
                DialogoBienvenida dialogoBienvenida = new DialogoBienvenida();
                dialogoBienvenida.show(getSupportFragmentManager(),"bienvenida");
                break;
        }
    }

    @Override
    public void onDialogoSelected(String s) {

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        DialogoHora dialogoHora = new DialogoHora();
        dialogoHora.show(getSupportFragmentManager(),"hora");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        DialogoNota dialogoNota = new DialogoNota();
        dialogoNota.show(getSupportFragmentManager(),"nota");
    }

    @Override
    public void onDialogoNota(String nota) {
        notaExamen.setText(nota);
    }
}

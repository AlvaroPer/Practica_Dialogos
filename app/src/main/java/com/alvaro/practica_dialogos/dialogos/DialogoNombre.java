package com.alvaro.practica_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.alvaro.practica_dialogos.R;

public class DialogoNombre extends DialogFragment {

    EditText editNombre;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_perso,null);
        instancias();
    }

    private void instancias() {
        editNombre = v.findViewById(R.id.edit_nombre_dialogo);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle("Diálogo 2");
        dialogo.setMessage("Introduce tu nombre");
        dialogo.setView(v);
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        dialogo.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nombre = editNombre.getText().toString();
                DialogoRecuperar dialogoRecuperar =  DialogoRecuperar.newInstance(nombre);
                dialogoRecuperar.show(getFragmentManager(),"recuperar");
            }
        });

        return dialogo.create();
    }

}

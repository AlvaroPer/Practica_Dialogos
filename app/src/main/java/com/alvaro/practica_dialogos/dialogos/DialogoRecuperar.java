package com.alvaro.practica_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoRecuperar extends DialogFragment {

    public String nombreRecuperado;
    static final String TAG_ARG1 = "nombre";

    public static DialogoRecuperar newInstance(String nombre){

        DialogoRecuperar dialogoRecuperar = new DialogoRecuperar();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1,nombre);
        dialogoRecuperar.setArguments(bundle);
        return dialogoRecuperar;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nombreRecuperado = this.getArguments().getString(TAG_ARG1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle("Diálogo 3");
        dialogo.setMessage("Perfecto, "+nombreRecuperado+" ahora tendrás que introducir una fecha y una hora, ¿OK?");
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();

            }
        });
        dialogo.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getFragmentManager(),"fecha");
            }
        });

        return dialogo.create();
    }
}

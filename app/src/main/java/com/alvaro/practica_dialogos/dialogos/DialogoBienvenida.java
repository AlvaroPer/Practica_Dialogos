package com.alvaro.practica_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoBienvenida extends DialogFragment {

    OnDialogoBienvenida listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoBienvenida) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle("Diálogo 1");
        dialogo.setMessage("Bienvenido al examen. ¿Estás seguro de continuar?");
        dialogo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSelected("no");
                dismiss();
            }
        });
        dialogo.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoSelected("si");
                DialogoNombre dialogoNombre = new DialogoNombre();
                dialogoNombre.show(getFragmentManager(),"nombre");
            }
        });

        return dialogo.create();
    }

    public interface OnDialogoBienvenida{
        void onDialogoSelected(String s);
    }


}

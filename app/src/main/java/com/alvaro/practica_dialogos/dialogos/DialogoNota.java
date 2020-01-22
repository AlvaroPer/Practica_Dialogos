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

public class DialogoNota extends DialogFragment {

    onDialogoNota listener;

    EditText editNota;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_perso_nota,null);
        instancias();
        listener = (onDialogoNota) getContext();

    }

    private void instancias() {
        editNota = v.findViewById(R.id.edit_nota);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());

        dialogo.setTitle("Diálogo 6");
        dialogo.setMessage("Introduce la nota que consideras que vas a sacar en el examen:");
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
                listener.onDialogoNota(editNota.getText().toString());
            }
        });

        return dialogo.create();
    }

    public interface onDialogoNota{
        void onDialogoNota(String nota);
    }
}

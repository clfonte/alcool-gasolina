package br.edu.aula02_alcoolougasolina;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;

public class Funcoes {
    public void mostrarMensagem(Context context, String sTitulo, String sMensagem) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(context);
        alerta.setTitle(sTitulo);
        alerta.setMessage(sMensagem);
        alerta.setPositiveButton("OKAY", null);
        alerta.show();
    }
}

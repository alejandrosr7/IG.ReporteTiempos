package com.intergrupo.reportedetiemposig.Helper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by USUARIO on 16/10/2016.
 */

public class ShowAlertDialogValidateInternet {


    /**
     * Método para mostrar un popup
     * @param title título a mostrar en el popup
     * @param message mensaje a mostrar en el popup
     * @param context contexto de donde llaman al popup
     */
    public static void showAlertDialogValidateInternet(int title, int message, Context context) {
            AlertDialog.Builder alertDialog;
            alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();

    }



}

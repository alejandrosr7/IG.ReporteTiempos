package com.intergrupo.reportedetiemposig.Helper;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;

import java.util.TimerTask;

/**
 * Created by leidycarolinazuluagabastidas on 9/05/17.
 */

public class CustomAlertdialog {

    public void showAlertDialogInputData(Window windows, LayoutInflater inflate, Context context, String title, final EditText editText, String text, int length) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = inflate;
        View content = inflater.inflate(R.layout.template_alert_dialog, null);
        Rect displayRectangle = new Rect();
        Window window = windows;
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        content.setMinimumWidth((int) (displayRectangle.width() * 0.9f));
        content.setMinimumHeight((int) (displayRectangle.height() * 0.5f));
        final EditText etInputData = (EditText) content.findViewById(R.id.edt_InputData);
        builder.setView(content).setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editText.setText(etInputData.getText().toString().trim());
                dialogInterface.dismiss();
            }
        }).setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        etInputData.setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
        etInputData.setText(text);
        etInputData.setSelection(text.length());
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.show();
        openKeyboard(etInputData, context);
    }

    private void openKeyboard(final EditText editText, final Context context) {
        editText.postDelayed(new TimerTask() {
            @Override
            public void run() {
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 400);
    }

    public static void showAlertDialogValidateInternet(int title, int message, Context context) {
        AlertDialog.Builder alertDialog;
        alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setCancelable(false);
        alertDialog.setIcon(R.drawable.ic_info_outline_24dp);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(Constants.ACEPTAR, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();

    }


}
package com.intergrupo.reportedetiemposig.Helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intergrupo.reportedetiemposig.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by USUARIO on 14/08/2016.
 */

    public class AcercaDePopup extends DialogFragment implements DialogInterface {

        private final String TAG = "AcercadePopup";
        private Activity context;

        OnClickListener positiveButton;
        OnClickListener negativeButton;
        int messageColor = Color.BLACK;

        @InjectView(R.id.btnSiAlerta)
        Button buttonPositive;


        CharSequence textMessage;
        int idMessage;
        CharSequence textTitle;
        int idTitle;
        CharSequence textPositiveButton;
        CharSequence textNegativeButton;


        @Override
        public Dialog onCreateDialog(Bundle savedInstance) {
            Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.acercade_popup);
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            window.setLayout(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ButterKnife.inject(this, dialog.getWindow().getDecorView());
            return dialog;
        }

        @Override
        public void cancel() {

        }


        public AcercaDePopup setPositiveButton(CharSequence text, OnClickListener clickListener) {
            this.positiveButton = clickListener;
            textPositiveButton = text;
            return this;
        }

        public AcercaDePopup setPositiveButton(OnClickListener clickListener) {
            this.positiveButton = clickListener;
            return this;
        }

        public AcercaDePopup setContext(Context context) {
            this.context = (Activity) context;
            return this;
        }


        @OnClick(R.id.btnSiAlerta)
        protected void positiveButtonClick() {
            if (this.positiveButton != null) {
                positiveButton.onClick(this, 0);
            }
        }

        public void show() {
            if (this.context == null)
                throw new ExceptionInInitializerError("Mensaje error");
            FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            this.show(fragmentManager, TAG);

        }

    }
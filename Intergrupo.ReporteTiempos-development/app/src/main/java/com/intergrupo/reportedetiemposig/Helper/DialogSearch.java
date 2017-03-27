package com.intergrupo.reportedetiemposig.Helper;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.intergrupo.reportedetiemposig.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by USUARIO on 15/08/2016.
 */
public class DialogSearch extends Dialog {

    private ArrayList<String> itemsOriginal;
    private ArrayList<String> itemsCopy;
    private IDialogSelection alertSelection;
    private String searchText;
    private int item;

    @InjectView(R.id.txt_alert_selection_search)
    EditText txtAlertSelectionSearch;

    @InjectView(R.id.lst_alert_selection)
    ListView lstAlertSelection;

     @InjectView(R.id.lbl_alert_selection_empty)
    TextView lblAlertSelectionEmpty;

    @InjectView(R.id.btn_alert_selection_clear)
    ImageButton btnAlertSelectionClear;

    @InjectView(R.id.btn_alert_selection_cancel)
    Button btnAlertSelectionCancel;



    public DialogSearch(Context context, ArrayList<String> items, String title, String searchText, IDialogSelection alertSelection) {
        super(context);
        setTitle(title);
        itemsOriginal = items;
        itemsCopy = (ArrayList<String>) items.clone();
        this.alertSelection = alertSelection;
        this.searchText = searchText;
    }

    public void setAlertSelection(IDialogSelection alertSelection) {
        this.alertSelection = alertSelection;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    private TextWatcher txtSeachWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            lblAlertSelectionEmpty.setVisibility(View.GONE);
            btnAlertSelectionClear.setVisibility(View.GONE);
            itemsCopy.clear();
            for (String item : itemsOriginal) {
                if (item.toLowerCase().contains(s.toString().toLowerCase())) {
                    itemsCopy.add(item);
                }
            }
            if (itemsCopy.size() == 0) {
                lblAlertSelectionEmpty.setVisibility(View.VISIBLE);
            }

            if (txtAlertSelectionSearch.getText().toString().length() > 0) {
                btnAlertSelectionClear.setVisibility(View.VISIBLE);
            }

            lstAlertSelection.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,itemsCopy));
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private ListView.OnItemClickListener lstAlert = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (alertSelection != null) {
                alertSelection.onResult(itemsCopy, position);
            }
            dismiss();
        }
    };

    private View.OnClickListener btnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtAlertSelectionSearch.setText("");
        }
    };

    private View.OnClickListener btnCancelOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    };

    private void bindEvents() {
        txtAlertSelectionSearch.addTextChangedListener(txtSeachWatcher);
        lstAlertSelection.setOnItemClickListener(lstAlert);
        btnAlertSelectionClear.setOnClickListener(btnOnClick);
        btnAlertSelectionCancel.setOnClickListener(btnCancelOnClick);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_selection);
        ButterKnife.inject(this);
        bindEvents();
        txtAlertSelectionSearch.setText(searchText);
    }

    public interface IDialogSelection {
        void onResult(ArrayList<String> itemsCopy, int position);
    }
}

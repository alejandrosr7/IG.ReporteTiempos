package com.intergrupo.reportedetiemposig.Ui.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.intergrupo.reportedetiemposig.Helper.IValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.SecurePreferences;
import com.intergrupo.reportedetiemposig.Helper.ShowAlertDialogValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.ValidateInternet;
import com.intergrupo.reportedetiemposig.Helper.Validation;
import com.intergrupo.reportedetiemposig.R;
import com.intergrupo.reportedetiemposig.Util.Constants;
import com.squareup.picasso.Picasso;;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by LeidyZuluaga on 9/05/16.
 */
public class MenuActivity extends AppCompatActivity {

    @InjectView(R.id.Menu_Name_User)
    TextView nameUser;

    Validation validation = new Validation();

    String manager;

    @InjectView(R.id.menu_photo)
    ImageView menu_photo;

    @InjectView(R.id.settingsMenu)
    ImageView settings;
    String userCode;

    @InjectView(R.id.first_item_menu)
    TextView  firstItemMenu;

    @InjectView(R.id.second_item_menu)
    TextView secondItemMenu;

    IValidateInternet iValidateInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.inject(this);
        SecurePreferences settings = new SecurePreferences(this);
        String userName = settings.getString(Constants.USER_NAME);
        String userLastName = settings.getString(Constants.USER_LASTNAME);
        String urlImage = settings.getString(Constants.URLUSERPHOTO);
        manager = settings.getString(Constants.IG_USER).toString();
        userCode = settings.getString(Constants.USER_CODIGO);
        validatePhoto(urlImage);
        validateManager(manager);
        nameUser.setText(userName + "\n" + userLastName);
        overridePendingTransition(R.anim.expandir, R.anim.slide_out_right);
        iValidateInternet = new ValidateInternet(MenuActivity.this);
    }


    /**
     * Metodo que valida si ingresa un gerente al menú
     * para mostrar las opciones del gerente
     * @param isManager  Permitr validar si es gerente
     */
    private void validateManager(String isManager) {
        if(isManager.equals("true")){
            firstItemMenu.setText(R.string.first_item_menu_manager);
            secondItemMenu.setText(R.string.second_item_menu_manager);
        }
    }

    /**
    * Metodo que valida si el usuario tiene foto
    * @param photo  Permitr validar si tiene foto
    */
    public void validatePhoto(String photo) {
        if(photo != null){
            Picasso.with(this).load(photo).into(menu_photo);
        } else {
            Picasso.with(this).load(R.mipmap.photo).into(menu_photo);

        }
    }

    /**
     * Metodo que valida quien ingresó al menú
     * para redireccionar a los módulos correspondientes
     */
    @OnClick(R.id.Menu_RegisterTime)
    public void goToRegister() {
        if(iValidateInternet.isConnected()) {
            if (manager.equals("false")) {
                Intent intent = new Intent(MenuActivity.this, register.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, ViewTimesManagerDetailActivity.class);
                intent.putExtra(Constants.USER_CODIGO, userCode);
                startActivity(intent);
            }
        }else{
            ShowAlertDialogValidateInternet.showAlertDialogValidateInternet(R.string.title_internet,R.string.text_interntet, MenuActivity.this);

        }

    }

    /**
     * Metodo que valida quien ingresó al menú
     * para redireccionar a los módulos correspondientes
     */
    @OnClick(R.id.Menu_viewtimereport)
    public void goToViewTimes() {
        if(iValidateInternet.isConnected()) {
            if (manager.equals("false")) {
                Intent intent = new Intent(MenuActivity.this, ViewTimes.class);
                intent.putExtra(Constants.USER_CODIGO, userCode);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, ViewTimesManager.class);
                intent.putExtra(Constants.USER_CODIGO, userCode);
                startActivity(intent);
            }
        }else {
            ShowAlertDialogValidateInternet.showAlertDialogValidateInternet(R.string.title_internet,R.string.text_interntet, MenuActivity.this);
        }

    }

    /**
     * Metodo que permite cerrar la aplicación al ir atrás
     */
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    /**
     * Metodo que permite cerrar sesión
     */
    @OnClick(R.id.settingsMenu)
    public void goToSettings() {
        PopupMenu popupMenup = new PopupMenu(MenuActivity.this, settings);
        popupMenup.getMenuInflater().inflate(R.menu.menu_item, popupMenup.getMenu());
        popupMenup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.exit) {
                    SecurePreferences settings = new SecurePreferences(MenuActivity.this);
                    settings.put("RememberAccess", null);
                    settings.put("username", null);
                    finish();
                }
                return true;
            }
        });
        popupMenup.show();
    }

}

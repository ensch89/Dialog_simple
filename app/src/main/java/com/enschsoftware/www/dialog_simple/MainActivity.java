package com.enschsoftware.www.dialog_simple;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {
    TextView tv,tvd;
    EditText editText1,editText2;
    int id=0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView);
        Button boton1= (Button) findViewById(R.id.button1);
        boton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showDialog(id);
    }

    @Override
    protected Dialog onCreateDialog(int id){

        Dialog dialogo = new Dialog(this);

        // Modificar una propiedad de Window
        // Esto solo es necesario si queremos personalizar
        // la ventana
        Window w = dialogo.getWindow();
// flag para desenfocar el fondo
//		int flag = WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
// flag para oscurecer el fondo
//		int flag = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
// flag para mostrar el fondo del escritorio
        int flag = WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER;
        w.setFlags(flag,flag);

        // creación de un diálogo personalizado
        dialogo.setTitle("Dialogo básico");
        dialogo.setContentView(R.layout.dialog);
        tvd = (TextView) dialogo.findViewById(R.id.textViewDialogo);
        editText1=(EditText) dialogo.findViewById(R.id.editText1);
        editText2=(EditText) dialogo.findViewById(R.id.editText2);
        Button botonDialogo=(Button) dialogo.findViewById(R.id.buttonDialogo);
        botonDialogo.setOnClickListener(new AceptarListener());
        return dialogo;
    }

    class AceptarListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String username= editText1.getText().toString().trim();
            String password= editText2.getText().toString().trim();
            if(username.matches("albert")&& password.matches("einstein")){
                dismissDialog(id);
                tv.setText("Welcome, "+username);
            }
            else
                tvd.setText("Erro User/password "+username+
                        " "+password+
                        "\n  Insert again User/password");
        }
    }  // end AceptarListener
}
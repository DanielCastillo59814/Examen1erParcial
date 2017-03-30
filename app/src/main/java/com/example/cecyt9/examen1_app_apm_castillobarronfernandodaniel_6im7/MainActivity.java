package com.example.cecyt9.examen1_app_apm_castillobarronfernandodaniel_6im7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo que realiza la conversion de MXN a USD
    //Y manda el resultado a la actividad 2
    public void onClickConvertir(View vista){
        EditText cantidad = (EditText)findViewById(R.id.cantidad);
        if(cantidad.getText().toString().matches("^\\d*(\\.\\d+)?$")){
            Intent intento = new Intent(this,Activity2.class);
            Bundle recipiente = new Bundle();
            recipiente.putDouble("resultado",Double.parseDouble(cantidad.getText().toString())/15);
            intento.putExtras(recipiente);
            this.finish();
            this.startActivity(intento);
        }else{
            new AlertDialog.Builder(vista.getContext())
                    .setTitle("Alto ahí!")
                    .setMessage("Solo puedes ingresar valores numericos enteros o decimales.")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}

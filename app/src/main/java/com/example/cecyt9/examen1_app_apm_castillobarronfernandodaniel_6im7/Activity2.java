package com.example.cecyt9.examen1_app_apm_castillobarronfernandodaniel_6im7;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private String resultado;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Codigo agregado: recibe el resultado de la intencion
        //Y lo concatena con el TextView texto
        Bundle recibido = getIntent().getExtras();
        texto = (TextView)findViewById(R.id.texto);
        resultado = String.format("%.2f",new Double(recibido.getDouble("resultado")));
        texto.setText(texto.getText().toString() + resultado + " USD");
    }

    //Metodo para enviar el resultado
    //Por correo electronico
    public void onClickEnviar(View vista){
        Intent intento = new Intent(Intent.ACTION_SEND);
        intento.setType("text/plain");
        intento.putExtra(Intent.EXTRA_EMAIL,new String[]{"eoropezag@ipn.mx"});
        intento.putExtra(Intent.EXTRA_SUBJECT, "Examen 1er Parcial");
        intento.putExtra(Intent.EXTRA_TEXT, texto.getText().toString());
        try{
            startActivity(intento);
        }catch(Exception e){
            new AlertDialog.Builder(vista.getContext())
                    .setTitle("Algo salió mal")
                    .setMessage(e.getMessage() + " \\n Causado por: " + e.getCause())
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

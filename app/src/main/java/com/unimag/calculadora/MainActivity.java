package com.unimag.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaramos los botones
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bmas,bmenos,bpor,bdiv, bsqrt, binv, bigual,bc;
    //Declaramos el texto
    EditText dato;
    TextView historial;
    float acum=0;
    String operador=null;
    String operadorespecial = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button) findViewById(R.id.btn0);
        b1 = (Button)findViewById(R.id.btn1);
        b2 = (Button)findViewById(R.id.btn2);
        b3 = (Button)findViewById(R.id.btn3);
        b4 = (Button)findViewById(R.id.btn4);
        b5 = (Button)findViewById(R.id.btn5);
        b6 = (Button)findViewById(R.id.btn6);
        b7 = (Button)findViewById(R.id.btn7);
        b8 = (Button)findViewById(R.id.btn8);
        b9 = (Button)findViewById(R.id.btn9);
        bmas = (Button)findViewById(R.id.btnmas);
        bmenos = (Button)findViewById(R.id.btnmenos);
        bpor = (Button)findViewById(R.id.btnpor);
        bdiv = (Button)findViewById(R.id.btndiv);
        bsqrt = (Button)findViewById(R.id.btnsqrt);
        binv = (Button)findViewById(R.id.btninv);
        bc = (Button)findViewById(R.id.btnc);
        bigual = (Button)findViewById(R.id.btnigual);
        dato = (EditText) findViewById(R.id.edtdato);
        historial = (TextView) findViewById(R.id.historial);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b0.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bmas.setOnClickListener(this);
        bmenos.setOnClickListener(this);
        bpor.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bsqrt.setOnClickListener(this);
        bigual.setOnClickListener(this);
        bc.setOnClickListener(this);
        binv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String valor;
        String copiaHistorial = "";
        float num=0;
        if(!TextUtils.isEmpty(dato.getText().toString())){
            num = Float.parseFloat(dato.getText().toString());
            valor = dato.getText().toString();
        }
        else{
            valor="";
        }
        switch (v.getId()) {
            case R.id.btn0:
                if (num != 0 && operador != "igual") {
                    valor = valor + "0";
                    dato.setText(valor);
                }
                break;
            case R.id.btn1:
                if(operador == "igual"){
                    valor = "1";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "1";
                }
                dato.setText(valor);
                break;
            case R.id.btn2:
                if(operador == "igual"){
                    valor = "2";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "2";
                }
                dato.setText(valor);
                break;

            case R.id.btn3:
                if(operador == "igual"){
                    valor = "3";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "3";
                }
                dato.setText(valor);
                break;
            case R.id.btn4:
                if(operador == "igual"){
                    valor = "4";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "4";
                }
                dato.setText(valor);
                break;
            case R.id.btn5:
                if(operador == "igual"){
                    valor = "5";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "5";
                }
                dato.setText(valor);
                break;
            case R.id.btn6:
                if(operador == "igual"){
                    valor = "6";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "6";
                }
                dato.setText(valor);
                break;
            case R.id.btn7:
                if(operador == "igual"){
                    valor = "7";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "7";
                }
                dato.setText(valor);
                break;
            case R.id.btn8:
                if(operador == "igual"){
                    valor = "8";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "8";
                }
                dato.setText(valor);
                break;
            case R.id.btn9:
                if(operador == "igual"){
                    valor = "9";
                    historial.setText("");
                    operador = null;
                    acum = 0;
                }else{
                    valor = valor + "9";
                }
                dato.setText(valor);
                break;
            case R.id.btnmas:
                    if(acum == 0){
                        acum = Float.parseFloat(dato.getText().toString());
                    }else{
                        acum = operacion();
                    }
                    Toast.makeText(getApplicationContext(), historial.getText().toString(), Toast.LENGTH_LONG).show();
                    if(historial.getText().toString().isEmpty()){
                        historial.setText(dato.getText().toString() + " + ");
                    }else{
                        historial.setText( operadorespecial != "sqrt" && operadorespecial != "inv" ? historial.getText() +  dato.getText().toString() + " + ": historial.getText() +  " + ");
                    }
                    dato.setText("");
                    operador = "suma";
                    operadorespecial = "";
                break;
            case R.id.btnmenos:
                if(acum == 0){
                    acum = Float.parseFloat(dato.getText().toString());
                }else{
                    acum = operacion();
                }

                if(historial.getText().toString().isEmpty()){
                    historial.setText( dato.getText().toString() + " - ");
                }else{
                    historial.setText( operadorespecial != "sqrt" && operadorespecial != "inv" ? historial.getText() +  dato.getText().toString() + " - ": historial.getText() +  " - ");
                }
                dato.setText("");
                operador = "resta";
                operadorespecial = "";
                break;
            case R.id.btnpor:
                if(acum == 0){
                    acum = Float.parseFloat(dato.getText().toString());
                }else{
                    acum = operacion();
                }

                if(historial.getText().toString().isEmpty()){
                    historial.setText( dato.getText().toString()+ " * ");
                }else{
                    historial.setText( operadorespecial != "sqrt" && operadorespecial != "inv" ? historial.getText() +  dato.getText().toString() + " * ": historial.getText() +  " * ");
                }
                dato.setText("");
                operador = "multiplicacion";
                operadorespecial = "";
                break;
            case R.id.btndiv:
                if(acum == 0){
                    acum = Float.parseFloat(dato.getText().toString());
                }else{
                    acum = operacion();
                }

                if(historial.getText().toString().isEmpty()){
                    historial.setText( dato.getText().toString() + " / ");
                }else{
                    historial.setText( operadorespecial != "sqrt" && operadorespecial != "inv" ? historial.getText() +  dato.getText().toString() + " / ": historial.getText() +  " / ");
                }
                dato.setText("");
                operador = "division";
                operadorespecial = "";
                break;
            case R.id.btnigual:
                if(!dato.getText().toString().isEmpty() && operador != null) {
                    historial.setText( operadorespecial != "sqrt" && operadorespecial != "inv" ? historial.getText() +  dato.getText().toString() + " = ": historial.getText() +  " = ");
                    acum = operacion();
                    dato.setText(acum + "");
                    operador = "igual";
                    operadorespecial = "";
                }
                break;
            case R.id.btnsqrt:
                if(operador == "igual"){
                    historial.setText("");
                    operador = "";
                }
                if(operadorespecial == ""){
                    copiaHistorial = historial.getText().toString();
                }
                if(historial.getText().toString().isEmpty()){
                    historial.setText( " sqrt(" + dato.getText().toString() +") ");
                }else{
                    historial.setText( copiaHistorial + " sqrt(" + dato.getText().toString() +") ");
                }
                operadorespecial = "sqrt";
                dato.setText( (float) Math.sqrt(Float.parseFloat(dato.getText().toString())) + "");
                break;
            case R.id.btninv:
                if(operador == "igual"){
                    historial.setText("");
                    operador = "";
                }
                if(operadorespecial == ""){
                    copiaHistorial = historial.getText().toString();
                }
                if(historial.getText().toString().isEmpty()){
                    historial.setText( " 1 / " + dato.getText().toString() +" ");
                }else{
                    historial.setText( copiaHistorial + " 1 /" + dato.getText().toString() +" ");
                }
                operadorespecial = "inv";
                dato.setText( (float) 1/Float.parseFloat(dato.getText().toString()) + " ");
                break;
            case R.id.btnc:
                historial.setText("");
                operador = null;
                acum = 0;
                dato.setText("");
        }
    }

    public float operacion(){
        float resultado = 0;
        switch (operador){
            case "suma":
                resultado = (acum + Float.parseFloat(dato.getText().toString()));
                break;
            case "resta":
                resultado =  acum - Float.parseFloat(dato.getText().toString());
                break;
            case "multiplicacion":
                resultado =  acum * Float.parseFloat(dato.getText().toString());
                break;
            case "division":
                resultado =  acum / Float.parseFloat(dato.getText().toString());
                break;
            case "igual":
                resultado =  Float.parseFloat(dato.getText().toString());
                historial.setText("");
                break;
            case "":
                resultado =  Float.parseFloat(dato.getText().toString());
                break;

        }
        return resultado;
    }
}

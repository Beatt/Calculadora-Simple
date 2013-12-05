package com.example.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * Programa: SimpleCalculator
 * Objetivo: Crear una calculadora e implementando una vista.
 * Fecha: 4/12/13
 * Autor: Jiménez M. G. G.
 */

public class MainActivity extends Activity implements OnClickListener {
	
	private Animacion animacion;
	
	private LinearLayout layoutPrincipal, 
						layoutContenedor,
						layoutAnimacion;
	
	private Button suma,
				   resta,
				   multiplicacion,
				   division;
	
	
	private TextView resultado,
					 numeroA,
					 numeroB;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Impedimos mostrar titulo de la aplicación
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//Permite solo orientación vertical.
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//View que se mostrara.
		setContentView(R.layout.activity_main);
		
		inicializarObjetosYAtributos();	
		
	}//Fin onCreate
	
	private void inicializarObjetosYAtributos(){
		
		animacion = new Animacion(this);
		
		//Botones de operaciones.
		suma = (Button) findViewById(R.id.suma);
		resta = (Button) findViewById(R.id.resta);
		multiplicacion = (Button) findViewById(R.id.multiplicacion);
		division = (Button) findViewById(R.id.division);
	
		//Habilitamos botones para el evento onClickListener
		suma.setOnClickListener(this);
		resta.setOnClickListener(this);
		multiplicacion.setOnClickListener(this);
		division.setOnClickListener(this);
		
		//Donde se mostrara el resultado
		resultado = (TextView) findViewById(R.id.resultado);
		
		//Donde se insertaran los números para calcular.
		numeroA = (TextView) findViewById(R.id.valora);
		numeroB = (TextView) findViewById(R.id.valorb);
		
		//Layout principal.
		layoutPrincipal = (LinearLayout) findViewById(R.id.principal);
		layoutPrincipal.setBackgroundResource(R.drawable.dummie);
		
		//Layout de animación
		layoutAnimacion = (LinearLayout) findViewById(R.id.animacion);
		layoutAnimacion.addView(animacion);
		
		//Creamos un layout, el cual va contener botones de las operaciones.
		layoutContenedor = (LinearLayout) findViewById(R.id.contenedor);
		LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layoutContenedor.getLayoutParams();
		params.topMargin = 1;
		layoutContenedor.setLayoutParams(params);
		

	}//Fin inicializarObjetosYAtributos

	@Override
	public void onClick(View v) {
		
		//Si los textview se encuentran vacios, no realiza nada.
		if( !(numeroA.getText().toString().isEmpty() |  numeroB.getText().toString().isEmpty()) )
		{
			resultado.setText("");
			
			
			double valorA = Double.parseDouble(numeroA.getText().toString());
			double valorB = Double.parseDouble(numeroB.getText().toString());
			
			//Id presiona es igual a suma, resta, división o multiplicación.
			if(v.getId() == R.id.suma)
			{	
				resultado.setText("Resultado: " + (valorA + valorB) );
			}
			else if(v.getId() == R.id.resta)
			{
				resultado.setText("Resultado: " + (valorA - valorB) );
			}
			else if(v.getId() == R.id.multiplicacion)
			{
				resultado.setText("Resultado: " + (valorA * valorB) );
			}
			else if(v.getId() == R.id.division)
			{
				resultado.setText("Resultado: " + (valorA / valorB) );
			}
		}
		
	}//Fin onClick

	
}//Fin class MainActivity

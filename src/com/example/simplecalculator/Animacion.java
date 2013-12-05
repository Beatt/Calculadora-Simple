package com.example.simplecalculator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class Animacion extends View implements Runnable{

	private int contMovimiento = 2;
	private Bitmap imagen;
	private int imgX;
	private Thread hilo;
	
	public Animacion(Context context) {
		super(context);

		//Creamos una imagenBit
		imagen = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
		
		//Lanzamos el thread.
		hilo = new Thread(this);
		hilo.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		if(imgX < 0 || imgX > 150)
		{
			contMovimiento = -contMovimiento;
		}
		imgX += contMovimiento;
		canvas.drawBitmap(imagen, imgX, 0, null);
		invalidate();
		
	}//fin onDraw

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}//Fin class Calculadora

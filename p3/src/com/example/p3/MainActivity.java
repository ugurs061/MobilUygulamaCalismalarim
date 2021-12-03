package com.example.p3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	
	//1-nesne tan�mlama
	LinearLayout arkaplan;
	Button sm,rd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//2-nesne-widget e�le�tirme
		arkaplan=(LinearLayout)findViewById(R.id.arkaplan);
		sm=(Button)findViewById(R.id.sm);
		rd=(Button)findViewById(R.id.rd);
		
		//3-nesne-widget ile contextmenu ba�lama
		registerForContextMenu(sm);
		registerForContextMenu(rd);
		registerForContextMenu(arkaplan);
	}
	//A-CONTEXT MENU OLU�TURMA FONKS�YONU
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.getId()==R.id.sm)//e�er sosyal medya butonuna bas�ld� ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.sosyal_medya, menu);//sosyal medya men�s� y�kleme i�lemi
		}
		if(v.getId()==R.id.rd)//e�er renk de�i�tir butonuna bas�ld� ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.renk_degistir, menu);//renk_degistir men�s� y�kleme i�lemi
		}
		else 
		{
			
		}

	}
	//B-CONTEXT MENUDEN ELEMAN SE�ME FONKS�YONU
	public boolean onContextItemSelected(MenuItem item) {
		Intent sayfa;//bir activty �al��t�rmak i�in kullan�l�r
		switch (item.getItemId()) {
		case R.id.kirmizi:
			arkaplan.setBackgroundColor(Color.RED);//arkaplan rengi k�rm�z�
			break;
		case R.id.yesil:
			arkaplan.setBackgroundColor(Color.GREEN);//arkaplan rengi ye�il
			break;
		case R.id.mavi:
			arkaplan.setBackgroundColor(Color.BLUE);//arkaplan rengi mavi
			break;
		case R.id.facebook:
			sayfa=new Intent(this,facebook.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;
		case R.id.whatsapp:
			sayfa=new Intent(this,whatsapp.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;
		case R.id.twitter:
			sayfa=new Intent(this,twitter.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;
		case R.id.instagram:
			sayfa=new Intent(this,instagram.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
	//C-OPT�ON MENU OLU�TURMA FONKS�YONU
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sosyal_medya, menu);//sosyal_medya men� giydirme
		
		return super.onCreateOptionsMenu(menu);
	}
	//D-OPT�ON MEN�DEN ELEMAN SE�ME FONKS�YONU
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent sayfa;//bir activty �al��t�rmak i�in kullan�l�r
		switch (item.getItemId()) {
		case R.id.facebook:
			sayfa=new Intent(this,facebook.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;
		case R.id.whatsapp:
			sayfa=new Intent(this,whatsapp.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;
		case R.id.twitter:
			sayfa=new Intent(this,twitter.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;
		case R.id.instagram:
			sayfa=new Intent(this,instagram.class); //intent tan�mlama
			startActivity(sayfa);//activty �al��t�rma
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}

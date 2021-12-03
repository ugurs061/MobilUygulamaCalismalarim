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
	
	//1-nesne tanýmlama
	LinearLayout arkaplan;
	Button sm,rd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//2-nesne-widget eþleþtirme
		arkaplan=(LinearLayout)findViewById(R.id.arkaplan);
		sm=(Button)findViewById(R.id.sm);
		rd=(Button)findViewById(R.id.rd);
		
		//3-nesne-widget ile contextmenu baðlama
		registerForContextMenu(sm);
		registerForContextMenu(rd);
		registerForContextMenu(arkaplan);
	}
	//A-CONTEXT MENU OLUÞTURMA FONKSÝYONU
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.getId()==R.id.sm)//eðer sosyal medya butonuna basýldý ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.sosyal_medya, menu);//sosyal medya menüsü yükleme iþlemi
		}
		if(v.getId()==R.id.rd)//eðer renk deðiþtir butonuna basýldý ise
		{
			super.onCreateContextMenu(menu, v, menuInfo);
			getMenuInflater().inflate(R.menu.renk_degistir, menu);//renk_degistir menüsü yükleme iþlemi
		}
		else 
		{
			
		}

	}
	//B-CONTEXT MENUDEN ELEMAN SEÇME FONKSÝYONU
	public boolean onContextItemSelected(MenuItem item) {
		Intent sayfa;//bir activty çalýþtýrmak için kullanýlýr
		switch (item.getItemId()) {
		case R.id.kirmizi:
			arkaplan.setBackgroundColor(Color.RED);//arkaplan rengi kýrmýzý
			break;
		case R.id.yesil:
			arkaplan.setBackgroundColor(Color.GREEN);//arkaplan rengi yeþil
			break;
		case R.id.mavi:
			arkaplan.setBackgroundColor(Color.BLUE);//arkaplan rengi mavi
			break;
		case R.id.facebook:
			sayfa=new Intent(this,facebook.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;
		case R.id.whatsapp:
			sayfa=new Intent(this,whatsapp.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;
		case R.id.twitter:
			sayfa=new Intent(this,twitter.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;
		case R.id.instagram:
			sayfa=new Intent(this,instagram.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
	//C-OPTÝON MENU OLUÞTURMA FONKSÝYONU
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sosyal_medya, menu);//sosyal_medya menü giydirme
		
		return super.onCreateOptionsMenu(menu);
	}
	//D-OPTÝON MENÜDEN ELEMAN SEÇME FONKSÝYONU
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent sayfa;//bir activty çalýþtýrmak için kullanýlýr
		switch (item.getItemId()) {
		case R.id.facebook:
			sayfa=new Intent(this,facebook.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;
		case R.id.whatsapp:
			sayfa=new Intent(this,whatsapp.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;
		case R.id.twitter:
			sayfa=new Intent(this,twitter.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;
		case R.id.instagram:
			sayfa=new Intent(this,instagram.class); //intent tanýmlama
			startActivity(sayfa);//activty çalýþtýrma
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}

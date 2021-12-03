package com.example.p4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class detay extends Activity {

	//1-nesne tan�mlama
	ImageView takimlogo;
	TextView takimadi,takimsehir, takimstad, takimkapasite,takimdirektor,takimbaskani,takimkaptan;
	//1-dizi tan�mlama
	String [] tak�mad�;
	String [] logo;
	String [] �ehir;
	String [] stad;
	String [] kapasite;
	String [] ba�kan;
	String [] teknikdirekt�r;
	String [] kaptan;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detay);//layout y�kleme
		
		//2- nesne widget e�le�tirme
		takimlogo=(ImageView)findViewById(R.id.takimlogo);
		takimadi=(TextView)findViewById(R.id.takimadi);
		takimsehir=(TextView)findViewById(R.id.takimsehir);
		takimstad=(TextView)findViewById(R.id.takimstad);
		takimkapasite=(TextView)findViewById(R.id.takimkapasite);
		takimdirektor=(TextView)findViewById(R.id.takimdirektor);
		takimbaskani=(TextView)findViewById(R.id.takimbaskani);
		takimkaptan=(TextView)findViewById(R.id.takimkaptan);
		
		//2-bilgi.xml i�erisindeki dizilerden de�er �ekerek dizi olu�turuluyor
		tak�mad�=getResources().getStringArray(R.array.ad);
		logo=getResources().getStringArray(R.array.logo);
		�ehir=getResources().getStringArray(R.array.sehir);
		stad=getResources().getStringArray(R.array.stad);
		kapasite=getResources().getStringArray(R.array.kapasite);
		ba�kan=getResources().getStringArray(R.array.baskan);
		teknikdirekt�r=getResources().getStringArray(R.array.teknikdirektor);
		kaptan=getResources().getStringArray(R.array.kaptan);
		
		//3- MainActivity den gelen index bulunuyor
		Intent sayfa=getIntent();//MainActivity den gelen Intent bilgisi
		int index=Integer.parseInt(sayfa.getStringExtra("index"));// se�ilen eleman�n indeksi
		
		//4-tak�m bilgisi g�sterme i�lemi
		
		takimlogo.setImageResource(this.getResources().getIdentifier(logo[index] , "drawable" , this.getPackageName()));
		takimadi.setText(tak�mad�[index]);
		takimsehir.setText(�ehir[index]);
		takimstad.setText(stad[index]);
		takimkapasite.setText(kapasite[index]);
		takimdirektor.setText(teknikdirekt�r[index]);
		takimbaskani.setText(ba�kan[index]);
		takimkaptan.setText(kaptan[index]);
		
	}
}

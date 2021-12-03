package com.example.p4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class detay extends Activity {

	//1-nesne tanýmlama
	ImageView takimlogo;
	TextView takimadi,takimsehir, takimstad, takimkapasite,takimdirektor,takimbaskani,takimkaptan;
	//1-dizi tanýmlama
	String [] takýmadý;
	String [] logo;
	String [] þehir;
	String [] stad;
	String [] kapasite;
	String [] baþkan;
	String [] teknikdirektör;
	String [] kaptan;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detay);//layout yükleme
		
		//2- nesne widget eþleþtirme
		takimlogo=(ImageView)findViewById(R.id.takimlogo);
		takimadi=(TextView)findViewById(R.id.takimadi);
		takimsehir=(TextView)findViewById(R.id.takimsehir);
		takimstad=(TextView)findViewById(R.id.takimstad);
		takimkapasite=(TextView)findViewById(R.id.takimkapasite);
		takimdirektor=(TextView)findViewById(R.id.takimdirektor);
		takimbaskani=(TextView)findViewById(R.id.takimbaskani);
		takimkaptan=(TextView)findViewById(R.id.takimkaptan);
		
		//2-bilgi.xml içerisindeki dizilerden deðer çekerek dizi oluþturuluyor
		takýmadý=getResources().getStringArray(R.array.ad);
		logo=getResources().getStringArray(R.array.logo);
		þehir=getResources().getStringArray(R.array.sehir);
		stad=getResources().getStringArray(R.array.stad);
		kapasite=getResources().getStringArray(R.array.kapasite);
		baþkan=getResources().getStringArray(R.array.baskan);
		teknikdirektör=getResources().getStringArray(R.array.teknikdirektor);
		kaptan=getResources().getStringArray(R.array.kaptan);
		
		//3- MainActivity den gelen index bulunuyor
		Intent sayfa=getIntent();//MainActivity den gelen Intent bilgisi
		int index=Integer.parseInt(sayfa.getStringExtra("index"));// seçilen elemanýn indeksi
		
		//4-takým bilgisi gösterme iþlemi
		
		takimlogo.setImageResource(this.getResources().getIdentifier(logo[index] , "drawable" , this.getPackageName()));
		takimadi.setText(takýmadý[index]);
		takimsehir.setText(þehir[index]);
		takimstad.setText(stad[index]);
		takimkapasite.setText(kapasite[index]);
		takimdirektor.setText(teknikdirektör[index]);
		takimbaskani.setText(baþkan[index]);
		takimkaptan.setText(kaptan[index]);
		
	}
}

package com.example.p5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class detay extends Activity {

	//1-nesne tan�mlama
	ImageView dunyalogo;
	TextView ulkead,bolgead, ulkeparabirimi, ulkenufus,ulkebaskent,ulkedil,ulkebaskan;
	//1-dizi tan�mlama
	String [] ad;
	String [] logo;
	String [] bolge;
	String [] parabirimi;
	String [] nufus;
	String [] baskent;
	String [] dil;
	String [] baskan;

	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detay);//layout y�kleme
		
		//2- nesne widget e�le�tirme
		dunyalogo=(ImageView)findViewById(R.id.dunyalogo);
		ulkead=(TextView)findViewById(R.id.ulkead);
		bolgead=(TextView)findViewById(R.id.bolgead);
		ulkeparabirimi=(TextView)findViewById(R.id.ulkeparabirimi);
		ulkenufus=(TextView)findViewById(R.id.ulkenufus);
		ulkebaskent=(TextView)findViewById(R.id.ulkebaskent);
		ulkedil=(TextView)findViewById(R.id.ulkedil);
		ulkebaskan=(TextView)findViewById(R.id.ulkebaskan);
		
		//2-bilgi.xml i�erisindeki dizilerden de�er �ekerek dizi olu�turuluyor
		ad=getResources().getStringArray(R.array.ad);
		logo=getResources().getStringArray(R.array.logo);
		bolge=getResources().getStringArray(R.array.bolge);
		parabirimi=getResources().getStringArray(R.array.parabirimi);
		nufus=getResources().getStringArray(R.array.nufus);
		baskent=getResources().getStringArray(R.array.baskent);
		dil=getResources().getStringArray(R.array.dil);
		baskan=getResources().getStringArray(R.array.baskan);
		
		//3- MainActivity den gelen index bulunuyor
		Intent sayfa=getIntent();//MainActivity den gelen Intent bilgisi
		int index=Integer.parseInt(sayfa.getStringExtra("index"));// se�ilen eleman�n indeksi
		
		//4-tak�m bilgisi g�sterme i�lemi
		
		dunyalogo.setImageResource(this.getResources().getIdentifier(logo[index] , "drawable" , this.getPackageName()));
		ulkead.setText(ad[index]);
		bolgead.setText(bolge[index]);
		ulkeparabirimi.setText(parabirimi[index]);
		ulkenufus.setText(nufus[index]);
		ulkebaskent.setText(baskent[index]);
		ulkedil.setText(dil[index]);
		ulkebaskan.setText(baskan[index]);
		
	}
}

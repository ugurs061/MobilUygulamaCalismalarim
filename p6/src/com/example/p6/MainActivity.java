package com.example.p6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.net.URL;

//html parse etmek için kullanýlýr
//html sayfasýndan veri çekmek için kullanýlýr
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends Activity {
	
	//1-nesne tanýmlama
	ListView listView1;
	TextView TextView2,TextView4,TextView6,TextView8,TextView10;
	String [] dövizcinsi;
	String [] alýþfiyatý;
	String [] satýþfiyatý;
	String [] efektifalýþ;
	String [] efektifsatýþ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//2-nesne-widget eþleþtirme
		 
		listView1=(ListView)findViewById(R.id.listView1);  
		TextView2=(TextView)findViewById(R.id.TextView2);
		TextView4=(TextView)findViewById(R.id.TextView4);
		TextView6=(TextView)findViewById(R.id.TextView6);
		TextView8=(TextView)findViewById(R.id.TextView8);
		TextView10=(TextView)findViewById(R.id.TextView10);
		 
		new DövizGetir().execute();
		
		//listView elaman seçme olayý
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				 
				/*Intent verigönderici=new Intent(getApplicationContext(),detay.class); //çalýþtýlacak sýnýf/activty
				verigönderici.putExtra("index", position+"");//deðiþken tanýmlama
				startActivity(verigönderici); //activty çalýþtýrma
			*/
				TextView2.setText(bilgi.dövizcinsi[position]);
				TextView4.setText(bilgi.alýþfiyatý[position]);
				TextView6.setText(bilgi.satýþfiyatý[position]);
				TextView8.setText(bilgi.efektifalýþ[position]);
				TextView10.setText(bilgi.efektifsatýþ[position]);
				
			}
		});
		
	}
	
	// Async sýnýfý sýnavda çýkar !!!!!!!
	public class DövizGetir extends AsyncTask<Void, Void, Void>
	{
		ProgressDialog dialog;
		Element tablo;
		Elements baþlýk,döviz;
		URL url;
		//ÖN ÝÞLEM AÞAMASI-HAZIRLIK AÞAMASI
		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			dialog=new ProgressDialog(MainActivity.this);
			dialog.setTitle("KUR BÝLGÝLERÝ");//baþlýk
			dialog.setMessage("Bilgiler Yükleniyor..."); //dialog kutusu bilgileri
			dialog.setIndeterminate(false);
			dialog.show();//dialog kutusunu göster
		}
	
		//ARKAPLANDA EÞ ZAMANLI ÇALIÞAN  FONKSÝYON
		//VERÝ ÇEKME-ÝÞLEME YAPAN  FONKSÝYON
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				
				url=new URL("https://www.turkiye.gov.tr/doviz-kurlari");
				Document doc = Jsoup.parse(url, 3000);//web sayafasýnda veri(html kodlarý) çekiliyor
				tablo = doc.select("thead").get(0); //baþlýk olan tabloyu seç
				baþlýk = tablo.select("tr>th");//tr içindeki th larý seç//baþlýklar
				tablo = doc.select("tbody").get(0); //döviz/kur bilgilerinin olduðu tabloyu seç
				döviz   = tablo.select("tr");//döviz/kur bilgilerini al
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		
		//SON ÝÞLEM AÞAMASI-HAZIRLIK AÞAMASI
		//VERÝ-SONUÇ GÖSTERME YAPAN FONKSÝYON
		@Override
		protected void onPostExecute(Void result) 
		{
			super.onPostExecute(result);
			Elements dovizbilgisi;
			bilgi.dövizcinsi=new String[döviz.size()];
			bilgi.alýþfiyatý=new String[döviz.size()];
			bilgi.satýþfiyatý=new String[döviz.size()];
			bilgi.efektifalýþ=new String[döviz.size()];
			bilgi.efektifsatýþ=new String[döviz.size()];

			for(int i=0;i<döviz.size();i++)
			{
			dovizbilgisi=döviz.get(i).select("td");
			bilgi.dövizcinsi[i]=dovizbilgisi.get(0).text();//döviz cinsi
			bilgi.alýþfiyatý[i]=dovizbilgisi.get(1).text();//döviz alýþ
			bilgi.satýþfiyatý[i]=dovizbilgisi.get(2).text();//döviz satýþ
			bilgi.efektifalýþ[i]=dovizbilgisi.get(3).text();//efectif alýþ
			bilgi.efektifsatýþ[i]=dovizbilgisi.get(4).text();//efectif satýþ
			}
			
			ListeOlustur adapter=new ListeOlustur(MainActivity.this, bilgi.dövizcinsi); 
			listView1.setAdapter(adapter);
			
			dialog.dismiss();//dialog kutusunu kapat
		}
		
	}
	
	
}

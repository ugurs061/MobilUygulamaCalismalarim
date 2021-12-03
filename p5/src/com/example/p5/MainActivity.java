package com.example.p5;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	//1- nesne tanýmlama 
	ListView listView1;
	//1-dizi tanýmlama
	String[]logolistesi,isimlistesi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//2-bilgi.xml içerisindeki dizilerden deðer çekerek dizi oluþturuluyor
		logolistesi=getResources().getStringArray(R.array.logo);
		isimlistesi=getResources().getStringArray(R.array.ad);

		
		//3-listView1 doldurma iþlemi
		ListeOlustur adapter=new ListeOlustur(this, logolistesi, isimlistesi);
		listView1=(ListView)findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
		
		//4-listView1 eleman seçme iþlemi
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				
				
				//Intnet activityler arasý veri aktarmak için kullanýlýr
				Intent sayfa=new Intent(getApplicationContext(),detay.class);// bu activityden detay activty sine geçiþ yapýlacak
				sayfa.putExtra("index", position+"");//seçilen elemanýn indeksi parametre
				startActivity(sayfa);//detay activitysi çalýþtýrýlýyor
			}
			

		
		});
		
	}
}

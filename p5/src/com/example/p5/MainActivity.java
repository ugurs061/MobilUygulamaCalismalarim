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

	//1- nesne tan�mlama 
	ListView listView1;
	//1-dizi tan�mlama
	String[]logolistesi,isimlistesi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//2-bilgi.xml i�erisindeki dizilerden de�er �ekerek dizi olu�turuluyor
		logolistesi=getResources().getStringArray(R.array.logo);
		isimlistesi=getResources().getStringArray(R.array.ad);

		
		//3-listView1 doldurma i�lemi
		ListeOlustur adapter=new ListeOlustur(this, logolistesi, isimlistesi);
		listView1=(ListView)findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
		
		//4-listView1 eleman se�me i�lemi
		listView1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				
				
				//Intnet activityler aras� veri aktarmak i�in kullan�l�r
				Intent sayfa=new Intent(getApplicationContext(),detay.class);// bu activityden detay activty sine ge�i� yap�lacak
				sayfa.putExtra("index", position+"");//se�ilen eleman�n indeksi parametre
				startActivity(sayfa);//detay activitysi �al��t�r�l�yor
			}
			

		
		});
		
	}
}

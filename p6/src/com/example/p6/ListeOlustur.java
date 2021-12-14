package com.example.p6;

import android.app.Activity;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;  
import android.widget.ImageView;  
import android.widget.TextView;  
/**
 * @author user
 *
 */
public class ListeOlustur extends  ArrayAdapter<String> {  
  
	 	private final Activity context;  	//mainactivty
	    private final String[] d�vizcinsi;    //tak�m adlar� i�in
	  
	    public ListeOlustur(Activity context, String[] d�vizcinsi) {  
	        super(context, R.layout.sablon, d�vizcinsi);  //�ablon se�imi
	        // TODO Auto-generated constructor stub  
	  
	        //nesne e�le�tirme
	        this.context=context;  
	        this.d�vizcinsi=d�vizcinsi;   
	     
	  
    }  
  
    //sablon giydirme i�lemi
    public View getView(int position,View view,ViewGroup parent) {  
        LayoutInflater inflater=context.getLayoutInflater();  
        View rowView=inflater.inflate(R.layout.sablon, null,true);  //sat�r olu�turma
  
        //�ablon listview item e�le�tirme
        TextView d�vizad� = (TextView) rowView.findViewById(R.id.tv);    //�ablondaki dovizcinsi
        
        //d�vizcinsi yerle�tirme i�lemi
        d�vizad�.setText(d�vizcinsi[position]);  
        
        return rowView;  //olu�an sat�r
  
    };  
}  
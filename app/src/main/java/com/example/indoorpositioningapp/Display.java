package com.example.indoorpositioningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;


public class Display extends AppCompatActivity {
    private String []stri={"boson_sunya","library_sunya","sunya_library","hercules_bohr","hercules_skywalk","skywalk_ccf","skywalk_arc","ccf_skywalk","ccf_arc","arc_skywalk","arc_ccf"};
    private Integer[][] ph={{R.drawable.boson_sunya0,R.drawable.boson_sunya1,R.drawable.boson_sunya2,R.drawable.boson_sunya3},{R.drawable.library_sunya},{R.drawable.sunya_library},{R.drawable.hercules_bohr},{R.drawable.hercules_skywalk},{R.drawable.skywalk_ccf},{R.drawable.skywalk_arc},{R.drawable.ccf_skywalk},{R.drawable.ccf_arc},{R.drawable.arc_skywalk},{R.drawable.arc_ccf}};
    int val1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);


        Intent intent = getIntent();
        String str = intent.getStringExtra("EXTRA_SESSION_ID");


        int i;
        for (i = 0; i <= stri.length; i++)
            if (stri[i].equals(str)) {
                if(ph[i].length==1)
                {
                    ImageView iv = findViewById(R.id.imageView);
                    iv.setImageResource(ph[i][0]);
                    break;}
            }
    }


    public void next(View view){
        val1++;
    }
    public void prev(View view){}

}

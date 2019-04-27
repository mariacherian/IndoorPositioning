package com.example.indoorpositioningapp;


import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;




public class MainActivity extends AppCompatActivity {
    int i,val1,val2;
    private RadioGroup radiogroup;
    private ImageView imageviewphoto;
    //private String []stri={"library_sunya","sunya_library","hercules_bohr","hercules_skywalk","skywalk_ccf","skywalk_arc","ccf_skywalk","ccf_arc","arc_skywalk","arc_ccf"};
    //private Integer []ph={R.drawable.library_sunya,R.drawable.sunya_library,R.drawable.hercules_bohr,R.drawable.hercules_skywalk,R.drawable.skywalk_ccf,R.drawable.skywalk_arc,R.drawable.ccf_skywalk,R.drawable.ccf_arc,R.drawable.arc_skywalk,R.drawable.arc_ccf};
    private Integer []photos= {R.drawable.mapg,R.drawable.mapf,R.drawable.maps,R.drawable.mapt};
    String str;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner mySpinner =findViewById(R.id.spinner1);
        final Spinner mySpinner2 =findViewById(R.id.spinner2);
        Button nav_button = findViewById(R.id.nav_button);
        this.imageviewphoto=findViewById(R.id.imageView);
        this.radiogroup= findViewById(R.id.radiogp);
        this.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

                                                       @Override
                                                       public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                           RadioButton radioButton=(RadioButton) group.findViewById(checkedId);
                                                           int index= group.indexOfChild(radioButton);
                                                           imageviewphoto.setImageResource(photos[index]);

                                                       }


                                                   });



        ArrayAdapter<String>myAdapter =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);



        ArrayAdapter<String>myAdapter2 =new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names2));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);



        nav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = mySpinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "CURRENT LOCATION : " + s1, Toast.LENGTH_SHORT).show();
                String s2 = mySpinner2.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "TARGET LOCATION : " + s2, Toast.LENGTH_SHORT).show();
                str=s1+'_'+s2;


                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getBaseContext(),Display.class);
               intent.putExtra("EXTRA_SESSION_ID", str);
               startActivity(intent);



            }
        });




    }}





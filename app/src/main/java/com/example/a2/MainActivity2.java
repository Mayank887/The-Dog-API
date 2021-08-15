package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    ImageView iv;
    TextView textView6;
    TextView textView7;
    TextView textView8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView2=findViewById(R.id.textView2);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);

        iv=findViewById(R.id.imageView);
        if(getIntent().hasExtra("origin")&&getIntent().hasExtra("temperament")){
        textView.setText(getIntent().getStringExtra("name"));
        textView2.setText("ORIGIN : "+getIntent().getStringExtra("origin"));
            textView3.setText("TEMPERAMENT : "+getIntent().getStringExtra("temperament"));
            textView4.setText("LIFE SPAN : "+getIntent().getStringExtra("lifespan"));
            textView5.setText("BREED GROUP : "+getIntent().getStringExtra("bredgrp"));
            textView6.setText("BRED FOR : "+getIntent().getStringExtra("bredfor"));
            textView7.setText("HEIGHT : "+"imperial = "+getIntent().getStringExtra("heighti")+" metric = "+getIntent().getStringExtra("heightm"));
            textView8.setText("WEIGHT : "+"imperial = "+getIntent().getStringExtra("weighti")+" metric = "+getIntent().getStringExtra("weightm"));
            //iv.setImageResource(Integer.parseInt(getIntent().getStringExtra("imgid")));
            Picasso.with(getApplicationContext())
                    .load(getIntent().getStringExtra("url"))
                    .placeholder(R.drawable.ic_launcher_background)
                    .fit()
            .into(iv);


        }
    }
}
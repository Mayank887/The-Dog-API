package com.example.a2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycle;
    List<Pojo> dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycle=findViewById(R.id.recycle);
        listingdata();

    }

    private void listingdata() {
        ApiInterface apiInterface=Retrofit.getRetrofit().create(ApiInterface.class);
        Call<List<Pojo>> listingdata=apiInterface.getPojo();
        listingdata.enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo> >response) {
                if (response.isSuccessful()){

                    recycleadapter adapter=new recycleadapter(response.body(),getApplicationContext());
                    recycle.setAdapter(adapter);
                    LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                    recycle.setLayoutManager(llm);

                }
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });



    }
    public class recycleadapter extends RecyclerView.Adapter<recycleadapter.MyViewHolder>{
        List<Pojo> list;
        Context context;

        public recycleadapter(List<Pojo > list,Context context){
            this.context=context;
            this.list=list;
        }

        @NonNull
        @org.jetbrains.annotations.NotNull
        @Override
        public recycleadapter.MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, null);
            recycleadapter.MyViewHolder viewHolder = new recycleadapter.MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull recycleadapter.MyViewHolder holder, int position) {
          

            holder.textView.setText(list.get(position).getName());
            Picasso.with(getApplicationContext())
                    .load(list.get(position).getImage().getUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .fit()
                    .into(holder.imageView);
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,MainActivity2.class);
                    intent.putExtra("origin",list.get(position).getOrigin());
                    intent.putExtra("temperament",list.get(position).getTemperament());
                    intent.putExtra("name",list.get(position).getName());
                    intent.putExtra("bredfor",list.get(position).getBred_for());
                    intent.putExtra("bredgrp",list.get(position).getBreed_group());
                    intent.putExtra("lifespan",list.get(position).getLife_span());
                    intent.putExtra("heighti",list.get(position).getHeight().getImperial());
                    intent.putExtra("heightm",list.get(position).getHeight().getMetric());
                    intent.putExtra("weighti",list.get(position).getWeight().getImperial());
                    intent.putExtra("weightm",list.get(position).getWeight().getMetric());
                    intent.putExtra("url",list.get(position).getImage().getUrl());


                 //   intent.putExtra("heighti",list.get(position).getImperial());
                   // intent.putExtra("heighti",list.get(position).getImperial());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);


                }
            });




        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            ImageView imageView;
            public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.textview);
                imageView=itemView.findViewById(R.id.imageview);
            }
        }

    }



}